package com.example.crudDTO_demo.services;

import com.example.crudDTO_demo.dto.StudentRequestDTO;
import com.example.crudDTO_demo.dto.StudentResponseDTO;
import com.example.crudDTO_demo.dto.UpdateStudentReqDTO;
import com.example.crudDTO_demo.dto.UpdateStudentResDTO;
import com.example.crudDTO_demo.exception.ResourceNotFoundException;
import com.example.crudDTO_demo.model.Student;
import com.example.crudDTO_demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
//Buisness logic
public class StudentService {

    private StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponseDTO create(StudentRequestDTO studentReqDto) {

        //converts maps the user data to entity
        Student student = mapToEntity(studentReqDto);

        //maps the entity and decides what to send

        Student studentResp = studentRepository.save(student);
        System.out.println("After Save Created At: " + studentResp.getCreatedAt());
        System.out.println("After Save Updated At: " + studentResp.getUpdatedAt());
        return mapToDTO(studentResp);

    }

    //read one student
    public StudentResponseDTO getStudent(Long id) {
        Student studentResponse = studentRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student with id "+ id+" Not found..."));
//        if (studentResponse == null) {
//            throw new RuntimeException("Student not found...");
//        }

        return mapToDTO(studentResponse);

    }

    // public student getStudent(Long id){
    //   Optional<Student> studentResponse= studentRepository.findById(id);
    //   if(studentResponse.isPresent()){
    //    return studentResponse.get();
    //   }
    //   else{
    //    return null;
    //   }
    // }

    //read all students
    public ArrayList<StudentResponseDTO> getAllStudents() {
        List<Student> studentList = studentRepository.findByIsDeletedFalse();
        ArrayList<StudentResponseDTO> responseList=new ArrayList<>();

        for(Student student:studentList){
            responseList.add(mapToDTO(student));
        }

        return responseList;
    }

    //update student
    public UpdateStudentResDTO updateStudent(UpdateStudentReqDTO studentReq, Long id) {
        Student existingStudent = studentRepository.findByIdAndIsDeletedFalse(id).orElse(null);

        if (existingStudent == null) {
            throw new ResourceNotFoundException("Student not found.... for update");
        }


        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
//        existingStudent.setEmail(student.getEmail());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSub(studentReq.getSub());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student student = studentRepository.save(existingStudent);

        UpdateStudentResDTO updatedStudent=mapToUpdateDTO(student);
        return updatedStudent;
    }

    private UpdateStudentResDTO mapToUpdateDTO(Student student) {
        UpdateStudentResDTO studentRes=new UpdateStudentResDTO();

        studentRes.setAge(student.getAge());
        studentRes.setName(student.getName());
        studentRes.setRollNo(student.getRollNo());
        studentRes.setSub(student.getSub());
        studentRes.setUpdatedAt(student.getUpdatedAt());
        studentRes.setEmail(student.getEmail());
        studentRes.setMessage("Student Updated...");
        return studentRes;
    }

    // Hard delete the student
    public StudentResponseDTO deleteStudent(Long id) {
        Student deletedStudent = studentRepository.findById(id).orElse(null);

        if (deletedStudent == null) {
            throw new ResourceNotFoundException("Requested student not available for deletion");
        }

        studentRepository.deleteById(id);
        return mapToDTO(deletedStudent);
    }

    //soft delete

    public StudentResponseDTO softDelete(Long id) {
        Student deletedStudent = studentRepository.findByIdAndIsDeletedFalse(id).orElse(null);

        if (deletedStudent == null) {
            throw new ResourceNotFoundException("Requested Student doesnt exists....sorry");
        }
        deletedStudent.setDeleted(true);
        studentRepository.save(deletedStudent);

        return mapToDTO(deletedStudent);
    }

    //maping functions
    private Student mapToEntity(StudentRequestDTO studentReq) {
        Student student = new Student();

//        student.setId(studentReq.getId());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setAge(studentReq.getAge());
        student.setDeleted(false);
        student.setEmail(studentReq.getEmail());
        student.setRollNo(studentReq.getRollNo());
        student.setName(studentReq.getName());
        student.setSub(studentReq.getSub());
        return student;
    }

    private StudentResponseDTO mapToDTO(Student studentResp) {

        StudentResponseDTO responseDto = new StudentResponseDTO();

        responseDto.setAge(studentResp.getAge());
        responseDto.setEmail(studentResp.getEmail());
        responseDto.setName(studentResp.getName());
//        responseDto.setId(studentResp.getId());
        responseDto.setSub(studentResp.getSub());
        responseDto.setRollNo(studentResp.getRollNo());
        responseDto.setCreatedAt(studentResp.getCreatedAt());
        responseDto.setUpdatedAt(studentResp.getUpdatedAt());
        responseDto.setMessage("Student Created...");
        return responseDto;

    }

}


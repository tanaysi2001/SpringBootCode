package com.example.CrudDemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CrudDemo.model.Student;
import com.example.CrudDemo.repository.StudentRepository;


@Service
//Buisness logic
public class StudentService {

   private  StudentRepository studentRepository;

   StudentService(StudentRepository studentRepository){
    this.studentRepository=studentRepository;
   }
    
    public Student create(Student studentReq){

       studentReq.setDeleted(false);
       Student studentResponse=  studentRepository.save(studentReq);
       return studentResponse;
    }

    //read one student
    public Student getStudent(Long id){
      Student studentResponse=studentRepository.findByIdAndIsDeletedFalse(id).orElse(null);
      if(studentResponse==null) return null;
      return studentResponse;
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
   public List<Student> getAllStudents(){
   List<Student> studentList =studentRepository.findByIsDeletedFalse();
   return studentList; 
   }

   //update student
   public Student updateStudent(Student student,Long id){
      Student existingStudent=studentRepository.findByIdAndIsDeletedFalse(id).orElse(null);

      if(existingStudent==null){
         return null;
      }

      existingStudent.setName(student.getName());
      existingStudent.setAge(student.getAge());
      existingStudent.setEmail(student.getEmail());
      existingStudent.setRollNo(student.getRollNo());
      existingStudent.setSub(student.getSub());

      return  studentRepository.save(existingStudent);   
      }

      // Hard delete the student
      public Student deleteStudent(Long id){
          Student deletedStudent=studentRepository.findById(id).orElse(null);

          if(deletedStudent==null){
            return null;
          }
          studentRepository.deleteById(id);
          return deletedStudent;
      }

      //soft delete 

      public Student softDelete(Long id){
       Student deletedStudent= studentRepository.findByIdAndIsDeletedFalse(id).orElse(null);

        if(deletedStudent==null){
         return null;
        }
        deletedStudent.setDeleted(true);
        studentRepository.save(deletedStudent);

        return deletedStudent;
      }

   }


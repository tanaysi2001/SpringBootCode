package com.example.employeeManagement.service;

import com.example.employeeManagement.dto.*;
import com.example.employeeManagement.exception.EmployeeNotFoundException;
import com.example.employeeManagement.exception.InvalidSearchException;
import com.example.employeeManagement.mapperFunction.MapperFunction;
import com.example.employeeManagement.model.Employee;
import com.example.employeeManagement.repository.EmployeeRespository;
import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRespository employeeRepository;
    private MapperFunction mapper;

    //dependency injection
    public EmployeeService(EmployeeRespository employeeRepository, MapperFunction mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    //create employee
    public CreateResponseEmployeeDTO createEmployee(CreateRequestEmployeeDTO empReq) {

        Employee employee = mapper.mapToEntity(empReq);

        Employee empResp = employeeRepository.save(employee);

        return mapper.mapToDTO(empResp);
    }

    //get single employee
    public GetEmployeeResponseDTO getEmployee(Long id) {

        Employee empResp = employeeRepository.findByIdAndIsDeletedFalse(id).orElseThrow(
                //handling exceptions
                () -> new EmployeeNotFoundException("Employee With id : " + id + " Not Found..")
        );
        return mapper.mapToGetEmployeeDTO(empResp);
    }

    //get all employee
    public List<GetEmployeeResponseDTO> getAllEmployee() {
        List<Employee> empList = employeeRepository.findByIsDeletedFalse();
        ArrayList<GetEmployeeResponseDTO> list = new ArrayList<>();

        for (Employee emp : empList) {
            list.add(mapper.mapToGetEmployeeDTO(emp));
        }
        return list;
    }

    //update employee
    public UpdateEmployeeResponseDTO updateEmployee(UpdateEmployeeRequestDTO empReq, Long id) {
        Employee existingEmployee = employeeRepository.findByIdAndIsDeletedFalse(id).orElseThrow(
                //handling exceptions
                () -> new EmployeeNotFoundException("Employee With ID : " + id + " Not Found")
        );

        Employee employee = mapper.mapUpdateRequestToEntity(empReq, existingEmployee);

        Employee updatedEmployee = employeeRepository.save(employee);


        UpdateEmployeeResponseDTO response = mapper.mapUpdateRequestToDTO(updatedEmployee);
        return response;
    }

    //delete employee
    public DeleteEmployeeResponseDTO deleteEmployee(Long id) {
        Employee employee = employeeRepository.findByIdAndIsDeletedFalse(id).orElseThrow(
                //handling exceptions
                () -> new EmployeeNotFoundException("Employee With ID : " + id + " Not Found")
        );
        employeeRepository.deleteById(id);

        DeleteEmployeeResponseDTO response = mapper.mapDeleteRequestToDTO(employee);
        return response;
    }

    //soft delete employee
    public SoftDeleteEmployeeResponseDTO softDelete(Long id) {
        Employee empRes = employeeRepository.findById(id).orElseThrow(
                //handling exceptions
                () -> new EmployeeNotFoundException("Employee With ID : " + id + " Not Found")
        );
        empRes.setDeleted(true);
        employeeRepository.save(empRes);
        return mapper.mapSoftDeleteRequestToDTO(empRes);
    }

    //search by name
    public List<SearchByNameEmployeeResponseDTO> searchByName(String name) {

        //handling th exception
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidSearchException("Name Cannot be null");
        }
        List<Employee> employeeList = employeeRepository.findByNameContainingIgnoreCaseAndIsDeletedFalse(name);
        ArrayList<SearchByNameEmployeeResponseDTO> searchList = new ArrayList<>();

        //Handling the exception
        if (employeeList.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with the Name :" + name + " Not found...");
        }

        for (Employee emp : employeeList) {
            searchList.add(mapper.mapToSearchEmployeeResponseDTO(emp));
        }
        return searchList;
    }

}

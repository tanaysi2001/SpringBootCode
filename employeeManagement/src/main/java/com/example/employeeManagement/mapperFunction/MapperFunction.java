package com.example.employeeManagement.mapperFunction;

import com.example.employeeManagement.dto.*;
import com.example.employeeManagement.model.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MapperFunction {
    public Employee mapToEntity(CreateRequestEmployeeDTO empReq) {
        Employee employee = new Employee();

        employee.setName(empReq.getName());
        employee.setEmail(empReq.getEmail());
        employee.setAge(empReq.getAge());
        employee.setSalary(empReq.getSalary());
        employee.setDesignation(empReq.getDesignation());
        employee.setDepartment(empReq.getDepartment());
        employee.setDeleted(false);
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());

        return employee;
    }

    public CreateResponseEmployeeDTO mapToDTO(Employee employee) {

        CreateResponseEmployeeDTO empResp = new CreateResponseEmployeeDTO();

        empResp.setName(employee.getName());
        empResp.setEmail(employee.getEmail());
        empResp.setAge(employee.getAge());
        empResp.setSalary(employee.getSalary());
        empResp.setDepartment(employee.getDepartment());
        empResp.setDesignation(employee.getDesignation());
        empResp.setCreatedAt(employee.getCreatedAt());
        empResp.setUpdatedAt(employee.getUpdatedAt());
        empResp.setMessage("Employee Created Sucessfully....");
        return empResp;
    }

    public GetEmployeeResponseDTO mapToGetEmployeeDTO(Employee employee) {

        GetEmployeeResponseDTO response = new GetEmployeeResponseDTO();
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setAge(employee.getAge());
        response.setSalary(employee.getSalary());
        response.setDesignation(employee.getDesignation());
        response.setDepartment(employee.getDepartment());
        response.setCreatedAt(employee.getCreatedAt());
        response.setUpdatedAt(employee.getUpdatedAt());
        return response;
    }


    public Employee mapUpdateRequestToEntity(UpdateEmployeeRequestDTO empReq, Employee employee) {
        employee.setName(empReq.getName());
        employee.setAge(empReq.getAge());
        employee.setSalary(empReq.getSalary());
        employee.setDesignation(empReq.getDesignation());
        employee.setDepartment(empReq.getDepartment());
        return employee;
    }

    public UpdateEmployeeResponseDTO mapUpdateRequestToDTO(Employee existingEmployee) {
        UpdateEmployeeResponseDTO response = new UpdateEmployeeResponseDTO();
        response.setName(existingEmployee.getName());
        response.setAge(existingEmployee.getAge());
        response.setSalary(existingEmployee.getSalary());
        response.setDesignation(existingEmployee.getDesignation());
        response.setDepartment(existingEmployee.getDepartment());
        response.setUpdatedAt(LocalDateTime.now());
        response.setEmail(existingEmployee.getEmail());
        return response;
    }

    public DeleteEmployeeResponseDTO mapDeleteRequestToDTO(Employee employee) {
        DeleteEmployeeResponseDTO response = new DeleteEmployeeResponseDTO();

        response.setName(employee.getName());
        response.setAge(employee.getAge());
        response.setSalary(employee.getSalary());
        response.setDesignation(employee.getDesignation());
        response.setDepartment(employee.getDepartment());
        response.setDeletedAt(LocalDateTime.now());
        response.setEmail(employee.getEmail());
        response.setCreatedAt(employee.getCreatedAt());
        response.setId(employee.getId());
        response.setMessage("Employee with id " + employee.getId() + "Has been deleted...!");
        return response;
    }

    public SoftDeleteEmployeeResponseDTO mapSoftDeleteRequestToDTO(Employee emp){
        SoftDeleteEmployeeResponseDTO response=new SoftDeleteEmployeeResponseDTO();
        response.setMessage("Employee with id "+ emp.getId()+" is deleted...");
        return response;
    }
    public SearchByNameEmployeeResponseDTO mapToSearchEmployeeResponseDTO(Employee employee){
        SearchByNameEmployeeResponseDTO response=new SearchByNameEmployeeResponseDTO();
        response.setName(employee.getName());
        response.setEmail(employee.getEmail());
        response.setAge(employee.getAge());
        response.setSalary(employee.getSalary());
        response.setDesignation(employee.getDesignation());
        response.setDepartment(employee.getDepartment());
        response.setCreatedAt(employee.getCreatedAt());
        response.setUpdatedAt(employee.getUpdatedAt());
        return response;
    }
}

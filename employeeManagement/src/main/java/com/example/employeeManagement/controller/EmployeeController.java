package com.example.employeeManagement.controller;

import com.example.employeeManagement.dto.*;
import com.example.employeeManagement.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<CreateResponseEmployeeDTO> createEmployee(@RequestBody CreateRequestEmployeeDTO employeeReq) {
        CreateResponseEmployeeDTO resp = employeeService.createEmployee(employeeReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    //get the employee
    @GetMapping("/get/{id}")
    public ResponseEntity<GetEmployeeResponseDTO> getEmployee(@PathVariable Long id){
        GetEmployeeResponseDTO empResp =employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(empResp);
    }

    // get all the employee
    @GetMapping("/get")
    public ResponseEntity<List<GetEmployeeResponseDTO>> getEmployees(){
        List<GetEmployeeResponseDTO> employeeList= employeeService.getAllEmployee();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    //update the employee
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateEmployeeResponseDTO> updateEmployee(@RequestBody UpdateEmployeeRequestDTO empReq, @PathVariable Long id){
        UpdateEmployeeResponseDTO empResp =employeeService.updateEmployee(empReq,id);
        return ResponseEntity.status(HttpStatus.OK).body(empResp);
    }

    //Delete the employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteEmployeeResponseDTO> deleteEmployee(@PathVariable Long id){
        DeleteEmployeeResponseDTO deletedEmployee =employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedEmployee);

    }

    //Soft delete the employee
    @DeleteMapping("/softDelete/{id}")
    public ResponseEntity<SoftDeleteEmployeeResponseDTO> softDeleteEmployee(@PathVariable Long id){
        SoftDeleteEmployeeResponseDTO deletedEmployee= employeeService.softDelete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedEmployee);
    }

    //search by name
    @GetMapping("/search/name")
    public ResponseEntity<List<SearchByNameEmployeeResponseDTO>> searchByName(@RequestParam String name){
        List<SearchByNameEmployeeResponseDTO> response= employeeService.searchByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

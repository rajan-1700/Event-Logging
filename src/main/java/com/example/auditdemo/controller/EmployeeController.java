package com.example.auditdemo.controller;

import com.example.auditdemo.model.Employee;
import com.example.auditdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //CREATE EMPLOYEE
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee)
    {
        return employeeService.createEmployee(employee);
    }

    //get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

//    get employee by id
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable String id)
//    {
//        return employeeService.getEmployeeById(id);
//    }

     //update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable String id,
            @RequestBody Employee employee
    ) {
        return employeeService.updateEmployee(id, employee);
    }
    //delete employee
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id)
    {
        employeeService.deleteEmployee(id);
    }

}

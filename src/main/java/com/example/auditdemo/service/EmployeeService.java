package com.example.auditdemo.service;

import com.example.auditdemo.model.Employee;
import com.example.auditdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AuditLogService auditLogService;

    //create
    public Employee createEmployee(Employee employee)
    {
        Employee savedEmployee=employeeRepository.save(employee);
        auditLogService.logAction(
                "admin",
                "CREATE",
                "Employee",
                savedEmployee.getId()
        );
        return savedEmployee;
    }

    //read all
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //read by id
    public Employee updateEmployee(String id)
    {
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
    }

    //update
    public Employee updateEmployee(String id, Employee updatedEmployee) {

        // 1. Fetch existing employee (ensures ID exists)
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // 2. Update fields
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());

        // 3. Save (MongoDB UPDATE because ID exists)
        Employee savedEmployee = employeeRepository.save(existingEmployee);

        // 4. Audit log
        auditLogService.logAction(
                "admin",
                "UPDATE",
                "Employee",
                savedEmployee.getId()
        );

        // 5. Return updated employee
        return savedEmployee;
    }
    public void deleteEmployee(String id)
    {
        employeeRepository.deleteById(id);
        auditLogService.logAction(
        "admin",
        "DELETE",
        "Employee",
        id);
    }


//    public Employee getEmployeeById(String id) {
//
//    }
}

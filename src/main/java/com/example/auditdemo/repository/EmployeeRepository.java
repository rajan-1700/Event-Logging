package com.example.auditdemo.repository;

import com.example.auditdemo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
    extends MongoRepository<Employee, String>{

}

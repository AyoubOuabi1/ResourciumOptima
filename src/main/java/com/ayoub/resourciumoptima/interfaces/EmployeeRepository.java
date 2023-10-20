package com.ayoub.resourciumoptima.interfaces;

import com.ayoub.resourciumoptima.entities.Employee;

import java.util.List;

public interface EmployeeRepository {

    void save(Employee obj);

    void delete(Employee id);

    void update(Employee obj);

    Employee findById(Long id);

    List<Employee> getAll();

    public Employee findByEmailAndPassword(  String email,String password );
 }

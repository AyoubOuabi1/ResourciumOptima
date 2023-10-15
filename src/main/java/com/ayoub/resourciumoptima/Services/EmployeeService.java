package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.EmployeeRepository;
import com.ayoub.resourciumoptima.entities.Employee;

import java.util.List;

public class EmployeeService {

    EmployeeRepository employeeRepository;

    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void removeEmployee(Long id) {
        employeeRepository.delete(id);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getAll();
    }

    public Employee checkLogin(String email, String password) {
        return employeeRepository.findByEmailAndPassword(email, password);
    }
}

package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.EmployeeRepositoryImp;
import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.interfaces.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EmployeeService {

    //@Inject
    private EmployeeRepository employeeRepository;

    public EmployeeService(){
        employeeRepository=new EmployeeRepositoryImp();
    }


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

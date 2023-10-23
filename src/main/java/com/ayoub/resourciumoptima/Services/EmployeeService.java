package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.Repositories.EmployeeRepositoryImp;
import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.interfaces.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class EmployeeService {

    //@Inject
    private EmployeeRepository employeeRepository;

    public EmployeeService(){
        employeeRepository=new EmployeeRepositoryImp();
    }


    public Employee findEmployee(Long id) throws NullPointerException {
        if (id != null)
            return employeeRepository.findById(id);
        return null;
    }

    public void saveEmployee(Employee employee) {
        if (employee != null){
            employeeRepository.save(employee);
        }

    }
    public void removeEmployee(Long id) throws Exception {
        if (id != null){
            Employee employee = findEmployee(id);
            if (employee != null) {
                employeeRepository.delete(employee);
            }
        }
    }

    public Employee updateEmployee(Employee employee) throws Exception {
        if (employee != null){
            employeeRepository.update(employee);
        }
        return employee;
     }

    public Optional<List<Employee>> getEmployees(HttpServletRequest request)  throws NullPointerException{
        HttpSession session=request.getSession();
        Employee emp=(Employee) session.getAttribute("currentUser");
        if(employeeRepository.getAll().size()>0){
            List<Employee> employees = employeeRepository.getAll();
            employees.remove(emp);
            Optional<List<Employee>> employees1 = Optional.of(employees);
            return employees1;
        }

        return Optional.empty();
     }

    public Employee checkLogin(String email, String password)  throws NullPointerException{
        if (email != null && password != null){
            return employeeRepository.findByEmailAndPassword(email, password);
        }
        return null;
    }

    public void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
}

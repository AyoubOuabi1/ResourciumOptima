package com.ayoub.resourciumoptima.Services;

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
import java.util.stream.Collectors;

@ApplicationScoped
public class EmployeeService {

    //@Inject
    private EmployeeRepository employeeRepository;

    public EmployeeService(){
        employeeRepository=new EmployeeRepositoryImp();
    }


    public Employee findEmployee(Long id) throws NullPointerException {
        return employeeRepository.findById(id);
    }

    public void saveEmployee(Employee employee) {
        if (employee != null){
            employeeRepository.save(employee);
        }

    }

    public void removeEmployee(Long id) throws Exception {
        if (id != null){
            employeeRepository.delete(id);
        }

    }

    public void updateEmployee(Employee employee) throws Exception {
        if (employee != null){
            employeeRepository.update(employee);
        }
     }

    public List<Employee> getEmployees(HttpServletRequest request)  throws NullPointerException{
        HttpSession session=request.getSession();
        Employee emp=(Employee) session.getAttribute("currentUser");
        List<Employee> employees = employeeRepository.getAll();
        employees.remove(emp);
        return employees;
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

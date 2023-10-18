package com.ayoub.resourciumoptima;

import java.io.*;

import com.ayoub.resourciumoptima.Services.DepartmentService;
import com.ayoub.resourciumoptima.Services.EmployeeService;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class HelloServlet extends HttpServlet {

    EmployeeService employeeService;
    DepartmentService departmentService;
    public void init() {
        employeeService = new EmployeeService();
        departmentService=new DepartmentService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Employee employee = new Employee();
        employee.setFirstName("mohamed");
        employee.setLastName("ouabi");
        employee.setEmail("ayoub@gmail.com");
        employee.setPassword("ayoub");
        employee.setPosition("374238742384");
        Department department=new Department();
        department.setName("resourcium");
        departmentService.saveDepartment(department);
        employee.setDepartment(department);
        employeeService.saveEmployee(employee);
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(employeeService!=null && employeeService.checkLogin(email, password)!=null){
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",employeeService.checkLogin(email, password));
            response.sendRedirect("index.jsp");
        }
    }

    public void destroy() {
    }
}
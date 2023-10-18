package com.ayoub.resourciumoptima.ressources;

import java.io.*;

import com.ayoub.resourciumoptima.Services.DepartmentService;
import com.ayoub.resourciumoptima.Services.EmployeeService;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    EmployeeService employeeService;
    DepartmentService departmentService;
    public void init() {
        employeeService = new EmployeeService();
        departmentService=new DepartmentService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*Employee employee = new Employee();
        employee.setFirstName("mohamed");
        employee.setLastName("ouabi");
        employee.setEmail("ayoub@gmail.com");
        employee.setPassword("ayoub");
        employee.setPosition("374238742384");
        Department department=new Department();
        department.setName("resourcium");
        departmentService.saveDepartment(department);
        employee.setDepartment(department);
        employeeService.saveEmployee(employee);*/
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(email + " " + password);
        if(employeeService!=null && employeeService.checkLogin(email, password)!=null){
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",employeeService.checkLogin(email, password));
            System.out.println(session.getAttribute("currentUser"));
            response.sendRedirect("index.jsp");
        }
    }

    public void destroy() {
    }
}
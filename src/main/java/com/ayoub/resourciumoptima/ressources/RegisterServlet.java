package com.ayoub.resourciumoptima.ressources;

import com.ayoub.resourciumoptima.Services.DepartmentService;
import com.ayoub.resourciumoptima.Services.EmployeeService;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

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
            response.sendRedirect("home.jsp");
        }
    }

    public void destroy() {
    }
}
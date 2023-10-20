package com.ayoub.resourciumoptima.ressources;

import com.ayoub.resourciumoptima.Services.DepartmentService;
import com.ayoub.resourciumoptima.Services.EmployeeService;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name="employeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService;
    DepartmentService departmentService=new DepartmentService();
    @Override
    public void init() throws ServletException {
        employeeService= new EmployeeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("currentUser") == null) {
            System.out.println("login");
            resp.sendRedirect("/ResourciumOptima_war/login");
        }else {
            List<Employee>  employees = employeeService.getEmployees(req);
            req.setAttribute("employeeList", employees);
            RequestDispatcher rd=req.getRequestDispatcher("views/layouts/employee.jsp");
            rd.forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long DepartmentId = Long.valueOf(req.getParameter("departmentId"));
        /*Long DepartmentId=2L;
       *//* if (DepartmentId!=null) {
            DepartmentId= 2L;
        }*/
        Department department = departmentService.findDepartment(DepartmentId);
        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));
        employee.setEmail(req.getParameter("email"));
        employee.setPassword(req.getParameter("password"));
        employee.setPosition(req.getParameter("position"));
        System.out.println(employee);
        employeeService.saveEmployee(employee);
        resp.sendRedirect("/ResourciumOptima_war/employees");
    }
}

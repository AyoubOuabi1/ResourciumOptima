package com.ayoub.resourciumoptima.ressources;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
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
import java.util.Optional;

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
           Optional<List<Employee>> employees = employeeService.getEmployees(req);
            req.setAttribute("employeeList", employees);
            RequestDispatcher rd=req.getRequestDispatcher("views/layouts/employee.jsp");
            rd.forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action.equals("delete")){
            try {
                deleteEmployee(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if (action.equals("create")){
            addEmployee(req, resp);
        }else if (action.equals("update")){
            try {
                updateEmployee(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.valueOf(req.getParameter("employeeId"));
        employeeService.removeEmployee(id);
        resp.sendRedirect("/ResourciumOptima_war/employees");
    }

    void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long DepartmentId = Long.valueOf(req.getParameter("departmentId"));
        Department department = departmentService.findDepartment(DepartmentId);
        Employee employee=getEmployee(req,department,false);
         employeeService.saveEmployee(employee);
        resp.sendRedirect("/ResourciumOptima_war/employees");
    }

    void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long DepartmentId = Long.valueOf(req.getParameter("departmentId"));
        Department department = departmentService.findDepartment(DepartmentId);
        Employee employee=getEmployee(req,department,true);
        employeeService.updateEmployee(employee);
        resp.sendRedirect("/ResourciumOptima_war/employees");
    }

    Employee getEmployee(HttpServletRequest req,Department department,boolean update){
        Employee employee;
        if (update){
            Long id = Long.valueOf(req.getParameter("empId"));
            employee = employeeService.findEmployee(id);
        }else {
            employee = new Employee();
        }

        employee.setDepartment(department);
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));
        employee.setEmail(req.getParameter("email"));
        employee.setPassword(req.getParameter("password"));
        employee.setPosition(req.getParameter("position"));
        return employee;
    }

}

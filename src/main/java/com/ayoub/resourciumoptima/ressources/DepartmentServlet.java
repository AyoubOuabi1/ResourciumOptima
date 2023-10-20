package com.ayoub.resourciumoptima.ressources;

import com.ayoub.resourciumoptima.Services.DepartmentService;
import com.ayoub.resourciumoptima.Services.EmployeeService;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name="DepartmentServlet", urlPatterns = "/departments")
public class DepartmentServlet extends HttpServlet {
     DepartmentService departmentService;
    @Override
    public void init() throws ServletException {
        departmentService=new DepartmentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("currentUser") == null) {
            System.out.println("login");
            resp.sendRedirect("/ResourciumOptima_war/login");
        }else {
            List<Department>  departments = departmentService.getDepartments();
            req.setAttribute("departmentList", departments);
            RequestDispatcher rd=req.getRequestDispatcher("views/layouts/department.jsp");
            rd.forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action.equals("delete")){
            try {
                deleteDepartment(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if (action.equals("create")){
            addDepartment(req, resp);
        }else if (action.equals("update")){
            try {
                updateDepartment(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void deleteDepartment(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.valueOf(req.getParameter("departmentId"));
        departmentService.removeDepartment(id);
        resp.sendRedirect("/ResourciumOptima_war/departments");
    }

    void addDepartment(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Department department = new Department();
        department.setName(req.getParameter("departmentName"));
        departmentService.saveDepartment(department);
        resp.sendRedirect("/ResourciumOptima_war/departments");
    }

    void updateDepartment(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.valueOf(req.getParameter("departmentId"));
        Department department = departmentService.findDepartment(id);
        department.setName("department "+ UUID.randomUUID());
        departmentService.updateDepartment(department);
        resp.sendRedirect("/ResourciumOptima_war/departments");
    }


}

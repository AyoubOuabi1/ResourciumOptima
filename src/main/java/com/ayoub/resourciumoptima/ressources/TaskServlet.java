package com.ayoub.resourciumoptima.ressources;

import com.ayoub.resourciumoptima.Services.DepartmentService;
import com.ayoub.resourciumoptima.Services.EmployeeService;
import com.ayoub.resourciumoptima.Services.EquipmentService;
import com.ayoub.resourciumoptima.Services.TaskService;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.entities.Equipment;
import com.ayoub.resourciumoptima.entities.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "TaskServlet", value = "/tasks")

public class TaskServlet extends HttpServlet {
    EmployeeService employeeService;
    EquipmentService equipmentService;
    TaskService taskService;
    @Override
    public void init() throws ServletException {
        employeeService= new EmployeeService();
        equipmentService = new EquipmentService();
        taskService=new TaskService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        if (session.getAttribute("currentUser") == null) {
            System.out.println("login");
            resp.sendRedirect("/ResourciumOptima_war/login");
        }else {
            Optional<List<Task>> tasks = taskService.getTasks();
            req.setAttribute("tasksList", tasks);
            RequestDispatcher rd=req.getRequestDispatcher("views/layouts/task.jsp");
            rd.forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        if (action.equals("delete")){
            try {
                deleteTask(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if (action.equals("create")){
            try {
                addTask(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if (action.equals("update")){
            try {
                updateTask(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void deleteTask(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Long id = Long.valueOf(req.getParameter("taskId"));
        taskService.removeTask(id);
        resp.sendRedirect("/ResourciumOptima_war/tasks");
    }

    void addTask(HttpServletRequest req, HttpServletResponse resp) throws Exception {

       taskService.saveTask(getTask(req,false));
        resp.sendRedirect("/ResourciumOptima_war/tasks");
    }

    void updateTask(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       taskService.updateTask(getTask(req,true));
        resp.sendRedirect("/ResourciumOptima_war/tasks");
    }

    Task getTask(HttpServletRequest req, boolean update) throws Exception {
        Long empId = Long.valueOf(req.getParameter("employeeId"));
        Long equipId = Long.valueOf(req.getParameter("equipmentId"));
        Employee employee = employeeService.findEmployee(empId);
        Equipment equipment = equipmentService.findEquipment(equipId);

        Task task;
        if (update){
            Long id = Long.valueOf(req.getParameter("taskId"));
            task =taskService.findTask(id);
        }else {
            task = new Task();
        }
        task.setAssignedEquipment(equipment);
        task.setAssignedEmployee(employee);
        task.setDescription(req.getParameter("description"));
        task.setPriority(req.getParameter("priority"));
        task.setName(req.getParameter("name"));
        task.setDueDate(Date.valueOf(req.getParameter("dueDate")));
        task.setEndDate(Date.valueOf(req.getParameter("endDate")));
        task.setStatus("not yet started");
        equipment.setStatus("not available");
        equipmentService.updateEquipment(equipment);
        return task;
    }
}

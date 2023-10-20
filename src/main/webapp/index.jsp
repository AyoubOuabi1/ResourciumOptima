<%@ page import="com.ayoub.resourciumoptima.Config.EntityManagerFct" %>
<%@ page import="com.ayoub.resourciumoptima.Services.DepartmentService" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Department" %>
<%@ page import="com.ayoub.resourciumoptima.Services.EmployeeService" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
        EntityManagerFct.getEntityManagerFactory();
        /*DepartmentService departmentService= new DepartmentService();
        Department d= new Department();
        d.setName("optima");
        Department department=departmentService.saveDepartment(d);
        EmployeeService employeeService=new EmployeeService();
        Employee employee=new Employee();
        employee.setFirstName("ayoub");
        employee.setLastName("ouabi");
        employee.setEmail("ayoub@gmail.com");
        employee.setPosition("admin");
        employee.setDepartment(department);
        employeeService.saveEmployee(employee);*/
        response.sendRedirect("/ResourciumOptima_war/employees");
%>


<%@ page import="com.ayoub.resourciumoptima.Services.EquipmentService" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Equipment" %>
<%@ page import="java.sql.Date" %>
<%@ page import="com.ayoub.resourciumoptima.Services.TaskService" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Task" %>
<%@ page import="com.ayoub.resourciumoptima.Services.EmployeeService" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 24/10/2023
  Time: 09:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    EquipmentService equipmentService = new EquipmentService();
    Equipment equipment = new Equipment();
    equipment.setMaintenance_date(new Date(System.currentTimeMillis()));
    equipment.setType("jetable");
    equipment.setName("equipment");
    equipment.setPurchaseDate(new Date(System.currentTimeMillis()));
    equipment.setStatus("available");
    equipmentService.saveEquipment(equipment);

    TaskService taskService = new TaskService();

    Task task =new  Task();

    task.setAssignedEquipment(equipment);
    task.setDescription("test description");

    task.setPriority("high");
    task.setEndDate(Date.valueOf("2024-01-01"));
    task.setDueDate(new Date(System.currentTimeMillis()));
    EmployeeService employee=new EmployeeService();
    Long id=104L;
    Employee emp=employee.findEmployee(id);
    task.setAssignedEmployee(emp);
    taskService.saveTask(task);
    List<Task>t = taskService.getTasks();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<% for (Task yy : t) { %>
<p></p>
    <p><%= yy.toString()%></p>
<%}%>
</body>

</html>

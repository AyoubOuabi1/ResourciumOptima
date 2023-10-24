<%@ page import="com.ayoub.resourciumoptima.entities.Department" %>
<%@ page import="com.ayoub.resourciumoptima.Services.DepartmentService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page import="com.ayoub.resourciumoptima.Services.EmployeeService" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Equipment" %>
<%@ page import="com.ayoub.resourciumoptima.Services.EquipmentService" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 19/10/2023
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../components/head.jsp" %>
<%
  EmployeeService employeeService = new EmployeeService();
  Optional<List<Employee>> employees = employeeService.getEmployees(request);
  List<Employee> employeeList=new ArrayList<>();
  if(employees.isPresent()){
    employeeList=employees.get();
  }
  EquipmentService equipmentService = new EquipmentService();
  Optional<List<Equipment>> equipments = equipmentService.getEquipments();
  List<Equipment> equipmentList= new ArrayList<>();
  if(equipments.isPresent()){
     equipmentList=equipments.get().stream().filter(equipment->equipment.getStatus().equalsIgnoreCase("available")).collect(Collectors.toList());
  }
%>
<div class="card shadow" >

  <div class="card-header py-3">
    <p class="text-primary m-0 fw-bold">Add employee</p>
  </div>

  <div class="card-body">
    <div class="row">
      <form action="${pageContext.request.contextPath}/tasks" method="POST" >

        <div class="form-group bg-light border rounded-3 p-3 mt-3 row">

          <div class="col-sm-6">
            <label for="name">name</label>
            <input type="text" class="form-control" id="name" name="name"   placeholder="Enter name">

          </div>

          <div class="col-sm-6">
            <label for="priority">priority</label>
            <select class="form-select" name="priority" id="priority">
              <option disabled selected>Select priority</option>
              <option value="high" >High</option>
              <option value="medium">Medium</option>
              <option value="low" >Low</option>
            </select>
          </div>
        </div>

        <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
          <div class="col-sm-6">
            <label for="description">email</label>
            <textarea type="text" class="form-control" id="description" name="description"   placeholder="Enter description"></textarea>

          </div>

          <div class="col-sm-6">
            <label for="status">status</label>
            <input type="text" class="form-control" id="status" name="status" value="not yet started" readonly>

          </div>

        </div>

        <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
          <div class="col-sm-6">
            <label for="dueDate">start date</label>
            <input type="date" class="form-control" id="dueDate" name="dueDate" >

          </div>
          <div class="col-sm-6">
            <label for="endDate">End date</label>
            <input type="date" class="form-control" id="endDate" name="endDate" >

          </div>


        </div>
        <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
          <div class="col-sm-6">
            <label for="priority">Employee</label>
            <select class="form-select" name="employeeId" id="employeeId">
              <option disabled selected>Select Employee</option>

              <% for (Employee emp: employeeList) { %>
                <option value="<%=emp.getId()%>" ><%=emp.getFirstName()+" "+emp.getLastName()%></option>

              <%}%>

            </select>
          </div>
          <div class="col-sm-6">
            <label for="equipmentId">Equipment</label>
            <select class="form-select" name="equipmentId" id="equipmentId">
              <option disabled selected>Select Employee</option>

              <% for (Equipment equip: equipmentList) { %>
              <option value="<%=equip.getId()%>" ><%=equip.getName()%></option>

              <%}%>
            </select>
          </div>


        </div>
        <div class="d-flex justify-content-center mt-3">
          <button type="submit" name="action" value="create" class="btn btn-primary">Submit</button>
        </div>
      </form>
    </div>


  </div>
</div>
<%@ include file="../components/footer.jsp" %>


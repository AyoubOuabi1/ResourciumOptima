<%@ page import="com.ayoub.resourciumoptima.entities.Department" %>
<%@ page import="com.ayoub.resourciumoptima.Services.DepartmentService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page import="com.ayoub.resourciumoptima.Services.EmployeeService" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 19/10/2023
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../components/head.jsp" %>
<%
  DepartmentService departmentService = new DepartmentService();
  Optional<List<Department>> departments = departmentService.getDepartments();
  List<Department> departmentList=new ArrayList<>();
  if(departments.isPresent()){
    departmentList=departments.get();
  }
  EmployeeService employeeService=new EmployeeService();
  Long id=Long.valueOf(request.getParameter("id"));
  Employee employee= employeeService.findEmployee(id);
%>
<div class="card shadow" >

  <div class="card-header py-3">
    <p class="text-primary m-0 fw-bold">Update employee</p>
  </div>

  <div class="card-body">
    <div class="row">
      <form action="${pageContext.request.contextPath}/employees" method="POST" >

        <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
          <input type="text" value="<%=employee.getId()%>" name="empId" hidden="hidden">
          <div class="col-sm-6">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="<%=employee.getFirstName()%>"   placeholder="Enter first name">

          </div>

          <div class="col-sm-6">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName"  value="<%=employee.getLastName()%>" placeholder="Enter last name">

          </div>
        </div>

        <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
          <div class="col-sm-6">
            <label for="email">email</label>
            <input type="email" class="form-control" id="email" name="email"  value="<%=employee.getEmail()%>"  placeholder="Enter email">

          </div>

          <div class="col-sm-6">
            <label for="password">password</label>
            <input type="password" class="form-control" id="password" name="password" value="<%=employee.getPassword()%>" placeholder="Enter password">

          </div>

        </div>

        <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
          <div class="col-sm-6">
            <label for="position">position</label>
            <input type="text" class="form-control" id="position" name="position" value="<%=employee.getPosition()%>" placeholder="Enter position">

          </div>
          <div class="col-sm-6">
            <label for="departmentId">position</label>
            <select class="form-select" name="departmentId" id="departmentId">
              <option   disabled>select Department id </option>
              <% for (Department d : departmentList) {
                if (d.getId()==employee.getDepartment().getId()){
              %>
                <option value="<%= d.getId() %>" selected><%= d.getName() %></option>
              <%  }else {%>
               <option value="<%= d.getId() %>"><%= d.getName() %></option>

              <%}
              }%>

            </select>
          </div>

        </div>

        <div class="d-flex justify-content-center mt-3">
          <button type="submit" name="action" value="update" class="btn btn-primary">Update</button>
        </div>
      </form>
    </div>


  </div>
</div>
<%@ include file="../components/footer.jsp" %>


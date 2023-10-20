<%@ page import="com.ayoub.resourciumoptima.entities.Department" %>
<%@ page import="com.ayoub.resourciumoptima.Services.DepartmentService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 19/10/2023
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../components/head.jsp" %>
<%
    DepartmentService departmentService = new DepartmentService();
    List<Department> departmentList = departmentService.getDepartments();
%>
<div class="card shadow" >

    <div class="card-header py-3">
        <p class="text-primary m-0 fw-bold">Ajouter Vehicule</p>
    </div>

    <div class="card-body">
        <div class="row">
            <form action="${pageContext.request.contextPath}/employees" method="POST" >

                <div class="form-group bg-light border rounded-3 p-3 mt-3 row">

                    <div class="col-sm-6">
                        <label for="firstName">First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName"   placeholder="Enter first name">

                    </div>

                    <div class="col-sm-6">
                        <label for="lastName">Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName"   placeholder="Enter last name">

                    </div>
                </div>

                <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
                    <div class="col-sm-6">
                        <label for="email">email</label>
                        <input type="text" class="form-control" id="email" name="email"   placeholder="Enter email">

                    </div>

                    <div class="col-sm-6">
                        <label for="password">password</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="Enter password">

                    </div>

                </div>

                <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
                    <div class="col-sm-6">
                        <label for="position">position</label>
                        <input type="text" class="form-control" id="position" name="position" placeholder="Enter position">

                    </div>
                    <div class="col-sm-6">
                        <label for="departmentId">position</label>
                        <select class="form-select" name="departmentId" id="departmentId">
                            <option selected disabled>select Department id </option>
                            <% for (Department d : departmentList) {%>
                            <option value="<%= d.getId() %>"><%= d.getName() %></option>
                            <%  }%>
                        </select>
                    </div>

                </div>

                <div class="d-flex justify-content-center mt-3">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>


    </div>
</div>
<%@ include file="../components/footer.jsp" %>


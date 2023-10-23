<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Department" %>
<%@ page import="java.util.Optional" %>
<%@ include file="../components/head.jsp" %>

<div class="d-flex justify-content-between">
  <h3 class="text-dark mb-4">Departments</h3>
<%--
  <a href="views/layouts/addEmployee.jsp"><button type="button" class="btn btn-primary" >Ajouter un Employee</button></a>
--%>

</div>
<div class="card shadow">
  <div class="card-header py-3">
    <p class="text-primary m-0 fw-bold">Department</p>
  </div>
  <div class="card-body">
    <div class="row">
      <div class="col-md-6 text-nowrap">

      </div>
      <div class="col-md-6">
        <div  class="text-md-end dataTables_filter"><label class="form-label"><input
                class="form-control form-control-sm"    type="search" aria-controls="dataTable"
                placeholder="Search by name"/></label></div>
      </div>
    </div>
        <form method="post" action="${pageContext.request.contextPath}/departments">
          <div class="form-group bg-light border rounded-3 p-3 mt-3 row">

          <div class="col-sm-6">
             <input type="text" class="form-control" id="departmentName" name="departmentName"   placeholder="Enter department Name">
          </div>
          <div class="col-sm-6">
            <button type="submit" class="btn btn-primary" name="action" value="create">Add</button>

          </div>
          </div>
        </form>

    <div id="dataTable1" class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
      <table id="dataTable" class="table my-0">
        <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>update</th>
          <th>delete</th>
        </tr>
        </thead>
        <tbody >
        <% Optional<List<Department>> departmentsOptional = (Optional<List<Department>>) request.getAttribute("departmentList");

          if (departmentsOptional.isPresent()) {
            List<Department> departments = departmentsOptional.get();
            for (Department department : departments) { %>
        <tr>
          <td><%= department.getId() %></td>
          <td><%= department.getName() %></td>
          <td>
            <form action="${pageContext.request.contextPath}/departments" method="post">
              <input type="hidden" name="action" value="update">
              <input type="hidden" name="departmentId" value="<%=department.getId()%>">
              <button type="submit" class="btn btn-primary">update</button>
            </form>
          </td>
          <td>
            <form action="${pageContext.request.contextPath}/departments" method="post">
              <input type="hidden" name="action" value="delete">
              <input type="hidden" name="departmentId" value="<%=department.getId()%>">
              <button type="submit" class="btn btn-danger">Delete</button>
            </form>
          </td>
        </tr>
        <% }
          }
        %>




        </tbody>
      </table>

    </div>


  </div>
</div>
<%@ include file="../components/footer.jsp" %>


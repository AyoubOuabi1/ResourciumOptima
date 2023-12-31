<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ include file="../components/head.jsp" %>

<div class="d-flex justify-content-between">
    <h3 class="text-dark mb-4">Employees</h3>
    <a href="views/layouts/addEmployee.jsp"><button type="button" class="btn btn-primary" >Ajouter un Employee</button></a>

</div>
<div class="card shadow">
    <div class="card-header py-3">
        <p class="text-primary m-0 fw-bold">Employee</p>
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
        <div id="dataTable1" class="table-responsive table mt-2" role="grid" aria-describedby="dataTable_info">
            <table id="dataTable" class="table my-0">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>email</th>
                        <th>position</th>
                        <th>update</th>
                        <th>delete</th>
                </tr>
                </thead>
                <tbody id="emplyeetable">
                <% Optional<List<Employee>> employees1 = (Optional<List<Employee>>) request.getAttribute("employeeList");
                    if (employees1.isPresent()) {
                        List<Employee> employees = employees1.get();
                        for (Employee employee : employees) { %>
                            <tr>
                                <td><%= employee.getFirstName()+" "+employee.getLastName() %></td>
                                <td><%= employee.getEmail() %></td>
                                <td><%= employee.getPosition() %></td>
                                 <td><a href="views/layouts/showEmployee.jsp?id=<%=employee.getId()%>"><button class="btn btn-primary">update</button></a></td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/employees" method="post">
                                        <input type="hidden" name="action" value="delete">
                                        <input type="hidden" name="employeeId" value="<%=employee.getId()%>">
                                        <button type="submit" class="btn btn-danger">Delete</button>
                                     </form>
                                </td>

                            </tr>
                         <% }
                    }%>


                </tbody>
            </table>

        </div>


    </div>
</div>
<%@ include file="../components/footer.jsp" %>


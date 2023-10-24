<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Equipment" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Task" %>
<%@ include file="../components/head.jsp" %>

<div class="d-flex justify-content-between">
    <h3 class="text-dark mb-4">Tasks</h3>
    <a href="views/layouts/addTask.jsp"><button type="button" class="btn btn-primary" >Add new Task</button></a>

</div>
<div class="card shadow">
    <div class="card-header py-3">
        <p class="text-primary m-0 fw-bold">Tasks</p>
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
                    <th>start date</th>
                    <th>end date </th>
                    <th>status </th>
                    <th>Employee</th>
                    <th>Equipment</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                <% Optional<List<Task>> tasks1 = (Optional<List<Task>>) request.getAttribute("tasksList");
                    if (tasks1.isPresent()) {
                        List<Task> tasks =tasks1.get();
                        for (Task task : tasks) { %>
                <tr>
                    <td><%= task.getName() %></td>
                    <td><%= String.valueOf(task.getDueDate()).substring(0,10) %></td>
                     <td><%= String.valueOf(task.getEndDate()).substring(0,10) %></td>
                    <td><%= task.getStatus() %></td>
                    <td><%= task.getAssignedEmployee().getFirstName()+" " + task.getAssignedEmployee().getLastName()%></td>
                    <td><%= task.getAssignedEquipment().getName() %></td>
                     <td><button class="btn btn-primary">update</button></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/tasks" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="taskId" value="<%= task.getId() %>">
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



<%@ include file="../../views/components/head.jsp" %>
<%
    if (session.getAttribute("currentUser") == null) {
        System.out.println("login");
        response.sendRedirect("http://localhost:8080/ResourciumOptima_war/login.jsp");
    }
%>
<div class="d-flex justify-content-between">
    <h3 class="text-dark mb-4">Employees</h3>
    <a href="#"><button type="button" class="btn btn-primary" >Ajouter un Employee</button></a>

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
                    <th>Department</th>
                    <th>open task</th>
                    <th>update department</th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td>Ayoub</td>
                    <td>ayoub@gmail.com</td>
                    <td>admin</td>
                    <td>IT</td>
                    <td><a href="#"><button class="btn btn-success">open</button></a></td>
                    <td><button class="btn btn-danger">update</button></td>
                </tr>
                </tbody>
            </table>

        </div>


    </div>
</div>
<%@ include file="../../views/components/footer.jsp" %>


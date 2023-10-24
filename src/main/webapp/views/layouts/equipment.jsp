<%@ page import="com.ayoub.resourciumoptima.entities.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.ayoub.resourciumoptima.entities.Equipment" %>
<%@ include file="../components/head.jsp" %>

<div class="d-flex justify-content-between">
    <h3 class="text-dark mb-4">Employees</h3>
    <a href="views/layouts/addEquipment.jsp"><button type="button" class="btn btn-primary" >Add new Equipment</button></a>

</div>
<div class="card shadow">
    <div class="card-header py-3">
        <p class="text-primary m-0 fw-bold">Equipment</p>
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
                    <th>type</th>
                    <th>purchase Date </th>
                    <th>Status </th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                <% Optional<List<Equipment>> equipments1 = (Optional<List<Equipment>>) request.getAttribute("equipmentList");
                    if (equipments1.isPresent()) {
                        List<Equipment> equipments =equipments1.get();
                        for (Equipment equipment : equipments) { %>
                <tr>
                    <td><%= equipment.getName()%></td>
                    <td><%= equipment.getType() %></td>
                    <td><%= equipment.getPurchaseDate()%></td>
                    <td><%= equipment.getStatus()%></td>
                     <td><button class="btn btn-primary">update</button></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/equipments" method="post">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="equipmentId" value="<%= equipment.getId() %>">
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


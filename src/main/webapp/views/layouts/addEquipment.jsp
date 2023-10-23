<%@ page import="com.ayoub.resourciumoptima.entities.Department" %>
<%@ page import="com.ayoub.resourciumoptima.Services.DepartmentService" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 19/10/2023
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../components/head.jsp" %>

<div class="card shadow" >

    <div class="card-header py-3">
        <p class="text-primary m-0 fw-bold">Add equipment</p>
    </div>

    <div class="card-body">
        <div class="row">
            <form action="${pageContext.request.contextPath}/equipments" method="POST" >

                <div class="form-group bg-light border rounded-3 p-3 mt-3 row">

                    <div class="col-sm-6">
                        <label for="name">name</label>
                        <input type="text" class="form-control" id="name" name="name"   placeholder="name">

                    </div>

                    <div class="col-sm-6">
                        <label for="type">type</label>
                        <input type="text" class="form-control" id="type" name="type"   placeholder="Enter type">

                    </div>
                </div>

                <div class="form-group bg-light border rounded-3 p-3 mt-3 row">
                    <div class="col-sm-6">
                        <label for="purchaseDate">Purchase Date</label>
                        <input type="date" class="form-control" id="purchaseDate" name="purchaseDate"   >

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


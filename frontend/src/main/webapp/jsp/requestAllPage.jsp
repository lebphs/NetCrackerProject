<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: anpi0316
  Date: 15.03.2018
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<script src="resources/js/custom/allrequest.js"></script>







<%--<jsp:include page="/jsp/blocks/header.jsp"/>--%>
<br>
<!-- Кнопка, открывающее модальное окно -->
</div>
<div class="row">
    <div class="col-6 col-md-4">
        <button type="submit"  class="btn btn-success btn-block jsDeleteRequest"><span class="glyphicon glyphicon-ok"></span> Add Request</button>
    </div>
    <div class="col-6 col-md-4">
        <button type="submit" data-toggle="modal" data-target="#editStudent" disabled class="btn btn-success btn-block  jsEditStudent"><span class="glyphicon glyphicon-ok"></span> Edit</button>
    </div>
    <div class="col-6 col-md-4">
        <button type="submit" data-toggle="modal" data-target="#releasestudents" disabled class="btn btn-success btn-block jsAssignStudent"><span class="glyphicon glyphicon-ok"></span> Assign</button>
    </div>
</div>
<table
        data-search="true" data-toggle="table"

        data-pagination="true"
        data-page-list="[5, 10, 25, 50, 100, ALL]"
        data-page-size="5"
        class="jsRequestsTable">

    <thead>
    <tr>

        <th  data-checkbox="idRequest"></th>
        <th data-field="company"> Name Company</th>
        <th data-field="start_date_practice">Date Start</th>
        <th data-field="finish_data_prictice">Date Finish</th>
        <th data-field="minav">Min.Av.Score</th>
        <th data-field="quantity">Quantity</th>


    </tr>
    </thead>

</table >
</div>
<br>
<div class="container-fluid">
    <div class="row">

    </div>
</div>
</body>
</html>
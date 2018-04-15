<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<script src="resources/js/custom/requestPage.js"></script>







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
        <th data-checkbox="true"></th>
        <th data-field="companyName" data-sortable="true"> Name Company</th>
        <th data-field="startDate" data-sortable="true">Date Start</th>
        <th data-field="finishDate" data-sortable="true">Date Finish</th>
        <th data-field="faculty" data-sortable="true">Faculty</th>
        <th data-field="specialty" data-sortable="true">Specialty</th>
        <th data-field="minAverageScore" data-sortable="true">min.Average Score</th>
        <th data-field="totalQuantity" data-sortable="true">total quantity</th>
    </tr>
    </thead>
</table>
</div>
<br>
<div class="container-fluid">
    <div class="row">

    </div>
</div>
</body>
</html>
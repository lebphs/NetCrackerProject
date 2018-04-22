<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<script src="resources/js/custom/requestPage.js"></script>
<%--<script src="resources/bootstrap-typeahead.js"></script>--%>


<body>

<div class="container-fluid">
    <table data-click-to-select="true"
           data-pagination="true" data-page-list="[5,10, 25, 50, 100, ALL]"
           data-search="true" data-toggle="table" class="jsRequestsTable">
        <thead>
            <tr>
                <th data-checkbox="true"></th>
                <th data-field="companyName" data-sortable="true"> Name Company</th>
                <th data-field="practicePeriod" data-sortable="true">Dates</th>
                <th data-field="practiceStatus">Status</th>
                <th data-field="faculty" data-sortable="true">Faculty</th>
                <th data-field="specialty" data-sortable="true">Specialty</th>
                <th data-field="minAverageScore" data-sortable="true">min.Average Score</th>
                <th data-field="totalQuantity" data-sortable="true">total quantity</th>
                <th data-field="availableQuantity" data-sortable="true">available quantity</th>
                <th data-field="id" data-formatter="students" class="text-center">About students</th>
            </tr>
        </thead>
    </table>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-6 col-md-4">
            <button type="submit"  class="btn btn-success btn-block jsDeleteRequest"><span class="glyphicon glyphicon-ok"></span> Delete</button>
        </div>
        <div class="col-6 col-md-4">
            <button type="submit" data-toggle="modal" data-target="#editrequest" disabled class="btn btn-success btn-block  jsEditRequest"><span class="glyphicon glyphicon-ok"></span> Edit</button>
        </div>
        <div class="col-6 col-md-4">
            <button type="submit" data-toggle="modal" data-target="#assignstudent" disabled class="btn btn-success btn-block jsAssignStudentPage"><span class="glyphicon glyphicon-ok"></span> Assign</button>
        </div>
    </div>
</div>

    <div class="modal fade" id="studentsInPractice" role="dialog">
        <div class="modal-dialog " role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="modal-title" align="center">Students in practice</h2>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p class="notAllocated">In this practice there are no students</p>
                    <table class="table table-bordered jsTableStudentPractice">
                        <thead>
                        <tr >
                            <td>Surname student</td>
                            <td>Status</td>
                            <td>Faculty</td>
                            <td>Average score</td>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
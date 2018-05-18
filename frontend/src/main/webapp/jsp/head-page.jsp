<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Head page</title>

</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<jsp:include page="/jsp/blocks/student-page-title.jsp"/>
<script src="resources/js/custom/request-page.js"></script>
<%--<script src="resources/bootstrap-typeahead.js"></script>--%>


<body>

<div class="container-fluid">
    <table data-click-to-select="true"
            data-toggle="table" class="jsRequestTable">
        <thead>
        <tr>
            <th data-checkbox="true"></th>
            <th data-field="companyName" > Name Company</th>
            <th data-field="practicePeriod" >Dates</th>
            <th data-field="practiceStatus">Status</th>
            <th data-field="faculty" >Faculty</th>
            <th data-field="specialty" >Specialty</th>
            <th data-field="minAverageScore" >min.Average Score</th>
            <th data-field="totalQuantity" >total quantity</th>
            <th data-field="availableQuantity">available quantity</th>
            <th data-field="id" data-formatter="students" class="text-center">About students</th>
        </tr>
        </thead>
    </table>
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
                    <tr>
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
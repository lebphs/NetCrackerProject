<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<script src="resources/js/custom/student-page.js"></script>
<%--<script src="resources/bootstrap-typeahead.js"></script>--%>


<body>

<div class="container-fluid">
    <table
            data-click-to-select="true"
            <%--data-url="/studentTable"--%>
            data-toggle="table"
            class="jsStudentsTable">

        <thead>
        <tr>
            <th data-checkbox="true" ></th>
            <th data-field="surname">Last Name</th>
            <th data-field="name" >First Name</th>
            <th data-field="faculty" >Faculty</th>
            <th data-field="specialty" >Speciality</th>
            <th data-field="group" >Group</th>
            <th data-field="isBudget">Is budget</th>
            <th data-field="averageScore" >Average score</th>
            <%--<th data-field="studentStatus">Status</th>--%>
            <th data-field="id" data-formatter="formatter" class="text-center">About practices</th>
            <%--<th data-field="id" data-formatter="infoStudent" class="text-center">About student</th>--%>
        </tr>
        </thead>
    </table >
</div>


<div class="modal fade" id="aboutStudentPractice" role="dialog">
    <div class="modal-dialog " role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center">Students practice</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p class="notAllocated">This student is not divided into practice</p>
                <table class="table table-bordered jsTableStudentPractice">
                    <thead>
                    <tr >
                        <td>Name of company</td>
                        <td>Status</td>
                        <td>Practice period</td>
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
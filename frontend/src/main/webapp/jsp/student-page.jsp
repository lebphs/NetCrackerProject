<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<jsp:include page="/jsp/blocks/student-page-source.jsp"/>
<script src="/resources/js/custom/student-page.js"></script>
<body>
<div class="container-fluid">
    <table data-click-to-select="true"
    data-pagination="true" data-page-list="[5,10, 25, 50, 100, ALL]"
    data-search="true" data-toggle="table" class="jsStudentTable">

        <thead>
        <tr>
            <th data-checkbox="true" ></th>
            <th data-field="surname" data-sortable="true">Last Name</th>
            <th data-field="name" data-sortable="true">First Name</th>
            <th data-field="faculty" data-sortable="true">Faculty</th>
            <th data-field="specialty" data-sortable="true">Speciality</th>
            <th data-field="group" data-sortable="true">Group</th>
            <th data-field="isBudget">Is budget</th>
            <th data-field="averageScore" data-sortable="true">Average score</th>
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

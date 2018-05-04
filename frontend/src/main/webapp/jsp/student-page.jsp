<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>More information about student</title>

</head>

<%--<script src="/resources/js/libs/bootstrap.js"></script>--%>
<%--<link href="/resources/css/libs/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>--%>

<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<script src="resources/js/custom/custom.js"></script>
<body>
<br>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-5">
            <div class="card">
                <div class="card-heading">
                    <h3 class="card-title ">User profile</h3>
                </div>
                <div class="card-body">
                    <c:if test="${not empty student}">
                        <table class="table table-striped table-hover jsNameStudentTable">
                            <tr>
                                <td scope="col">L.Name</td>
                                <td scope="col">${student.surname}</td>
                            </tr>
                            <tr>
                                <td scope="col">F.Name</td>
                                <td scope="col">${student.name}</td>
                            </tr>
                            <tr>
                                <td>Comments</td>
                                <td></td>
                            </tr>
                        </table>
                    </c:if>
                </div>
            </div>
            <br>
            <div class="card card-primary">
                <div class="card-heading">
                    <h3 class="card-title">Group</h3>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-hover">
                        <tr>
                            <td scope="col">Faculty</td>
                            <td scope="col">${student.faculty}</td>
                        </tr>
                        <tr>
                            <td scope="col">Specialty</td>
                            <td scope="col">${student.specialty}</td>
                        </tr>
                        <tr>
                            <td scope="col">Group</td>
                            <td scope="col">${student.group}</td>
                        </tr>
                        <tr>
                            <td scope="col">Is budget</td>
                            <td scope="col">${student.isBudget}</td>
                        </tr>
                        <tr>
                            <td scope="col">Average score</td>
                            <td scope="col">${student.averageScore}</td>
                        </tr>
                        <tr>
                            <td scope="col">Status</td>
                            <td scope="col">${student.studentStatus}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-md-5">
            <div class="card card-primary">
                <div class="card-heading ">
                    <h3 class="card-title">Practice</h3>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-hover jsStudentPractices">
                        <thead>
                        <th scope="col">Name of company</th>
                        <th scope="col">Practic period</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${practices}" var="practice">
                            <tr>
                                <td>${practice.companyName}</td>
                                <td>${practice.startDate} - ${practice.finishDate}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                        <tr>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <%--<div class="modal fade" id="assignOneStudent" role="dialog">--%>
        <%--<div class="modal-dialog modal-sm" role="document">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<h2 class="modal-title" align="center">Assign students</h2>--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                        <%--<span aria-hidden="true">&times;</span>--%>
                    <%--</button>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<div class="form-group">--%>
                        <%--<label>Search available demands</label>--%>
                        <%--<select class="form-control jsRequestList jsRequestAssign"></select>--%>
                    <%--</div>--%>
                    <%--<button type="button" data-dismiss="modal" class="btn btn-success jsAssignOneStudent">Create</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<div class="modal fade" id="realiseOneStudent" role="dialog">--%>
        <%--<div class="modal-dialog modal-sm" role="document">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<h2 class="modal-title" align="center">Realise students</h2>--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
                        <%--<span aria-hidden="true">&times;</span>--%>
                    <%--</button>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<div class="form-group">--%>
                        <%--<label>Search available demands</label>--%>
                        <%--<select class="form-control jsRequestList jsRequestRealise"></select>--%>
                    <%--</div>--%>
                    <%--<button type="button" data-dismiss="modal" class="btn btn-success jsRealiseOneStudent">Realise</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>


    <%--<div class="row">--%>
        <%--<div class="col-md-4">--%>
            <%--<button type="button" class="btn btn-primary jsBtnAssignStudent"  data-toggle="modal" data-target="#assignOneStudent" >Assign</button>--%>
        <%--</div>--%>
        <%--<div class="col-md-4">--%>
            <%--<button type="button" class="btn btn-primary jsBtnRealiseStudent" data-toggle="modal" data-target="#realiseOneStudent" id="realise">Realise</button>--%>
        <%--</div>--%>
    <%--</div>--%>
</div>


</body>
</html>

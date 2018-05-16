<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/resources/js/libs/jquery-3.2.1.min.js"></script>
<script src="/resources/js/libs/popper.js"></script>
<script src="/resources/js/libs/bootstrap.js"></script>

<%--<script src="/resources/js/custom/jquery.maskedinput.js" type="text/javascript"></script>--%>
<link href="/resources/css/libs/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
<script src="/resources/js/libs/bootstrap-table.js"></script>
<link href="/resources/css/libs/bootstrap-table.css" rel="stylesheet" type="text/css" media="all"/>
<%--<link href="resources/css/general.css" rel="stylesheet" type="text/css" media="all"/>--%>
<nav class="navbar navbar-dark bg-primary">
    <input type="checkbox" class="jsStudentPage" name="menu" id="btn-menu">
    <label for="btn-menu"><span class="navbar-toggler-icon"></span></label>
    <ul>
        <li>
            <div class="col-md-2">
                <input type="button" class="btn btn-lg btn-primary" value="Show all request"
                       onClick='location.href="request-page"'/>
            </div>
        </li>
        <li>
            <div class="col-md-2">
                <button type="button" class="btn btn-lg btn-primary jsPreloadCreateRequestModal" data-toggle="modal"
                        data-target="#addrequest">Add request
                </button>
            </div>
        </li>
        <li>
            <div class="col-md-2">
                <button type="button" class="btn btn-lg btn-primary jsPreloadCreateStudentModal" data-toggle="modal"
                        data-target="#createstudent">Create student
                </button>
            </div>
        </li>
        <li>
            <div class="col-md-2">
                <button type="button" class="btn btn-lg btn-primary jsAssingStudentsRequests" data-toggle="modal"
                        data-target="#assignstudents">Assign students
                </button>
            </div>
        </li>
        <li>
            <div class="col-md-2">
                <button type="button" class="btn btn-lg btn-primary createSpecialty" data-toggle="modal"
                        data-target="#createspeialty">Create specialty
                </button>
            </div>
        </li>
        <li>
            <div class="col-md-2">
                <button type="button" class="btn btn-lg btn-primary createFaculty" data-toggle="modal"
                        data-target="#createfaculty">Create faculty
                </button>
            </div>
        </li>

        <li>
            <div class="col-md-2">
                <button type="button" class="btn btn-lg btn-primary exit" onClick='location.href="logout"'>Exit
                </button>
            </div>
        </li>

    </ul>
</nav>

<body>
</body>

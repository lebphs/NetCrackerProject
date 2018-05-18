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
            <%--<div class="col-md-2">--%>
            <%--<button type="button" class="btn btn-lg btn-primary exit" onClick='location.href="logout"'><span class="glyphicon glyphicon-log-out"></span>                </button>--%>
            <%--</div>--%>
            <button type="button" class="btn btn-lg btn-primary exit" onClick='location.href="logout"'><img src="/resources/account-logout-6x.png">
            </button>
        </li>

    </ul>
</nav>
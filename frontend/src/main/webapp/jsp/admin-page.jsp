<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Administrator</title>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>
    <%--<script src="http://code.jquery.com/jquery-latest.js"></script>--%>
</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>

<script src="resources/js/custom/adminPage.js"></script>
<script src="resources/js/libs/bootstrap-typeahead.js"></script>
<script src="resources/js/libs/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="/resources/css/adminPage.css">
<link rel="stylesheet" href="resources/css/libs/bootstrap-multiselect.css" type="text/css"/>

<body>


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

    </ul>
</nav>

<div class="modal fade" id="addrequest">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title">Add request</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class=" mb-3">
                        <div class="form-group">
                            <label for="companyName">Company name</label>
                            <input type="text" id="companyName" class="form-control nameCompany" placeholder="Enter name of company"><br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="datefrom">Data from</label>
                                <input type="date" id="datefrom" class=" form-control startDate" required>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="dateTo">Data to</label>
                                <input type="date" class="form-control finishDate" id="dateTo" required><br>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="quantity">Total quantity</label>
                                <input type="text" id="quantity" class="form-control totalQuantity" placeholder="quantity" required>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="faculty">Available faculties</label>
                                <select id="faculty" class="form-control availableFacultiesAddRequest jsFacultiesList">
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <div class="form-group">
                            <label for="specialties">Available specialties</label>
                            <select id="specialties" class="form-control availableSpecialtiesAddRequest">
                            </select>
                        </div>
                    </div>

                    <div class="mb-0">
                        <div class="form-group">
                            <label for="minScore">Min. average score</label>
                            <input id="minScore" type="text" class="form-control minScore" placeholder="min score">
                            <div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="usernameHeadOfPractice">Username head of practice</label>
                                <input type="text" id="usernameHeadOfPractice" placeholder="username" class=" form-control jsNameHeadOfPractice" required>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="passwordHeadOfPractice">Password</label>
                                <input type="password" class="form-control jsPasswordHead" placeholder="password" id="passwordHeadOfPractice" required><br>
                            </div>
                        </div>
                    </div>
                    <button type="button" data-dismiss="modal" class="btn btn-success jsCreateRequest">Create</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createstudent" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog  modal-sm" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <h2 class="modal-title" align="center">Create student</h2>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control jsSurname" placeholder="Surname">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control jsName" placeholder="Name">
                </div>
                <div class="form-group">
                    <select class="form-control availableFacultiesAddStudents jsFacultiesList">
                    </select>
                </div>
                <div class="form-group">
                    <select class="form-control availableSpecialtiesAddStudents">
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control jsGroup" placeholder="Group number">
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-md-6">
                            <label class="radio-inline">
                                <input type="radio" name="isBudget" id="isBudget" value="true" checked> Budget
                            </label>
                        </div>
                        <div class="col-md-6">
                            <label class="radio-inline">
                                <input type="radio" name="isBudget" value="false"> Paid
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control jsAverageScore" id="scoreAverage" placeholder="Average score">
                </div>
                <button type="button" data-dismiss="modal" class="btn btn-success jsAddStudent">Create</button>
            </form>
        </div>
    </div>
</div>
</div>

<!-- Modal Assign student-->
<div class="modal fade" id="assignstudents" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center">Assign students</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label>Search available students</label>
                                    <select class="jsStudentMultiselect" multiple="multiple">
                                    </select>
                                    <%--<select class="form-control jsAssingStudentRequest" type="text" id="availableStudent" required></select>--%>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label>Search available demands</label>
                                    <select class="form-control jsRequestList jsRequestAssignModal"></select>
                                    <%--<select class="form-control " id="availableDemands" required></select><br>--%>
                                </div>
                        </div>

                    </div>
                    <button type="button" data-dismiss="modal" class="btn btn-success jsAssignStudent">Create</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!--Modal Create specialtyViewModel-->
<div class="modal fade" id="createspeialty" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog  modal-sm" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <h2 class="modal-title" id="exampleModalLabel" align="center">Create specialty</h2>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control nameSpecialty" placeholder="Name of specialty" required>
                </div>
                <div class="form-group">
                    <select class="form-control availableFacultiesForCreateSpecialty jsFacultiesList">
                    </select>
                </div>
                <button type="button" data-dismiss="modal" class="btn btn-success jsCreateSpecialty">Create</button>
            </form>
        </div>
    </div>
</div>
</div>

<!-- Modal Create facultyViewModel -->
<div class="modal fade" id="createfaculty" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <h2 class="modal-title" align="center">Create faculty</h2>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>

        <div class="modal-body">
            <form>
                <div class="form-group">
                    <label>Name of faculty</label><br>
                    <input type="text" class="form-control nameFaculty" required><br>
                </div>
                <button type="button" data-dismiss="modal" class="btn btn-success jsCreateFaculty">Create</button>
            </form>
        </div>
    </div>
</div>
</div>
<div class="container-fluid">
    <table
            data-sort-order="asc"
            data-sort-name="surname"
            data-click-to-select="true"
           data-pagination="true"
           data-side-pagination="server"
           data-url="/studentsTable"
           data-page-list="[5,10, 25, 50, 100, ALL]"
           data-search="true"
           data-toggle="table"
           class="jsStudentsTable">

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

<div class="modal fade" id="assignOneStudent" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center">Assign students</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Search available demands</label>
                    <select class="form-control jsRequestList jsRequestAssign"></select>
                </div>
                    <button type="button" data-dismiss="modal" class="btn btn-success jsAssignOneStudent">Create</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="realiseOneStudent" role="dialog">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title" align="center">Realise students</h2>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Search available demands</label>
                    <select class="form-control jsRequestList jsRequestRealise"></select>
                </div>
                <button type="button" data-dismiss="modal" class="btn btn-success jsRealiseOneStudent">Realise</button>
            </div>
        </div>
    </div>
</div>



<div class="container-fluid">
    <br>
    <div class="row" id="adminButton" >
        <div class="col-md-4" >
            <button type="submit" class="btn btn-success   btn-block jsDeleteStudent" id="delete" disabled>Delete </button>
        </div>
        <div class="col-md-4">
            <button type="submit" class="btn btn-success  btn-block jsAssignStudentBtn"  data-toggle="modal" data-target="#assignOneStudent" disabled>Assign</button>
        </div>
        <div class="col-md-4">
            <button type="submit" class="btn btn-success  btn-block jsRealiseStudentBtn" data-toggle="modal" data-target="#realiseOneStudent" id="realise" disabled>Realise</button>
        </div>
    </div>
</div>

</body>
</html>
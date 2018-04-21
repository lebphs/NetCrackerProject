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
<link rel="stylesheet" href="resources/css/libs/bootstrap-multiselect.css" type="text/css"/>

<body>

<nav class="navbar navbar-dark bg-primary">
    <img class="mb-4" src="/resources/logo.png" alt="" width="110" height="50">
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#exCollapsing" aria-controls="exCollapsing" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav><br>


<div class="container-fluid collapsing" id="exCollapsing">
    <div class="row">
        <div class="col-md-2">
            <input type="button" class="btn btn-lg btn-primary" value="Show all request" onClick='location.href="request-page"'/>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-lg btn-primary jsPreloadCreateRequestModal" data-toggle="modal" data-target="#addrequest">Add request</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-lg btn-primary jsPreloadCreateStudentModal" data-toggle="modal" data-target="#createstudent" >Create student</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-lg btn-primary jsAssingStudentsRequests" data-toggle="modal" data-target="#assignstudents">Assign students</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-lg btn-primary createSpecialty" data-toggle="modal" data-target="#createspeialty">Create specialty</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-lg btn-primary createFaculty" data-toggle="modal" data-target="#createfaculty">Create faculty</button>
        </div>
    </div>
</div>

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
                            <!-- <label for="companyName">Company name</label> -->
                            <input type="text" class="form-control nameCompany" placeholder="Enter name of company"><br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="dateFrom">data from</label>
                                <input type="date" class="form-control startDate" id="dateFrom" required>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="dateTo">data to</label>
                                <input type="date" class="form-control finishDate" id="dateTo" required><br>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <input type="text" class="form-control totalQuantity" placeholder="quantity" required>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <select class="form-control availableFacultiesAddRequest jsFacultiesList">
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <div class="form-group">
                            <!-- <label for="availableSpecialties">available specialties</label> -->
                            <!-- <input type="text" class="form-control" id="availableSpecialties" placeholder="available specialties"> -->
                            <select class="form-control availableSpecialtiesAddRequest">
                            </select>
                        </div>
                    </div>

                    <div class="mb-0">
                        <div class="form-group">
                            <!-- <label for="minScore">min score</label> -->
                            <input type="text" class="form-control minScore" placeholder="min score">
                            <div>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-success jsCreateRequest">Create</button>
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
                <button type="button" class="btn btn-success jsAddStudent" data-dismiss="modal" id="createNewStudent">Create</button>
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
                                    <select class="form-control jsRequestList"></select>
                                    <%--<select class="form-control " id="availableDemands" required></select><br>--%>
                                </div>
                        </div>

                    </div>
                    <button type="button" class="btn btn-success jsAssignStudent">Create</button>
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
                <button type="button" class="btn btn-success jsCreateSpecialty">Create</button>
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
                <button type="button" class="btn btn-success jsCreateFaculty">Create</button>
            </form>
        </div>
    </div>
</div>
</div>
<div class="container-fluid">
    <table data-click-to-select="true"
           data-pagination="true" data-page-list="[10, 25, 50, 100, ALL]"
           data-search="true" data-toggle="table" class="jsStudentsTable">

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
            <th data-field="studentStatus" >Status<th>
            <%--<th data-field="nameCompany">Name of company</th>--%>
            <%--<th data-field="practicePeriod">Practic period</th>--%>
        </tr>
        </thead>
    </table >
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
                    <select class="form-control jsRequestList"></select>
                </div>
                    <button type="button" class="btn btn-success jsAssignOneStudent">Create</button>
            </div>
        </div>
    </div>
</div>


<div class="container-fluid">
    <br>
    <div class="row" id="adminButton" >
        <div class="col-md-3" >
            <button type="button" class="btn btn-primary jsDeleteStudent" id="delete" disabled>Delete </button>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-primary jsAssignStudentBtn"  data-toggle="modal" data-target="#assignOneStudent" disabled>Assign</button>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-primary jsRealiseStudent" id="realise" disabled>Realise</button>
        </div>
        <div class="col-md-3">
            <button type="button" class="btn btn-primary jsShowInfoStudent" id="info" disabled>Show Info</button>
        </div>
    </div>
</div>

</body>
</html>
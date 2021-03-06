<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Administrator</title>

</head>
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
<jsp:include page="/jsp/blocks/admin-page-title.jsp"/>


<script src="resources/js/custom/adminPage.js"></script>
<script src="resources/js/libs/bootstrap-typeahead.js"></script>
<script src="resources/js/libs/bootstrap-multiselect.js"></script>
<script src="/resources/js/libs/jquery.inputmask.bundle.js" type="text/javascript"></script>
<script src="/resources/js/custom/validation.js" type="text/javascript"></script>
<link rel="stylesheet" href="/resources/css/adminPage.css">
<link rel="stylesheet" href="resources/css/libs/bootstrap-multiselect.css" type="text/css"/>

<body>


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
                            <div>
                                <label class="labelHide" style="display: none"></label>
                                <input type="text" id="companyName" class="form-control nameCompany" placeholder="Enter name of company">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="datefrom">Data from</label>
                                <div>
                                    <label class="labelHide" style="display: none"></label>
                                    <input type="date" id="datefrom" class=" form-control startDate" required>
                                </div>

                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="dateTo">Data to</label>
                                <div>
                                    <label class="labelHide" style="display: none"></label>
                                    <input type="date" class="form-control finishDate" id="dateTo" required>
                                </div>

                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="quantity">Total quantity</label>
                                <div>
                                    <label class="labelHide" style="display: none"></label>
                                    <input type="text" id="quantity" class="form-control numerical totalQuantity" placeholder="quantity" required>
                                </div>

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
                            <div>
                                <label class="labelHide" style="display: none"></label>
                                <input id="minScore" type="text" class="form-control floating minScore" placeholder="min score">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="usernameHeadOfPractice">Username head of practice</label>
                                <div><label class="labelHide" style="display: none"></label>
                                    <input type="text" id="usernameHeadOfPractice" placeholder="username" class=" form-control jsNameHeadOfPractice" required>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="passwordHeadOfPractice">Password</label>
                                <div>
                                    <label class="labelHide" style="display: none"></label>
                                    <input type="password" class="form-control jsPasswordHead" placeholder="password" id="passwordHeadOfPractice" required>
                                </div>

                            </div>
                        </div>
                    </div>
                    <button type="button"  class="btn btn-success jsCreateRequest">Create</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createstudent">
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
                    <label for="FirstName">First name</label>
                    <div>
                        <label class="labelHide" style="display: none"></label>
                        <input type="text" id="FirstName" class="form-control jsSurname" placeholder="First name">
                    </div>

                </div>
                <div class="form-group">
                    <label for="LastName">Last name</label>
                    <div>
                        <label class="labelHide" style="display: none"></label>
                        <input type="text" id="LastName" class="form-control jsName" placeholder="Last name">
                    </div>

                </div>
                <div class="form-group">
                    <label for="availableFaculties">Available faculties</label>
                    <select id="availableFaculties" class="form-control availableFacultiesAddStudents jsFacultiesList">
                    </select>
                </div>
                <div class="form-group">
                    <label for="availableSpecialties">Available specialties</label>
                    <select id="availableSpecialties" class="form-control availableSpecialtiesAddStudents">
                    </select>
                </div>
                <div class="form-group">
                    <label for="group">Group</label>
                    <div>
                        <label class="labelHide" style="display: none"></label>
                        <input id="group" type="text" class="form-control numerical jsGroup" placeholder="Group number">
                    </div>

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
                    <label for="scoreAverage">Average score</label>
                    <div>
                        <label class="labelHide" style="display: none"></label>
                        <input type="text" class="form-control floating jsAverageScore" id="scoreAverage" placeholder="Average score">
                    </div>
                </div>
                <button type="button"  class="btn btn-success jsAddStudent">Create</button>
            </form>
        </div>
    </div>
</div>
</div>

<div class="modal fade" id="editStudent">
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
                        <label for="FirstNameEdit">First name</label>
                        <div>
                            <label class="labelHide" style="display: none"></label>
                            <input type="text" id="FirstNameEdit" class="form-control jsSurnameEdit" placeholder="First name">
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="LastNameEdit">Last name</label>
                        <div>
                            <label class="labelHide" style="display: none"></label>
                            <input type="text" id="LastNameEdit" class="form-control jsNameEdit" placeholder="Last name">
                        </div>

                    </div>
                    <div class="form-group">
                        <label for="availableFacultiesEdit">Available faculties</label>
                        <select id="availableFacultiesEdit" class="form-control availableFacultiesEditStudents jsFacultiesList" disabled>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="availableSpecialtiesEdit">Available specialties</label>
                        <select id="availableSpecialtiesEdit" class="form-control availableSpecialtiesEditStudents" disabled>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="groupEdit">Group</label>
                        <div>
                            <label class="labelHide" style="display: none"></label>
                            <input id="groupEdit" type="text" class="form-control numerical jsGroupEdit" placeholder="Group number">
                        </div>

                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-md-6">
                                <label class="radio-inline">
                                    <input type="radio" name="isBudget" id="isBudgetEdit" value="true" checked> Budget
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
                        <label for="scoreAverageEdit">Average score</label>
                        <div>
                            <label class="labelHide" style="display: none"></label>
                            <input type="text" class="form-control floating jsAverageScoreEdit" id="scoreAverageEdit" placeholder="Average score">
                        </div>
                    </div>
                    <button type="button"  class="btn btn-success jsEditStudent">Create</button>
                </form>
            </div>
        </div>
    </div>
</div>


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
                    <label for="nameSpecialty">Name specialty</label>
                    <div>
                        <label class="labelHide" style="display: none"></label>
                        <input type="text" id="nameSpecialty" class="form-control nameSpecialty" placeholder="Name of specialty" required>
                    </div>
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
                    <label>Name of faculty</label>
                    <div>
                        <label class="labelHide" style="display: none"></label>
                        <input type="text" class="form-control nameFaculty" required>
                    </div>

                </div>
                <button type="button" class="btn btn-success jsCreateFaculty">Create</button>
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
                <p class="notPractice">No suitable practice</p>
                <div class="jsDropdown">
                    <div class="form-group">
                    <label>Search available demands</label>
                    <select class="form-control jsRequestList jsRequestAssign"></select>
                </div>
                    <button type="button" data-dismiss="modal" class="btn btn-success jsAssignOneStudent">Create</button>
                </div>

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
                <p class="notPractice">Student is not assigned to practice</p>
                <div class="jsDropdown">
                    <div class="form-group">
                        <label>Search available demands</label>
                        <select class="form-control jsRequestList jsRequestRealise"></select>
                    </div>
                    <button type="button" data-dismiss="modal" class="btn btn-success jsRealiseOneStudent">Realise</button>
                </div>
            </div>
        </div>
    </div>
</div>



<div class="container-fluid">
    <br>
    <div class="row" id="adminButton" >
        <div class="col-md-3" >
            <button type="submit" class="btn btn-success   btn-block jsDeleteStudent" id="delete" disabled>Delete </button>
        </div>
        <div class="col-md-3">
            <button type="submit" class="btn btn-success  btn-block jsAssignStudentBtn"  data-toggle="modal" data-target="#assignOneStudent" disabled>Assign</button>
        </div>
        <div class="col-md-3">
            <button type="submit" class="btn btn-success  btn-block jsRealiseStudentBtn" data-toggle="modal" data-target="#realiseOneStudent" id="realise" disabled>Realise</button>
        </div>
        <div class="col-md-3">
            <button type="submit" class="btn btn-success  btn-block jsEditStudentBtn" data-toggle="modal" data-target="#editStudent" id="edit" disabled>Edit student</button>
        </div>
    </div>
</div>

</body>
</html>
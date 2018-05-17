<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login page</title>
</head>
<jsp:include page="/jsp/blocks/student-page-source.jsp"/>
<script src="/resources/js/custom/requestPage.js"></script>
<script src="/resources/js/libs/jquery.inputmask.bundle.js" type="text/javascript"></script>
<script src="/resources/js/custom/validation.js" type="text/javascript"></script>
<%--<script src="resources/bootstrap-typeahead.js"></script>--%>


<body>

<div class="container-fluid">
    <table data-click-to-select="true"
           data-sort-name="companyName"
           data-pagination="true"
           data-side-pagination="server"
           data-url="/requestsTable"
           data-page-list="[5,10, 25, 50, 100, ALL]"
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
            <button type="submit" class="btn btn-success btn-block jsDeleteRequest"> Delete</button>
        </div>
        <div class="col-6 col-md-4">
            <button type="submit" data-toggle="modal" data-target="#editrequest" disabled
                    class="btn btn-success btn-block  jsEditRequest">Edit
            </button>
        </div>
        <div class="col-6 col-md-4">
            <button type="submit" data-toggle="modal" data-target="#assignOneStudent" disabled
                    class="btn btn-success btn-block jsAssignRequestPage">Assign
            </button>
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
                    <p class="notPractice">No suitable practice</p>
                    <div class="jsDropdown">
                        <label>Search available students</label>
                        <select class="form-control jsStudentList"></select>
                    </div>
                    <button type="button" data-dismiss="modal" class="btn btn-success jsAssignStudentRequestPage">Create</button>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="editrequest">
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
                            <input type="text" id="companyName" class="form-control nameCompany" placeholder="Enter name of company" disabled><br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="datefrom">Data from</label>
                                <div>
                                    <label class="labelHide" style="display: none"></label>
                                    <input type="date" id="datefrom" class=" form-control startDateEdit" required>
                                </div>

                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="dateTo">Data to</label>
                                <div>
                                    <label class="labelHide" style="display: none"></label>
                                    <input type="date" class="form-control finishDateEdit" id="dateTo" required>
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
                                    <input type="text" id="quantity" class="form-control numerical totalQuantityEdit" placeholder="quantity" required>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="faculty">Available faculties</label>
                                <select id="faculty" class="form-control availableFacultiesAddRequest jsFacultiesList" disabled>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <div class="form-group">
                            <label for="specialties">Available specialties</label>
                            <select id="specialties" class="form-control availableSpecialtiesAddRequest" disabled>
                            </select>
                        </div>
                    </div>

                    <div class="mb-0">
                        <div class="form-group">
                            <label for="minScore">Min. average score</label>
                            <div>
                                <label class="labelHide" style="display: none"></label>
                                <input id="minScore" type="text" class="form-control floating minScoreEdit" placeholder="min score">
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-success jsEditBtnRequest">Create</button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
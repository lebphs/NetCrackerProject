<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Administrator</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <%--<img class="mb-4" src="/resources/logo.png" alt="" width="120" height="40">--%>
</nav>
<script src="resources/js/custom/adminPage.js"></script>
<div class="container-fluid">
    <br>
    <div class="row">
        <div class="col-md-2">
            <input type="button" class="btn btn-primary" value="Show all request" onClick='location.href="requestAllPage.jsp"'/>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addrequest">Add request</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createstudent">Create student</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#assignstudents">Assign students</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createspeialty">Create specialty</button>
        </div>
        <div class="col-md-2">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createfaculty">Create faculty</button>
        </div>
    </div>
</div>

<!-- The Modal -->
<div class="modal fade" id="addrequest">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title" align="center" >Add request</h2>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <div class="container-fluid">
                    <div class=" mb-3">
                        <div class="form-group">
                            <!-- <label for="companyName">Company name</label> -->
                            <input type="text" class="form-control" id="namecompany" placeholder="Enter name of company"><br>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="dataFrom">data from</label>
                                <input type="date" class="form-control" id="dataFrom" required>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <label for="dateTo">data to</label>
                                <input type="date" class="form-control" id="dateTo" required><br>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <div class="form-group">
                                <input type="text" class="form-control" id="quantity" placeholder="quantity" required>
                            </div>
                        </div>

                        <div class="col-md-6 mb-3">
                            <!-- <label for="availableFacul">available faculties</label> -->
                            <!-- <input type="text" class="form-control" id="dateTo"> -->
                            <div class="form-group">
                                <select class="form-control" id="availableFaculties">
                                    <option>FTK</option>
                                    <option>FITU</option>
                                    <option>FRE</option>
                                    <option>FKSIS</option>
                                    <option>FIK</option>
                                    <option>FINO</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="mb-3">
                        <div class="form-group">
                            <!-- <label for="availableSpecialties">available specialties</label> -->
                            <!-- <input type="text" class="form-control" id="availableSpecialties" placeholder="available specialties"> -->
                            <select class="form-control" id="availableSpecialties">
                            </select>
                        </div>
                    </div>

                    <div class="mb-0">
                        <div class="form-group">
                            <!-- <label for="minScore">min score</label> -->
                            <input type="text" class="form-control" id="minScore" placeholder="min score">
                            <div>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-success ">Create</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="createstudent" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog  modal-sm" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h2 class="modal-title" align="center">Create student</h2>
        </div>
        <div class="modal-body">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control" id="surname" placeholder="Surname">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control jsInputName" id="name" placeholder="Name">
                </div>
                <div class="form-group">
                    <select class="form-control" id="availableFaculty">
                        <option>FTK</option>
                        <option>FITU</option>
                        <option>FRE</option>
                        <option>FKSIS</option>
                        <option>FIK</option>
                        <option>FINO</option>
                    </select>
                </div>
                <div class="form-group">
                    <select class="form-control" id="availableSpecialty">
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control jsInputGroup" id="group" placeholder="Group number">
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
                    <input type="text" class="form-control" id="averageScore" placeholder="Average score">
                </div>
                <button type="button" class="btn btn-danger jsSendData" data-dismiss="modal" id="createNewStudent">Create</button>
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
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title" align="center">Assign students</h2>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="availableStudent">Search available students</label>
                                    <input class="typehead" type="text" class="form-control" id="availableStudent" required>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label>Search available demands</label>
                                    <input class="typehead" type="text" class="form-control" id="availableDemands" required><br>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-success ">Create</button>
                </form>
            </div>
        </div>
    </div>
</div>
</div>

<!--Modal Create specialty-->
<div class="modal fade" id="createspeialty" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog  modal-sm" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <h2 class="modal-title" id="exampleModalLabel" align="center">Create specialty</h2>
        </div>
        <div class="modal-body">
            <form>
                <div class="form-group">
                    <input type="text" class="form-control" id="specialty" placeholder="Name of specialty" required>
                </div>
                <div class="form-group">
                    <select class="form-control" id="availblefaculty">
                        <option>FTK</option>
                        <option>FITU</option>
                        <option>FRE</option>
                        <option>FKSIS</option>
                        <option>FIK</option>
                        <option>FINO</option>
                    </select>
                </div>
                <button type="button" class="btn btn-success ">Create</button>
            </form>
        </div>
    </div>
</div>
</div>

<!-- Modal Create faculty -->
<div class="modal fade" id="createfaculty" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <h2 class="modal-title" align="center">Create faculty</h2>
        </div>

        <div class="modal-body">
            <form>
                <div class="form-group">
                    <label>Name of faculty</label><br>
                    <input type="text" class="form-control" id="faculty" required><br>
                </div>
                <button type="button" class="btn btn-success ">Create</button>
            </form>
        </div>
    </div>
</div>
</div><br>

<table class="table table-bordered">
    <thead>
    <tr>
        <th >Check</th>
        <th scope="col">L.Name</th>
        <th scope="col">F.Name</th>
        <th scope="col">Faculty</th>
        <th scope="col">Specialty</th>
        <th scope="col">Group</th>
        <th scope="col">Is budget</th>
        <th scope="col">Average score</th>
        <th scope="col">Status</th>
        <th scope="col">Name of company</th>
        <th scope="col">Practic period</th>
        <th scope="col">Btn "Show info"</th>
    </tr>
    </thead>
    <tbody class="tableWithAllStudents jsAdded">
        <c:if test="${not empty students}">
            <c:forEach items="${students}" var="students">
                <tr>
                    <td><input type="checkbox"></td>
                    <td>${students.surname}</td>
                    <td>${students.name}</td>
                    <td>${students.faculty}</td>
                    <td>${students.specialty}</td>
                    <td>${students.group}</td>
                    <td>${students.isBudget}</td>
                    <td>${students.averageScore}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><a href="../jsp/aboutStudent.jsp" class="btn btn-info">Info</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>

<div class="container-fluid">
    <br>
    <div class="row" id="row" >
        <div class="col-md-4" >
            <button type="button" class="btn btn-primary" id="delete" disabled>Delete </button>
        </div>
        <div class="col-md-4">
            <button type="button" class="btn btn-primary" id="assign" disabled>Assign</button>
        </div>
        <div class="col-md-4">
            <button type="button" class="btn btn-primary" id="realise" disabled>Realise</button>
        </div>
    </div>
</div>
<script>
    $('input[type="checkbox"]').click(function(){
        if( $(this).is(':checked') ) {
            $("#delete").attr('disabled', false);
            $("#assign").attr('disabled', false);
            $("#realise").attr('disabled', false);

            document.getElementById("delete").disabled;
        }
    });
</script>

<div>
    <h3>Printing data using js & ajax</h3>
    <div class="jsDataUsingAjaxStudent">
    </div>
</div>
<br>
<br>
Sending Data on server:
<%--<div class="form-inline">--%>
    <%--<label class="sr-only" for="inlineFormInputId">Id</label>--%>
    <%--<input type="text" class="form-control mb-2 mr-sm-2 jsInputGroup" id="inlineFormInputId" placeholder="001">--%>
    <%--<label class="sr-only" for="inlineFormInputName">Name</label>--%>
    <%--<input type="text" class="form-control mb-2 mr-sm-2 jsInputName" id="inlineFormInputName" placeholder="Tom">--%>

    <%--<button  class="btn btn-primary mb-2 jsSendData">Send data</button>--%>
<%--</div>--%>

<br>
<div class="jsAddedStudent">
</div>

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
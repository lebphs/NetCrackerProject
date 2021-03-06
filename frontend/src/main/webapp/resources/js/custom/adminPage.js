$(document).ready(function () {

    var indexSelected = 0;
    $(".jsStudentsTable").on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
        $(".jsDeleteStudent").prop('disabled', !$(".jsStudentsTable").bootstrapTable('getSelections').length);
        $(".jsAssignStudentBtn").prop('disabled', !($(".jsStudentsTable").bootstrapTable('getSelections').length === 1));
        $(".jsRealiseStudentBtn").prop('disabled', !($(".jsStudentsTable").bootstrapTable('getSelections').length === 1));
        $(".jsEditStudentBtn").prop('disabled', !($(".jsStudentsTable").bootstrapTable('getSelections').length === 1));
    });

    $(".jsPreloadCreateStudentModal").click(function (event) {
        getFacultiesList();
        getSpecialtiesByFacultyIdForAddStudents();
    });

    $(".jsPreloadCreateRequestModal").click(function (event) {
        getFacultiesList();
        getSpecialtiesByFacultyIdForAddRequest();
    });

    $(".jsAssignStudentBtn").click(function () {
        var idStudent = getIdSelections();
        getRequestFitDescriptionForAssign(idStudent);
    });

    $(".jsRealiseStudentBtn").click(function () {
        var idStudent = getIdSelections();
        getRequestFitDescriptionForRealise(idStudent);
    });

    $(".createSpecialty").click(function (event) {
        getFacultiesList();
    });

    $(".availableFacultiesAddStudents").change(function () {
        getSpecialtiesByFacultyIdForAddStudents();
    });
    $(".availableFacultiesAddRequest").change(function (event) {
        getSpecialtiesByFacultyIdForAddRequest()
    });

    $(".jsAssignOneStudent").click(function () {
        var obj = {
            studentsList: getIdSelections(),
            requestsList: [$(".jsRequestAssign").find("option:selected").val()]
        };
        $.ajax({
            url: 'assign-students',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {
                $(".jsStudentsTable").bootstrapTable('load', students);
            }
        });
    });

    $(".jsRealiseOneStudent").click(function () {
        var obj = {
            studentsList: getIdSelections(),
            requestsList: [$(".jsRequestRealise").find("option:selected").val()]
        };
        $.ajax({
            url: 'realise-students',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {
                $(".jsStudentsTable").bootstrapTable('load', students);
            }
        });
    });

    $(".jsRequestAssignModal").change(function () {
        var idRequest = $(".jsRequestAssignModal").find("option:selected").val();
        getStudentFitDescription(idRequest);
        $.ajax({
            url: 'requestById',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: idRequest},
            success: function (requests) {
                $(".jsStudentMultiselect").change(function () {
                    var countSelect = $(".jsStudentMultiselect").find("option:selected").length;

                    if (countSelect > requests.totalQuantity) {
                        $(".jsAssignStudent").prop('disabled', true);
                    }
                    else {
                        $(".jsAssignStudent").prop('disabled', false);
                    }
                })
            }
        });
    });

    $(".jsAssignStudent").click(function () {
        var obj = {
            requestsList: [$(".jsRequestAssignModal").find("option:selected").val()],
            studentsList: $(".jsStudentMultiselect").val()
        };
        $.ajax({
            url: 'assign-students',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (students) {
                $(".jsStudentsTable").bootstrapTable('load', students);
            }
        });
    });


    function getStudentFitDescription(idRequest) {
        $.ajax({
            url: 'studentsForMultiselect',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: idRequest},
            success: function (students) {
                $(".jsStudentMultiselect").empty();
                students ? function () {
                    students.some(function (student) {
                        $(".jsStudentMultiselect").append('<option value=' + student.id + '>' + student.surname + ' ' + student.name + '</option>');
                        $(".jsStudentMultiselect").multiselect('rebuild');
                    });
                }() : false;
            }
        });
    }

    function getRequestFitDescriptionForAssign(idStudent) {
        var assignWindow = $("#assignOneStudent");
        $.ajax({
            url: 'requestsForDropdownAssign',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: idStudent.toString()},
            success: function (requests) {
                $(".jsRequestAssign").empty();

                if (requests.length) {
                    assignWindow.find(".notPractice").hide();
                    assignWindow.find(".jsDropdown").show();
                    requests ? function () {
                        requests.some(function (request) {
                            $(".jsRequestAssign").append('<option value=' + request.id + '>' + request.companyName + ' ' + request.availableQuantity + '</option>');
                        });
                    }() : false;
                } else {
                    assignWindow.find(".notPractice").show();
                    assignWindow.find(".jsDropdown").hide();
                }


            }
        });
    }

    function getRequestFitDescriptionForRealise(idStudent) {
        var realiseWindow = $("#realiseOneStudent");
        $.ajax({
            url: 'requestsForDropdownRealise',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: idStudent.toString()},
            success: function (requests) {
                $(".jsRequestRealise").empty();
                if (requests.length) {
                    realiseWindow.find(".notPractice").hide();
                    realiseWindow.find(".jsDropdown").show();
                    requests ? function () {
                        requests.some(function (request) {
                            $(".jsRequestRealise").append('<option value=' + request.id + '>' + request.companyName + ' ' + request.availableQuantity + '</option>');
                        });
                    }() : false;
                } else {
                    realiseWindow.find(".notPractice").show();
                    realiseWindow.find(".jsDropdown").hide();
                }
            }
        });
    }


    $(".jsAssingStudentsRequests").click(function () {
        getRequestList();
        var idRequest = $(".jsRequestAssignModal").find("option:selected").val();
        getStudentFitDescription(idRequest);

    });

    $('.jsStudentMultiselect').multiselect({
        buttonWidth: '200px',
        maxHeight: 400,
        includeSelectAllOption: true,
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true
    });

    $(".jsAddStudent").click(function (event) {
        event.stopPropagation();
        var specialtyId = $(".availableSpecialtiesAddStudents").find("option:selected").val();
        var obj = {
            surname: $(".jsSurname").val(),
            name: $(".jsName").val(),
            specialtyId: specialtyId,
            group: $(".jsGroup").val(),
            isBudget: $('input[name=isBudget]:checked').val(),
            averageScore: $(".jsAverageScore").val()
        };
        validateOnEmpty([$(".jsSurname"), $(".jsName"), $(".jsGroup"), $(".jsAverageScore")]);
        alert(getValidationError());

        if (!getValidationError()) {
            $.ajax({
                url: 'create-student',
                type: 'POST',
                dataType: 'json',
                contentType: "application/json",
                mimeType: 'application/json',
                data: JSON.stringify(obj),
                success: function (addedStudent) {
                    $(".jsStudentsTable").bootstrapTable('append', addedStudent);
                    $("#createstudent").hide();
                    $(document.getElementsByClassName("modal-backdrop")).remove();
                },
                error: function (xhr) {
                    xhr.status == 500 ? alert('Date are not correct.') : alert('Something went wrong, try again later.')
                }
            });
        }
    });


    function getFacultiesList() {
        $.ajax({
            async: false,
            url: 'faculties',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            success: function (faculties) {
                $(".jsFacultiesList").empty();
                faculties ? function () {
                    faculties.some(function (faculty) {
                        $(".jsFacultiesList").append('<option value=' + faculty.id + '>' + faculty.name + '</option>');
                    });
                }() : false;
                //$(".jsFacultiesList").prop("selectedIndex", -1);
            }
        });
    }

    function getRequestList() {
        $.ajax({
            async: false,
            url: 'requestsFitAssign',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            success: function (requests) {
                $(".jsRequestList").empty();
                requests ? function () {
                    requests.some(function (request) {
                        $(".jsRequestList").append('<option value=' + request.id + '>' + request.companyName + ' ' + request.availableQuantity + '</option>');
                    });
                }() : false;
            }
        });
    }

    function getSpecialtiesByFacultyIdForAddStudents() {
        var currentId = $(".availableFacultiesAddStudents").find("option:selected").val();
        $.ajax({
            url: 'specialtiesList',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: currentId},
            success: function (specialties) {
                $(".availableSpecialtiesAddStudents").empty();
                specialties ? function () {
                    specialties.some(function (specialty) {
                        $(".availableSpecialtiesAddStudents").append('<option value=' + specialty.id + '>' + specialty.name + '</option>');

                    });
                }() : false;
            }
        });
    }

    function getSpecialtiesByFacultyIdForAddRequest() {
        var currentId = $(".availableFacultiesAddRequest").find("option:selected").val();
        $.ajax({
            url: 'specialtiesList',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: currentId},
            success: function (specialties) {
                $(".availableSpecialtiesAddRequest").empty();
                specialties ? function () {
                    specialties.some(function (specialty) {
                        $(".availableSpecialtiesAddRequest").append('<option value=' + specialty.id + '>' + specialty.name + '</option>');

                    });
                }() : false;
            }
        });
    }

    $(".jsDeleteStudent").click(function () {
        var ids = getIdSelections();
        $.ajax({
            url: 'delete-students',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(ids)
        });
        $(".jsStudentsTable").bootstrapTable('remove', {
            field: 'id',
            values: ids
        });

        $(".jsDeleteStudent").prop('disabled', true);
        $(".jsRealiseStudentBtn").prop('disabled', true);
        $(".jsAssignStudentBtn").prop('disabled', true);
        $(".jsEditStudentBtn").prop('disabled', true);
    });

    function getIdSelections() {
        return $.map($(".jsStudentsTable").bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }
    $(".jsStudentsTable").on('check.bs.table', function (e, row, $el) {
        indexSelected = $el.closest('tr').data('index');
    });

    $(".jsEditStudent").click(function () {
        event.stopPropagation();
        var specialtyId = $(".availableSpecialtiesEditStudents").find("option:selected").val();
        var obj = {
            id: getIdSelections().toString(),
            surname: $(".jsSurnameEdit").val(),
            name: $(".jsNameEdit").val(),
            specialtyId: specialtyId,
            group: $(".jsGroupEdit").val(),
            isBudget: $('input[name=isBudget]:checked').val(),
            averageScore: $(".jsAverageScoreEdit").val()
        };
        validateOnEmpty([$(".jsSurnameEdit"), $(".jsNameEdit"), $(".jsGroupEdit"), $(".jsAverageScoreEdit")]);
        alert(getValidationError());
        alert("edit");
        if (!getValidationError()) {
            $.ajax({
                url: 'editStudent',
                type: 'POST',
                dataType: 'json',
                contentType: "application/json",
                mimeType: 'application/json',
                data: JSON.stringify(obj),
                success: function (request) {
                    alert(indexSelected);
                    $(".jsStudentsTable").bootstrapTable('updateRow',{index:indexSelected,row:request});
                    $("#editStudent").hide();
                    $(document.getElementsByClassName("modal-backdrop")).remove();
                },
                error: function (event) {
                    alert("Wrong data!");
                }
            });
        }
    });

    $(".jsEditStudentBtn").click(function () {
        var obj={studentId: getIdSelections().toString()};

        $.ajax({
            url: 'studentForEdit',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: obj,
            success: function (student) {
                $(".jsSurnameEdit").val(student.surname);
                $(".jsNameEdit").val(student.name);
                $(".jsGroupEdit").val(student.group);
                // $(".isBudgetEdit").$('input[name=isBudget]:checked').val();
                $(".availableFacultiesEditStudents").append('<option>' +student.faculty+ '</option>');
                $(".availableSpecialtiesEditStudents").append('<option value='+student.specialtyId+'>' +student.specialty+ '</option>');
                $(".jsAverageScoreEdit").val(student.averageScore);
                //$(".jsRequestsTable").bootstrapTable('load', requests);
            }
        });
    });

    $(".jsCreateSpecialty").click(function () {
        var obj = {
            name: $(".nameSpecialty").val(),
            facultyId: $(".availableFacultiesForCreateSpecialty").find("option:selected").val()
        };
        validateOnEmpty([$(".nameSpecialty")]);
        if(!getValidationError()) {
            $.ajax({
                url: 'create-specialties',
                type: 'POST',
                dataType: 'json',
                contentType: "application/json",
                mimeType: 'application/json',
                data: JSON.stringify(obj),
                success: function () {
                    $("#createspeialty").hide();
                    $(document.getElementsByClassName("modal-backdrop")).remove();
                },
                error: function (xhr) {
                    xhr.status == 500 ? alert('Date are not correct.') : alert('Something went wrong, try again later.')
                }
            })
        }

    });

    $(".jsCreateFaculty").click(function () {
        var obj = {
            name: $(".nameFaculty").val()
        };
        validateOnEmpty([$(".nameFaculty")]);
        if(!getValidationError()) {
            $.ajax({
                url: 'create-faculty',
                type: 'POST',
                dataType: 'json',
                contentType: "application/json",
                mimeType: 'application/json',
                data: JSON.stringify(obj),
                success: function () {
                    $("#createfaculty").hide();
                    $(document.getElementsByClassName("modal-backdrop")).remove();
                },
                error: function (xhr) {
                    xhr.status == 500 ? alert('Date are not correct.') : alert('Something went wrong, try again later.')
                }
            })
        }

    });

    $(".jsCreateRequest").click(function () {
        var obj = {
            companyName: $(".nameCompany").val(),
            startDate: $(".startDate").val(),
            finishDate: $(".finishDate").val(),
            specialtyId: $(".availableSpecialtiesAddRequest").find("option:selected").val(),
            minAverageScore: $(".minScore").val(),
            totalQuantity: $(".totalQuantity").val(),
            user: $(".jsNameHeadOfPractice").val(),
            password: $(".jsPasswordHead").val()

        };
        if (!validateRequestModal([$(".nameCompany"), $(".minScore"), $(".totalQuantity"), $(".jsNameHeadOfPractice"), $(".jsPasswordHead")])) {
            alert("ajz");
            $.ajax({
                url: 'create-request',
                type: 'POST',
                dataType: 'json',
                contentType: "application/json",
                mimeType: 'application/json',
                data: JSON.stringify(obj),
                success: function (request) {
                    $(".jsRequestsTable").bootstrapTable('append', request);
                    $("#addrequest").hide();
                    $(document.getElementsByClassName("modal-backdrop")).remove();
                },
                error:function (xhr) {
                    xhr.status == 500 ? alert("Date are not correct.") : alert('This company already exists');
                }
            })
        }

    });

    $(".jsStudentsTable").on("click", ".jsPreloadStudentPractice", function () {
        var sId = $(this).attr("data-id");
        var studentPracticeWindow = $("#aboutStudentPractice");

        $.ajax({
            url: 'personalStudentPracticeList',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {studentId: sId},
            success: function (personalPracticeList) {
                if (!!personalPracticeList.length) {
                    $(".jsTableStudentPractice").find("tbody").html("");
                    studentPracticeWindow.find(".notAllocated").hide();
                    studentPracticeWindow.find(".jsTableStudentPractice").show();
                    personalPracticeList ? function () {
                        personalPracticeList.some(function (practice) {
                            $(".jsTableStudentPractice").find("tbody").append('<tr><td>' + practice.companyName +
                                '</td><td>' + practice.studentStatus + '</td><td>' + practice.startDate + ' - ' +
                                practice.finishDate + '</td></tr>');

                        });
                    }() : false;
                } else {
                    studentPracticeWindow.find(".notAllocated").show();
                    studentPracticeWindow.find(".jsTableStudentPractice").hide();
                }
            }
        });
    });
});
function formatter(value) {
    return '<a  data-toggle="modal" data-id="'+value+'" data-target="#aboutStudentPractice" class="btn btn-primary jsPreloadStudentPractice">Practice</a>';
}


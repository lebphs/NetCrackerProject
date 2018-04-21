$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjaxFaculty',
        CONTAINER_ADDED_STUDENT: '.jsAddedFaculty'
    };

    var $facultiesContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $addedFacultyContainer = $(ELEMENTS.CONTAINER_ADDED_STUDENT);

    $(".jsStudentsTable").on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
            $(".jsDeleteStudent").prop('disabled', !$(".jsStudentsTable").bootstrapTable('getSelections').length);
            $(".jsAssignStudentBtn" ).prop('disabled', !($(".jsStudentsTable").bootstrapTable('getSelections').length === 1));
            $(".jsRealiseStudentBtn" ).prop('disabled', !($(".jsStudentsTable").bootstrapTable('getSelections').length === 1));
            $(".jsShowInfoStudent" ).prop('disabled', !($(".jsStudentsTable").bootstrapTable('getSelections').length === 1));
    });

    $(".jsPreloadCreateStudentModal").click(function (event) {
        getFacultiesList();
        getSpecialtiesByFacultyIdForAddStudents();
    });

    // $(".jsShowInfoStudent").click(function (event) {
    //     var ids = getIdSelections();
    //
    //     $.ajax({
    //         url: 'studentById',
    //         type: 'GET',
    //         dataType: 'json',
    //         contentType: "application/json",
    //         mimeType: 'application/json',
    //         data: {id: idRequest},
    //         success: function (requests) {
    //             $(".jsStudentMultiselect").change(function () {
    //                 var countSelect = $(".jsStudentMultiselect").find("option:selected").length;
    //
    //                 if(countSelect > requests.totalQuantity){
    //                     $(".jsAssignStudent").prop('disabled', true);
    //                 }
    //                 else{
    //                     $(".jsAssignStudent").prop('disabled', false);
    //                 }
    //             })
    //         }
    //     });
    //
    // });

    $(".jsPreloadCreateRequestModal").click(function (event) {
        getFacultiesList();
        getSpecialtiesByFacultyIdForAddRequest();
    });

    $(".jsAssignStudentBtn").click(function () {
        var idStudent = getIdSelections();
        getRequestFitDescription(idStudent);
    });

    $(".jsRealiseStudentBtn").click(function () {
        var idStudent = getIdSelections();
        getRequestFitDescription(idStudent);
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
        var obj = {idStudents:getIdSelections(),
                idRequest:$(".jsRequestList").find("option:selected").val()
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
        var obj = {idStudents:getIdSelections(),
            idRequest:$(".jsRequestList").find("option:selected").val()
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

    $(".jsRequestList").change(function () {
        var idRequest = $(".jsRequestList").find("option:selected").val();
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

                    if(countSelect > requests.totalQuantity){
                        $(".jsAssignStudent").prop('disabled', true);
                    }
                    else{
                        $(".jsAssignStudent").prop('disabled', false);
                    }
                })
            }
        });
    });

    $(".jsAssignStudent").click(function () {
        var obj ={idRequest : $(".jsRequestList").find("option:selected").val(),
                  idStudents : $(".jsStudentMultiselect").val()};
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


    function getStudentFitDescription(idRequest){
        $.ajax({
            url: 'studentsForMultiselect',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id:idRequest},
            success: function (students) {
                $(".jsStudentMultiselect").empty();
                students ? function () {
                    students.some(function (student) {
                        $(".jsStudentMultiselect").append('<option value=' + student.id + '>' + student.surname +' ' + student.name  +'</option>');
                        $(".jsStudentMultiselect").multiselect('rebuild');
                    });
                }() : false;
            }
        });
    }

    function getRequestFitDescription(idStudent){
        $.ajax({
            url: 'requestsForDropdown',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: idStudent.toString()},
            success: function (requests) {
                $(".jsRequestList").empty();
                requests ? function () {
                    requests.some(function (request) {
                        $(".jsRequestList").append('<option value=' + request.id + '>' + request.companyName +' ' + request.totalQuantity  +'</option>');
                    });
                }() : false;
            }
        });
    }



    $(".jsAssingStudentsRequests").click(function () {
        getRequestList();
        var idRequest = $(".jsRequestList").find("option:selected").val();
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


        $.ajax({
            url: 'create-student',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedStudent) {
                $( ".jsStudentsTable" ).bootstrapTable('append', addedStudent);
            }

        });
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
            }
        });
    }

    function getRequestList() {
        $.ajax({
            async:false,
            url: 'requests',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            success: function (requests) {
                $(".jsRequestList").empty();
                requests ? function () {
                    requests.some(function (request) {
                        $(".jsRequestList").append('<option value='+request.id+'>' + request.companyName + ' ' + request.totalQuantity + '</option>');
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
            data: {id:currentId},
            success: function (specialties) {
                $(".availableSpecialtiesAddStudents").empty();
                specialties ? function () {
                    specialties.some(function (specialty) {
                        $(".availableSpecialtiesAddStudents").append('<option value='+ specialty.id +'>' + specialty.name + '</option>');

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
            data: {id:currentId},
            success: function (specialties) {
                $(".availableSpecialtiesAddRequest").empty();
                specialties ? function () {
                    specialties.some(function (specialty) {
                        $(".availableSpecialtiesAddRequest").append('<option value='+ specialty.id +'>' + specialty.name + '</option>');

                    });
                }() : false;
            }
        });
    }
    $(".jsDeleteStudent").click(function(){
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
    });

    function getIdSelections() {
        return $.map($(".jsStudentsTable").bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }

    $.ajax({
        url: 'studentsForTable',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (students) {
            $(".jsStudentsTable").bootstrapTable('load', students);

        }

    });

    $(".jsCreateSpecialty").click(function () {
        var obj = {
            name: $(".nameSpecialty").val(),
            facultyId :$(".availableFacultiesForCreateSpecialty").find("option:selected").val()
        };
        $.ajax({
            url: 'create-specialties',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function () {
                $(".createSpecialty").modal('toggle');
            }
        })

    });

    $(".jsCreateFaculty").click(function () {
        var obj = {
            name: $(".nameFaculty").val()
        };
        $.ajax({
            url: 'create-faculty',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function () {
                $(".createFaculty").modal('toggle');
            }
        })

    });

    $(".jsCreateRequest").click(function () {
        var obj = {
            companyName: $(".nameCompany").val(),
            startDate: $(".startDate").val(),
            finishDate: $(".finishDate").val(),
            specialtyId: $(".availableSpecialtiesAddRequest").find("option:selected").val(),
            minAverageScore: $(".minScore").val(),
            totalQuantity: $(".totalQuantity").val()
        };

        $.ajax({
            url: 'create-request',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (request) {
                $(".jsRequestsTable").bootstrapTable('append', request);
            }
        })

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
            data: {studentId : sId},
            success: function (personalPracticeList) {
                if (!!personalPracticeList.length) {
                    $(".jsTableStudentPractice").find("tbody").html("");
                    studentPracticeWindow.find(".notAllocated").hide();
                    studentPracticeWindow.find(".jsTableStudentPractice").show();
                    personalPracticeList ? function () {
                        personalPracticeList.some(function (practice) {
                                $(".jsTableStudentPractice").find("tbody").append('<tr><td>' + practice.companyName +
                                    '</td><td>'  + practice.studentStatus + '</td><td>' + practice.startDate + ' - ' +
                                    practice.finishDate + '</td></tr>');

                        });
                    }() : false;
                } else {
                    studentPracticeWindow.find(".notAllocated").show();
                    studentPracticeWindow.find(".jsTableStudentPractice").hide();
                }
            }
        });
    })


});

function formatter(value) {
    return '<a data-toggle="modal"  data-id="'+value+'" data-target="#aboutStudentPractice" class="btn btn-warning jsPreloadStudentPractice">Practice</a>';
}

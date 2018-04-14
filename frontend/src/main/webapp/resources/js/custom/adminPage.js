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
    });

    $(".jsPreloadCreateStudentModal").click(function (event) {
        getFacultiesList();
        getSpecialtiesByFacultyIdForAddStudents();
    });
    $(".jsPreloadCreateRequestModal").click(function (event) {
        getFacultiesList();
        getSpecialtiesByFacultyIdForAddRequest();
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

    $(".jsAddStudent").click(function (event) {
        event.stopPropagation();
        var specialtyId = $(".availableSpecialties").find("option:selected").val();
        //var facultyId = $(".availableFaculties").find("option:selected").val();
        var obj = {
            surname: $(".jsSurname").val(),
            name: $(".jsName").val(),
            specialtyId: specialtyId,
            //facultyId: facultyId,
            group: $(".jsGroup").val(),
            isBudget: $('input[name=isBudget]:checked').val(),
            averageScore: $(".jsAverageScore").val(),
            studentStatus: $(".jsStudentStatus")
        };


        $.ajax({
            url: 'create-student',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (addedStudent) {
                alert(addedStudent);
                //noty({ text: 'Студент '+obj.namestud+' '+obj.surname+' создан!'});
                $( ".jsStudentsTable" ).bootstrapTable('append', addedStudent);
                $("#createstudent").modal('toggle');
            }

        });
    });


    function getFacultiesList() {
        $.ajax({
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
        // alert($(".jsStudentsTable").bootstrapTable('getSelections').);
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
            success: function (addedStudent) {
                $(".jsCreateSpecialty").modal('toggle');
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
            success: function (addedStudent) {
                $(".jsCreateFaculty").modal('toggle');
            }
        })

    });

    $(".jsCreateRequest").click(function () {
        var obj = {
            companyName: $(".nameCompany").val(),
            dataStart: $(".startData").val(),
            dataFinish: $(".finishData").val(),
            // specialty: $(".availableSpecialtiesAddRequest").val(),
            // faculty: $(".availableFacultiesAddRequest").val(),
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
            success: function (addedRequest) {
                $(".jsCreateRequest").modal('toggle');
            }
        })

    })

});

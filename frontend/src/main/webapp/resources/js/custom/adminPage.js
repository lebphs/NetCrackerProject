$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjaxFaculty',
        CONTAINER_ADDED_STUDENT: '.jsAddedFaculty'
    };

    var $facultiesContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $addedFacultyContainer = $(ELEMENTS.CONTAINER_ADDED_STUDENT);

    $(".jsPreloadCreateStudentWindow").click(function (event) {
        getFacultiesList();
        getSpecialtiesByFacultyId();
    });

    $(".availableFaculties").change(function () {
        getSpecialtiesByFacultyId();
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
            scoreAverage: $(".jsAverageScore").val()
        };





        $.ajax({
            url: 'create-students',
            type: 'POST',
            dataType: 'text',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function () {
                //noty({ text: 'Студент '+obj.namestud+' '+obj.surname+' создан!'});
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
                $(".availableSpecialties").empty();
                faculties ? function () {
                    faculties.some(function (faculty) {
                        $(".availableFaculties").append('<option value=' + faculty.id + '>' + faculty.name + '</option>');
                    });
                }() : false;
            }
        });
    }

    function getSpecialtiesByFacultyId() {
        var currentId = $(".jsFacultyId").find("option:selected").val();
        $.ajax({
            url: 'specialtiesList',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id:currentId},
            success: function (specialties) {
                $(".availableSpecialties").empty();
                specialties ? function () {
                    specialties.some(function (specialty) {
                        $(".availableSpecialties").append('<option value='+ specialty.id +'>' + specialty.name + '</option>');

                    });
                }() : false;
            }
        });
    }
    $(".jsDeleteStudent").click(function(){
        var currentId = $(".tableWithAllStudents").find("input[name=checkboxStudent]:checked").val();
        $.ajax({
            url: 'delete-students',
            type: 'GET',
            dataType: 'text',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id:currentId}
        });
    });
});

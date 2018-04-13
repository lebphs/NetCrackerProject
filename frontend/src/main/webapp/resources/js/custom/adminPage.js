$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjaxFaculty',
        CONTAINER_ADDED_STUDENT: '.jsAddedFaculty'
    };

    var $facultiesContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $addedFacultyContainer = $(ELEMENTS.CONTAINER_ADDED_STUDENT);

    $(".jsStudentsTable").on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
        // alert((".jsStudentsTable").bootstrapTable("getSelection").length);

            $(".jsDeleteStudent").prop('disabled', !$(".jsStudentsTable").bootstrapTable('getSelections').length);
       // var lenSelect = $(".jsStudentsTable").bootstrapTable("getSelection").length;
       // if (lenSelect > 0) {
       //     $(".jsDeleteStudent").attr('disabled', true);
       //     $(".jsAssignStudent").attr('disabled', false);
       //     $(".jsRealiseStudent").attr('disabled', false);
       // } else{
       //     $("#delete").attr('disabled', false);
       //     $("#assign").attr('disabled', true);
       //     $("#realise").attr('disabled', true);
       // }
    });

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

});

$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjaxFaculty',
        CONTAINER_ADDED_STUDENT: '.jsAddedFaculty'
    };

    var $facultiesContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $addedFacultyContainer = $(ELEMENTS.CONTAINER_ADDED_STUDENT);

    var obj = {
        id: $(ELEMENTS.INPUT_ID).val(),
        name: $(ELEMENTS.INPUT_NAME).val()
    };
        // $.ajax({
        //     url: 'faculties',
        //     type: 'POST',
        //     dataType: 'json',
        //     contentType: "application/json",
        //     mimeType: 'application/json',
        //     data: JSON.stringify(obj),
        //     error: function () {
        //         alert("Error");
        //     },
        //     success: function (addedFaculty) {
        //         $addedFacultyContainer.text(addedFaculty ? addedFaculty.id + " | " + addedFaculty.name : '');
        //         // $('#table tr:last').after('<tr><td><input type="checkbox"></td><td>' + addedFaculty.surname + '</td><td>'+addedStudent.name+'</td><td>'+ addedStudent.faculty + '</td><td></td><td>'+ addedStudent.group+'</td><td>'+ addedStudent.isBudget+'</td><td>'+ addedStudent.score + '</td><td><a href="../jsp/aboutStudent.jsp" class="btn btn-info">Info</a></td></tr>');
        //     }
        // });

    $.ajax({
        url: 'faculties',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        error:function(){
            alert(Error);
        },
        success: function (faculties) {
            faculties ? function () {
                faculties.some(function (faculty) {
                    $("#availableFaculty").append('<option>'+ faculty.name+ '</option>');
                    $("#availableFacultyForRequest").append('<option>'+ faculty.name+ '</option>');
                });
            }() : false;
        }
    });
});

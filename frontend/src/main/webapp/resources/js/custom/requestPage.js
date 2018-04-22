$(document).ready(function () {
    $.ajax({
        url: 'requests',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (requests) {
            $(".jsRequestsTable").bootstrapTable('load', requests);
        }
    });

    $(".jsDeleteRequest").click(function(){
        var ids = getIdRequestSelections();
        $.ajax({
            url: 'delete-requests',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(ids)
        });
        $(".jsRequestsTable").bootstrapTable('remove', {
            field: 'id',
            values: ids
        });

        $(".jsDeleteRequest").prop('disabled', true);
    });

    function getIdRequestSelections() {
        return $.map($(".jsRequestsTable").bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }

    $(".jsRequestsTable").on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
        $(".jsDeleteRequest").prop('disabled', !$(".jsRequestsTable").bootstrapTable('getSelections').length);
        $(".jsEditRequest" ).prop('disabled', !($(".jsRequestsTable").bootstrapTable('getSelections').length === 1));
        $(".jsAssignStudentPage").prop('disabled', !($(".jsRequestsTable").bootstrapTable('getSelections').length === 1));
    });

    $(".jsRequestsTable").on("click", ".jsStudentsInPractice", function () {
        var sId = $(this).attr("data-id");
        var studentPracticeWindow = $("#studentsInPractice");
        $.ajax({
            url: 'personalPracticeStudentList',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {practiceId : sId},
            success: function (studentsList) {
                if (!!studentsList.length) {
                    $(".jsTableStudentPractice").find("tbody").html("");
                    studentPracticeWindow.find(".notAllocated").hide();
                    studentPracticeWindow.find(".jsTableStudentPractice").show();
                    studentsList ? function () {
                        studentsList.some(function (student) {
                            $(".jsTableStudentPractice").find("tbody").append('<tr><td>' + student.surname +
                                '</td><td>'  + student.studentStatus + '</td><td>' + student.faculty + '</td><td>' +
                                student.averageScore + '</td></tr>');

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
function students(value) {
    return '<a data-toggle="modal"  data-id="'+value+'" data-target="#studentsInPractice" class="btn btn-warning jsStudentsInPractice">Practice</a>';
}
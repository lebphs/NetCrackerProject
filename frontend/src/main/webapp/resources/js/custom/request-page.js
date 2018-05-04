$(document).ready(function () {
    $.ajax({
        url: 'request',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (requests) {
            $(".jsRequestTable").bootstrapTable('load', requests);
        }
    });
    $(".jsRequestTable").on("click", ".jsStudentsInPractice", function () {
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
    });
});
function students(value) {
    return '<a data-toggle="modal"  data-id="'+value+'" data-target="#studentsInPractice" class="btn btn-primary jsStudentsInPractice">Practice</a>';
}
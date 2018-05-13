$(document).ready(function () {
    $.ajax({
        url: 'studentTable',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (student) {
            $(".jsStudentTable").bootstrapTable('load', student);
        }
    });
    $(".jsStudentTable").on("click", ".jsPreloadStudentPractice", function () {
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
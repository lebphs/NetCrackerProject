$(document).ready(function () {

    var indexSelected = 0;
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

    $(".jsRequestsTable").on('check.bs.table', function (e, row, $el) {
        indexSelected = $el.closest('tr').data('index');
    });

    $(".jsRequestsTable").on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
        $(".jsDeleteRequest").prop('disabled', !$(".jsRequestsTable").bootstrapTable('getSelections').length);
        $(".jsEditRequest" ).prop('disabled', !($(".jsRequestsTable").bootstrapTable('getSelections').length === 1));
        $(".jsAssignRequestPage").prop('disabled', !($(".jsRequestsTable").bootstrapTable('getSelections').length === 1));
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
    });
    $(".jsAssignStudentRequestPage").click(function () {
        var obj = {
            requestsList: getIdSelections(),
            studentsList: [$(".jsStudentList").find("option:selected").val()]
        };

        $.ajax({
            url: 'assign-student-requestPage',
            type: 'POST',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: JSON.stringify(obj),
            success: function (request) {
                $(".jsRequestsTable").bootstrapTable('updateRow', {index:indexSelected,row:request});
            }
        });
    });

    function getStudentsFitDescriptionForAssign(idRequest) {
        var assignWindow = $("#assignOneStudent");
        $.ajax({
            url: 'studentsForDropdownAssign',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: idRequest.toString()},
            success: function (students) {
                $(".jsStudentList").empty();
                if (students.length) {
                    assignWindow.find(".notPractice").hide();
                    assignWindow.find(".jsDropdown").show();
                    students ? function () {
                        students.some(function (student) {
                            $(".jsStudentList").append('<option value=' + student.id + '>' + student.surname + ' ' + student.name + '</option>');
                        });
                    }() : false;
                }else {
                    assignWindow.find(".notPractice").show();
                    assignWindow.find(".jsDropdown").hide();
                }
            }
        });
    }


    function getIdSelections() {
        return $.map($(".jsRequestsTable").bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }

    $(".jsAssignRequestPage").click(function () {
            var idRequest = getIdSelections();
            getStudentsFitDescriptionForAssign(idRequest);
    });

    $(".jsEditRequest").click(function () {
        var obj={requestId: getIdSelections().toString()};

        $.ajax({
            url: 'requestForEdit',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: obj,
            success: function (requests) {
                $(".nameCompany").val(requests.companyName);
                $(".startDateEdit").val(requests.startDate);
                $(".finishDateEdit").val(requests.finishDate);
                $(".totalQuantityEdit").val(requests.totalQuantity);
                $(".availableFacultiesAddRequest").append('<option>' +requests.faculty+ '</option>');
                $(".availableSpecialtiesAddRequest").append('<option>' +requests.specialty+ '</option>');
                $(".minScoreEdit").val(requests.minAverageScore);
                //$(".jsRequestsTable").bootstrapTable('load', requests);
            }
        });
    });

    $(".jsEditBtnRequest").click(function () {
        var obj={
            id: getIdSelections().toString(),
            totalQuantity: $(".totalQuantityEdit").val(),
            startDate : $(".startDateEdit").val(),
            finishDate:$(".finishDateEdit").val(),
            minScore:$(".minScoreEdit").val()
        };
        if (!validateRequestEditModal([$(".minScoreEdit"), $(".totalQuantityEdit")])) {
            $.ajax({
                url: 'editRequest',
                type: 'POST',
                dataType: 'json',
                contentType: "application/json",
                mimeType: 'application/json',
                data: JSON.stringify(obj),
                success: function (request) {
                    alert(indexSelected);
                    $(".jsRequestsTable").bootstrapTable('updateRow',{index:indexSelected,row:request});
                    $("#editrequest").hide();
                    $(document.getElementsByClassName("modal-backdrop")).remove();
                },
                error: function (event) {
                    alert("Wrong data!");
                }
            });
        }
    });
});
function students(value) {
    return '<a data-toggle="modal"  data-id="'+value+'" data-target="#studentsInPractice" class="btn btn-primary jsStudentsInPractice">Practice</a>';
}
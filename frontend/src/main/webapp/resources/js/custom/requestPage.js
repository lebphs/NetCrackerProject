$(document).ready(function () {
    $.ajax({
        url: 'requestForTable',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json",
        mimeType: 'application/json',
        data: '',
        success: function (requests) {
            $(".jsRequestsTable").bootstrapTable('load', requests);
        }
    });
});
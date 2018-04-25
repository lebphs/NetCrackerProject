$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjax',
        INPUT_ID: '.jsInputId',
        INPUT_NAME: '.jsUsername',
        INPUT_PASSWORD: '.jsPassword',
        INPUT_USERNAME: '.jsUsername',
        BTN_SUBMIT_LOGIN: '.jsSubmitDataBtn',
        SEND_DATA_BTN: '.jsSendData',
        STUDENTS_TABLE: '.jsStudentsTable',
        CONTAINER_ADDED_USER: '.jsAddedUser'
    };

    var $usersContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $submitButton = $(ELEMENTS.BTN_SUBMIT_LOGIN),
        $usernameField = $(ELEMENTS.INPUT_USERNAME),
        $passwordField = $(ELEMENTS.INPUT_PASSWORD),
        $addedUserContainer = $(ELEMENTS.CONTAINER_ADDED_USER),
        $studentsTable = $(ELEMENTS.STUDENTS_TABLE),
        $sendDataBtn = $(ELEMENTS.SEND_DATA_BTN);

    $submitButton.click(function (event) {
        event.stopPropagation();
        event.preventDefault();

        $.ajax({
            url: 'authorize',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                username: $usernameField.val(),
                password: $passwordField.val()
            }),
            success: function (xhr) {
                console.log(xhr.status);
                window.location.href = "/home"
            },
            error: function (xhr, textStatus) {
                xhr.status == 401 ? alert('Credentials are not correct.'): alert('Something went wrong, try again later.');
            }
        });




    });
    $('.message a').click(function () {
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

});
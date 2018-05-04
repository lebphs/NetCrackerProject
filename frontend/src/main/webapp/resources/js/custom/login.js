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
        // NOTIFICATION_CREDENTIAL_INCORRECT: '.jsCredentialsIncorrectNotification'
    };
    var Validation = {

        validateOnEmpty: function (inputs, btns) {
            var isAnyValidationErrors = false;
            if (inputs) {
                inputs.some(function (input) {
                    if (!input.val().trim()) {
                        isAnyValidationErrors = true;

                        input.next().html('Should not be empty');
                        input.next().show();
                    } else {
                        input.next().hide();
                    }
                });
            }
            if (btns) {
                if (isAnyValidationErrors) {
                    btns.some(function (button) {
                        button.attr("disabled", true)
                    })
                } else {
                    btns.some(function (button) {
                        button.removeAttr('disabled')
                    })
                }
            }
        }
    };
    // window.Validation = Validation;

    var $usersContainer = $(ELEMENTS.CONTAINER_DATA_USING_AJAX),
        $submitButton = $(ELEMENTS.BTN_SUBMIT_LOGIN),
        $usernameField = $(ELEMENTS.INPUT_USERNAME),
        $passwordField = $(ELEMENTS.INPUT_PASSWORD),
        $addedUserContainer = $(ELEMENTS.CONTAINER_ADDED_USER),
        $studentsTable = $(ELEMENTS.STUDENTS_TABLE),
        $sendDataBtn = $(ELEMENTS.SEND_DATA_BTN);
        // $credentialNotification = $(ELEMENTS.NOTIFICATION_CREDENTIAL_INCORRECT);

    // Validation.validateOnEmpty([$usernameField, $passwordField], [$submitButton]);


    $usernameField.on('blur', function () {
        Validation.validateOnEmpty([$usernameField], [$submitButton]);
    });

    $passwordField.on('blur', function () {
        Validation.validateOnEmpty([$passwordField], [$submitButton]);
    });


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
                // $credentialNotification.hide();
                window.location.href = "/home"
            },
            error: function (xhr, textStatus) {
                xhr.status == 401 ? alert('Credentials are not correct.') : alert('Something went wrong, try again later.');
            }
        });
    });

    function checkPassword(password, confirmPassword){
        return !password.localeCompare(confirmPassword);
    }

    $(".jsSignUp").click(function (event) {
        event.stopPropagation();
        event.preventDefault();


        $.ajax({
            url: 'signUp',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify({
                surname: $(".jsSurnameSignUp").val(),
                name: $(".jsNameSignUp").val(),
                facultyId: $(".availableFacultiesSignUp").find("option:selected").val(),
                specialtyId: $(".availableSpecialtiesSignUp").find("option:selected").val(),
                group: $(".jsGroupSignUp").val(),
                isBudget: $('input[name=isBudget]:checked').val(),
                averageScore: $(".jsAverageScoreSignUp").val(),
                password: $(".jsPasswordSignUp").val(),
                confirmPassword: $(".jsPasswordConfirmSignUp").val()

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

    function getStudentIdByName(username){
        $.ajax({
            url: 'studentByName',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {name: username},
            success: function (student) {
               return student.id;
            }
        });
    }
    $('.message a').click(function () {
        getFacultiesList();
        getSpecialtiesByFacultyIdForCreateUser();
        $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
    });

    $(".availableFacultiesSignUp").change(function () {
        getSpecialtiesByFacultyIdForCreateUser();
    });

    function getFacultiesList() {
        $.ajax({
            async: false,
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

    function getSpecialtiesByFacultyIdForCreateUser() {
        var currentId = $(".availableFacultiesSignUp").find("option:selected").val();
        $.ajax({
            url: 'specialtiesList',
            type: 'GET',
            dataType: 'json',
            contentType: "application/json",
            mimeType: 'application/json',
            data: {id: currentId},
            success: function (specialties) {
                $(".availableSpecialtiesSignUp").empty();
                specialties ? function () {
                    specialties.some(function (specialty) {
                        $(".availableSpecialtiesSignUp").append('<option value=' + specialty.id + '>' + specialty.name + '</option>');

                    });
                }() : false;
            }
        });
    }

});
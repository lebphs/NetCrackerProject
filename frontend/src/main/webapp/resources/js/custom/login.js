$(document).ready(function () {

    var ELEMENTS = {
        CONTAINER_DATA_USING_AJAX: '.jsDataUsingAjax',
        INPUT_ID: '.jsInputId',
        INPUT_NAME: '.jsUsername',
        INPUT_PASSWORD: '.jsPassword',
        INPUT_USERNAME: '.jsUsername',
        INPUT_SURNAME_SING_UP: '.jsSurnameSignUp',
        INPUT_NAME_SIGN_UP:'.jsNameSignUp',
        SELECTED_FACULTY: '.availableFacultiesSignUp',
        SELECTED_SPECIALTY:'.availableSpecialtiesSignUp',
        INPUT_GROUP:'.jsGroupSignUp',
        IS_BUDGET:'#isBudgetSignUp',
        INPUT_AVERAGE_SCORE:'.jsAverageScoreSignUp',
        INPUT_PASSWORD_SING_UP:'.jsPasswordSignUp',
        INPUT_CONFIRM_PASSWORD_SIGN_UP:'.jsPasswordConfirmSignUp',
        SIGN_UP_BUTTON:'.jsSignUp',
        BTN_SUBMIT_LOGIN:'.jsSubmitDataBtn'
        // NOTIFICATION_CREDENTIAL_INCORRECT: '.jsCredentialsIncorrectNotification'
    };

    var $submitButton = $(ELEMENTS.BTN_SUBMIT_LOGIN),
        $usernameField = $(ELEMENTS.INPUT_USERNAME),
        $passwordField = $(ELEMENTS.INPUT_PASSWORD),
        $surnameFieldSignUp = $(ELEMENTS.INPUT_SURNAME_SING_UP),
        $nameFieldSignUp = $(ELEMENTS.INPUT_NAME_SIGN_UP),
        $selectedFaculty = $(ELEMENTS.SELECTED_FACULTY),
        $selectedSpecialty = $(ELEMENTS.SELECTED_SPECIALTY),
        $groupField = $(ELEMENTS.INPUT_GROUP),
        $is_budget = $(ELEMENTS.IS_BUDGET),
        $averageScoreField = $(ELEMENTS.INPUT_AVERAGE_SCORE),
        $passwordFieldSignUp = $(ELEMENTS.INPUT_PASSWORD_SING_UP),
        $passwordConfirmFieldSignUp = $(ELEMENTS.INPUT_CONFIRM_PASSWORD_SIGN_UP),
        $signUpButton = $(ELEMENTS.SIGN_UP_BUTTON);




    // $usernameField.on('blur', function () {
    //     validateOnEmpty([$usernameField]);
    // });
    //
    // $passwordField.on('blur', function () {
    //     validateOnEmpty([$passwordField]);
    // });
    // $surnameFieldSignUp.on('blur', function () {
    //     validateOnEmpty([$surnameFieldSignUp]);
    // });
    // $nameFieldSignUp.on('blur', function () {
    //     validateOnEmpty([$nameFieldSignUp]);
    // });
    // $groupField.on('blur', function () {
    //     validateOnEmpty([$groupField]);
    // });
    // $averageScoreField.on('blur', function () {
    //     validateOnEmpty([$averageScoreField]);
    // });
    // $passwordFieldSignUp.on('blur', function () {
    //     validateOnEmpty([$passwordFieldSignUp]);
    // });
    // $passwordConfirmFieldSignUp.on('blur', function () {
    //     validateOnEmpty([$passwordConfirmFieldSignUp]);
    // });

    $submitButton.click(function (event) {
        event.stopPropagation();
        event.preventDefault();

       //validateOnEmpty([$surnameFieldSignUp, $nameFieldSignUp], $submitButton);

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
                xhr.status == 401 ? $(".jsDataIncorrectNotification").show() : alert('Something went wrong, try again later.');
            }
        });
    });

    $(".jsSignUp").click(function (event) {
        event.stopPropagation();
        event.preventDefault();

        validateOnEmpty([$surnameFieldSignUp,$nameFieldSignUp,$groupField,$averageScoreField,
                 $passwordFieldSignUp, $passwordConfirmFieldSignUp]);
        var isMatch = validateConfirmPassword($passwordFieldSignUp,$passwordConfirmFieldSignUp);
        if (!getValidationError() && isMatch) {
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
                    xhr.status == 401 ? alert('Credentials are not correct.') : alert('Something went wrong, try again later.');
                }
            });
        }
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
$(document).ready(function () {
    window.validateOnEmpty = validateOnEmpty;
    window.getValidationError = getValidationError;
    window.validateConfirmPassword = validateConfirmPassword;
    window.validateRequestModal = validateRequestModal;
    window.validateRequestEditModal = validateRequestEditModal;

    var isAnyValidationErrors = false;

    function getValidationError() {
        return isAnyValidationErrors;
    }

    function validateOnEmpty(inputs) {
        isAnyValidationErrors = false;
        if (inputs) {
            inputs.some(function (input) {
                if (!input.val().trim()) {
                    isAnyValidationErrors = true;
                    input.parent().addClass("alert alert-danger");
                    input.parent().children("label.labelHide").html("Should not be empty").css({'display': "flex"});

                } else {
                    input.parent().children("label.labelHide").hide();
                    input.parent().removeClass("alert alert-danger");

                }
            });
        }

    }

    function validateRequestModal(inputs) {
        validateOnEmpty(inputs);
        isAnyValidationErrors = getValidationError() | validateDate($(".startDate"), $(".finishDate"), $(".jsCreateRequest"));


        return isAnyValidationErrors;
    }

    function validateRequestEditModal(inputs, availableQuantity) {
        validateOnEmpty(inputs);
        isAnyValidationErrors = getValidationError() | validateDate($(".startDateEdit"), $(".finishDateEdit"));
        alert("validateEmty" + isAnyValidationErrors);


        return isAnyValidationErrors;
    }


    function validateDate(dateFrom, dateTo) {

        if (!/[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(dateFrom.val())) {
            dateTo.parent().addClass("alert alert-danger");
            dateTo.parent().children("label.labelHide").html("Should not be empty").css({'display': "flex"});
            if (!/[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(dateTo.val())) {
                dateFrom.parent().addClass("alert alert-danger");
                dateFrom.parent().children("label.labelHide").html("Should not be empty").css({'display': "flex"});
            }
            isValidDate = true;
            return isValidDate;
        }

        var dateStart = Date.parse(dateFrom.val()),
            dateFinish = Date.parse(dateTo.val()),
            isValidDate;


        if(dateStart > dateFinish){
            dateTo.parent().addClass("alert alert-danger");
            dateTo.parent().children("label.labelHide").html("Invalid start or end date").css({'display':"flex"});
            dateFrom.parent().addClass("alert alert-danger");
            dateFrom.parent().children("label.labelHide").html("Invalid start or end date").css({'display':"flex"});
            isValidDate = true;
        } else{
            dateTo.parent().removeClass("alert alert-danger");
            dateTo.parent().children("label.labelHide").hide();
            dateFrom.parent().removeClass("alert alert-danger");
            dateFrom.parent().children("label.labelHide").hide();
            isValidDate = false;
        }
        return isValidDate;
    }

    // function validateQuantityInPractice(totalQuantity, availableQuantity) {
    //     var isError;
    //     if(totalQuantity.val()-availableQuantity.val() > 0){
    //         totalQuantity.parent().addClass("alert alert-danger");
    //         totalQuantity.parent().children("label.labelHide").html('Total quantit').css({'display':"flex"});
    //         isError = true;
    //     }else{
    //         totalQuantity.parent().removeClass("alert alert-danger");
    //         totalQuantity.parent().children("label.labelHide").hide();
    //     }
    //     return isError;
    // }
    
    function validateConfirmPassword(password, confirmPassword) {
        var isMatch= !(password.val()).localeCompare(confirmPassword.val());
            if(!isMatch){
                confirmPassword.parent().addClass("alert alert-danger");
                confirmPassword.parent().children("label.labelHide").html("Passwords must match").css({'display':"flex"});
            } else {
                confirmPassword.parent().children("label.labelHide").hide();
            }
            return isMatch;
    }

        $('.numerical').inputmask('Regex', {
            regex: "[0-9]{10}"
        });
        $('.floating').inputmask('Regex',{
            regex:"([0-9][.][0-9]{1,2})|10"
        });
        $('.nameFaculty').inputmask('Regex',{
            regex:"[A-Z]{7}"
        });
        $('.nameSpecialty').inputmask('Regex',{
            regex:"[A-Z]{7}"
        });


});




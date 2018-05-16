<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
<link rel="stylesheet" href="/resources/css/general.css">
<jsp:include page="/jsp/blocks/login-sources.jsp"/>
<script src="/resources/js/custom/login.js" type="text/javascript"></script>
<script src="/resources/js/libs/jquery.inputmask.bundle.js" type="text/javascript"></script>
<script src="/resources/js/custom/validation.js" type="text/javascript"></script>


<body>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <%--<input type="text" placeholder="name" class="jsNameSignUp" required/>--%>
            <div class="form-group">
                <div>
                    <label class="jsSurnameIncorrectNotification labelHide" ></label>
                    <input type="text" class="form-control jsSurnameSignUp" placeholder="Surname" required>
                </div>
            </div>
            <div class="form-group">
                <div>
                    <label class="jsNameIncorrectNotification labelHide" ></label>
                    <input type="text" class="form-control jsNameSignUp" placeholder="Name" required>
                </div>
            </div>
            <div class="form-group">
                <select class="form-control availableFacultiesSignUp jsFacultiesList">
                </select>
            </div>
            <div class="form-group">
                <select class="form-control availableSpecialtiesSignUp">
                </select>
            </div>
            <div class="form-group">
                <div>
                    <label class="jsGroupIncorrectNotification labelHide" ></label>
                    <input type="text" class="form-control numerical jsGroupSignUp" placeholder="Group number" required>
                </div>
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-md-6">
                        <label class="radio-inline">
                            <input type="radio" name="isBudget" id="isBudgetSignUp" value="true" checked> Budget
                        </label>
                    </div>
                    <div class="col-md-6">
                        <label class="radio-inline">
                            <input type="radio" name="isBudget" value="false"> Paid
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div>
                    <label class="jsAverageScoreIncorrectNotification labelHide" ></label>
                    <input type="text" class="form-control floating jsAverageScoreSignUp" placeholder="Average score" required>
                </div>

            </div>

            <div class="form-group">
                <div>
                    <label class="jsPasswordIncorrectNotification labelHide" ></label>
                    <input type="password" placeholder="password" class="form-control jsPasswordSignUp" required/>
                </div>
            </div>
            <div class="form-group">
                <div>
                    <label class="jsConfirmPasswordIncorrectNotification labelHide" ></label>
                    <input type="password" placeholder="password" class="form-control jsPasswordConfirmSignUp" required/>
                </div>
            </div>

            <button class="jsSignUp">create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form">
            <div class="alert alert-danger jsDataIncorrectNotification labelHide" style="display: none">
                Username or Password is incorrect!
            </div>
            <div>
                <label class="jsUsernameIncorrectNotification labelHide" ></label>
                <input type="text" class="jsUsername" required placeholder="username"/>
            </div>

            <div>
                <label class="jsPasswordIncorrectNotification labelHide" style="display: none"></label>
                <input type="password" class="jsPassword" placeholder="password" required/>
            </div>

            <%--<input id="remember_me" name="remember_me" type="checkbox"/>--%>
            <%--<label for="remember_me" class="inline">Remember me</label>--%>

            <button type="submit" class="button button-block jsSubmitDataBtn">login</button>
            <%--<div class="alert alert-danger jsCredentialsIncorrectNotification" role="alert" style="display: none">--%>
                <%--Username or Password is incorrect!--%>
            <%--</div>--%>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>


</div>


</body>
<html>

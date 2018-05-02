<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/general.css">
<jsp:include page="/jsp/blocks/js-sources-links.jsp"/>

<body>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <%--<input type="text" placeholder="name" class="jsNameSignUp" required/>--%>
            <div class="form-group">
                <input type="text" class="form-control jsSurnameSignUp" placeholder="Surname" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control jsNameSignUp" placeholder="Name" required>
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
                <input type="text" class="form-control jsGroupSignUp" placeholder="Group number" required>
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
                <input type="text" class="form-control jsAverageScoreSignUp" id="scoreAverage" placeholder="Average score"
                       required>
            </div>

            <div class="form-group">
                <input type="password" placeholder="password" class="jsPasswordSignUp" required/>
            </div>
            <div class="form-group">
                <input type="password" placeholder="password" class="jsPasswordConfirmSignUp" required/>
            </div>

            <button class="jsSignUp">create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form">
            <input type="text" class="jsUsername" required placeholder="username"/>
            <input type="password" class="jsPassword" placeholder="password" required/>
            <button type="submit" class="button button-block jsSubmitDataBtn">login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>
</div>
<script src="/resources/js/custom/login.js" type="text/javascript"></script>
</body>
<html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" href="/resources/css/general.css">
    <jsp:include page="/jsp/blocks/js-sources-links.jsp"/>

    <body>
        <div class="login-page">
            <div class="form">
                <form class="register-form">
                    <input type="text" placeholder="name" required/>
                    <input type="password" placeholder="password" required/>
                    <input type="text" placeholder="email address"/>
                    <button>create</button>
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

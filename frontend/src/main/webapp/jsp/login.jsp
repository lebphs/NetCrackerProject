<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
        <jsp:include page="/jsp/blocks/js-sources-links.jsp"/>
		<link rel="stylesheet" href="/resources/css/general.css">
</head>
<body class="center">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#"  id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form"  method="post" role="form" style="display: block;">
									<div class="form-group">
										<input type="text" id="usernameLogIn" tabindex="1" class="form-control" placeholder="Username" value="" required>
									</div>
									<div class="form-group">
										<input type="password" name="password" id="passwordLogIn" tabindex="2" class="form-control" placeholder="Password" required>
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
								</form>
								<form id="register-form"  role="form" style="display: none;">
									<div class="form-group">
										<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="" required>
									</div>
									<div class="form-group">
										<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="" required>
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" required>
									</div>
									<div class="form-group">
										<input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" required>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<h3>Printing data using model and view</h3>
		<div class="jsDataUsingModelAndView">
			<c:if test="${not empty students}">
				<c:forEach items="${students}" var="students">
					${students.id}| Srudent name/surnaem:  ${students.name} ${students.surname}| Student group : ${students.group}| student score  <br>
				</c:forEach>
			</c:if>
		</div>
	</div>
	<div>
		<h3>Printing data using js & ajax</h3>
		<div class="jsDataUsingAjax">
		</div>
	</div>

	<br>
	<br>
	Sending Data on server:
	<div class="form-inline">
		<label class="sr-only" for="inlineFormInputId">Id</label>
		<input type="text" class="form-control mb-2 mr-sm-2 jsInputId" id="inlineFormInputId" placeholder="001">
		<label class="sr-only" for="inlineFormInputName">Name</label>
		<input type="text" class="form-control mb-2 mr-sm-2 jsInputName" id="inlineFormInputName" placeholder="Tom">

		<button  class="btn btn-primary mb-2 jsSendData">Send data</button>
	</div>

	<br>
	<div class="jsAddedUser">
	</div>
	<script src="resources/js/custom/custom.js"></script>
</body>
</html>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var x_timer;
		$("#mail").keyup(function(e) {
			clearTimeout(x_timer);
			var user_name = $(this).val();
			x_timer = setTimeout(function() {
				check_username_ajax(user_name);
			}, 1000);
		});

		function check_username_ajax(username) {
			$("#user-result1").html('<img src="images/ajax-loader.gif" />');
			$.post('CheckmailServlet', {
				'username' : username
			}, function(data) {
				$("#user-result1").html(data);
			});
		}
	});
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var x_timer;
		$("#username").keyup(function(e) {
			clearTimeout(x_timer);
			var user_name = $(this).val();
			x_timer = setTimeout(function() {
				check_username_ajax(user_name);
			}, 1000);
		});

		function check_username_ajax(username) {
			$("#user-result").html('_$tag_______________________________');
			$.post('CheckuserServlet', {
				'username' : username
			}, function(data) {
				$("#user-result").html(data);
			});
		}
	});
</script>
</head>
<body>

	<div id="header">
		<div class="inHeaderLogin"></div>
	</div>

	<div id="loginForm">
		<div class="headLoginForm">Enter information to register</div>
		<div class="fieldLogin">
			<form method="POST" action="servletregistration">
				<div>
					<label>Username</label><br> <input id="username" type="text"
						class="form-control" name="username"><span
						id="user-result"></span>
				</div>
				<div>
					<label>Mail</label><br> <input id="mail" type="text"
						class="form-control" name="mail"><span id="user-result1"></span>
				</div>
				<label>Password</label><br> <input type="password"
					class="form-control" name="pass"><br> <span></span>

				<button type="submit" class="button">confirm</button>
				<c:if test="${a==1}">
					<label style="color: red">The username or email is already
						registered, please register again</label>
				</c:if>

			</form>
		</div>
	</div>

</body>
</html>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<div id="header">
		<div class="inHeaderLogin"></div>
	</div>

	<div id="loginForm">
		<div class="headLoginForm">Enter the login information</div>
		<div class="fieldLogin">
			<form method="POST" action="sevletlogin">
				<label>Username</label><br> <input type="text"
					class="form-control" name="username"><br> <label>Password</label><br>
				<input type="password" class="form-control" name="pass"><br>
				<button type="submit" class="button" value="Login">Login</button>
				&nbsp;<a href="servletregistration">registration</a>
				<c:if test="${b==1}">
					<label style="color: red">account or password is not
						correct please enter</label>
				</c:if>
			</form>
		</div>
	</div>

</body>
</html>

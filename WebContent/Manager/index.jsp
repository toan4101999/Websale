<%-- 
    Document   : index
    Created on : 19-May-2016, 7:18:57 PM
    Author     : TUNGDUONG
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>
	<form action="${root}/Websale/ManagerServletindex" method="GET">

		<jsp:include page="header.jsp"></jsp:include>

		<div id="wrapper">

			<jsp:include page="menu.jsp"></jsp:include>

			<jsp:include page="content.jsp"></jsp:include>

			<jsp:include page="footer.jsp"></jsp:include>

		</div>
	</form>
</body>

</html>

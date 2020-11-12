

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<div id="rightContent">
				<h3>User</h3>
				<table class="data">
					<tr class="data">

						<th class="data" width="30px">ID</th>
						<th class="data">Username</th>
						<th class="data">Password</th>
						<th class="data">Mail</th>
						<th class="data" width="80px">Option</th>
					</tr>

					<c:forEach items="${listcus}" var="listcus">

						<tr class="data">

							<td class="data">${listcus.getId()}</td>
							<td class="data">${listcus.getUserName()}</td>
							<td class="data">${listcus.getPass()}</td>
							<td class="data">${listcus.getMail()}</td>
							<td class="data" width="100px">
								<center>
									<c:if test="${listcus.check()!=true}">
										<a
											href="ManagerUser?command=add&id=${listcus.getId()}&name=${listcus.getUserName()}&pass=${listcus.getPass()}&mail=${listcus.getMail()}">ADMIN</a>&nbsp;&nbsp;|&nbsp;&nbsp;</c:if>
									<c:if test="${listcus.check()!=true}">
										<a href="ManagerUser?command=delete&id=${listcus.getId()}">Delete</a>
									</c:if>
								</center>
							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
			<div class="clear"></div>

			<jsp:include page="footer.jsp"></jsp:include>

		</div>
</body>
</html>

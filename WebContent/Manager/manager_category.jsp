

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager category</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<div id="rightContent">
				<h3>catalog management</h3>

				<a href="${root}/Manager/insert_category.jsp">Add Category</a>
				<table class="data">
					<tr class="data">

						<th class="data" width="30px">ID</th>
						<th class="data">Name</th>
						<th class="data" width="80px">Option</th>
					</tr>

					<c:forEach items="${List}" var="List">

						<tr class="data">

							<td class="data">${List.getIdcategory()}</td>
							<td class="data">${List.getNamecategory()}</td>

							<td class="data" width="80px">
								<center>
									<a
										href="${root}/Manager/update_category.jsp?command=update&category_id=${List.getIdcategory()}">Edit</a>&nbsp;&nbsp;|&nbsp;&nbsp;
									<a
										href="ManagerServletcategory?command=delete&category_id=${List.getIdcategory()}">Delete</a>
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

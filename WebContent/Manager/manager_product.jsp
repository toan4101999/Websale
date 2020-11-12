

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Product</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>Product Management</h3>

			<a href="InsertProduct">Add Products</a>
			<table class="data">
				<tr class="data">

					<th class="data">IMAGES</th>
					<th class="data">Name</th>
					<th class="data">Price</th>
					<th class="data">Category</th>
					<th class="data" width="75px">Option</th>
				</tr>

				<c:forEach items="${list}" var="list">

					<tr class="data">

						<td class="data"><img src="${list.getUrl()}"
							style="width: 250px; height: 200px;" /></td>
						<td class="data">${list.getName()}</td>
						<td class="data">${list.getPrice()}</td>
						<td class="data">${list.getCategory()}</td>
						<td class="data" width="80px">
							<center>
								<a
									href="UpdateProduct?command=update&product_id=${list.getShoesid()}">Edit</a>&nbsp;&nbsp;|&nbsp;&nbsp;
								<a
									href="ManagerServletProduct?command=delete&product_id=${list.getShoesid()}">Delete</a>
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

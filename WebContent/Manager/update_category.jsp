<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update category</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>Update Category</h3>
			<form action="/Websale/UpdateCategory" method="post">
				<table width="95%">
					<tr>
						<td style="float: right"><b>Name Category:</b></td>
						<td><input type="text" class="sedang" name="namecategory"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="hidden" name="command" value="update">
							<input type="hidden" name="category_id"
							value="<%=request.getParameter("category_id")%>"> <input
							type="submit" class="button" value="Savedata"></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="clear"></div>

		<jsp:include page="footer.jsp"></jsp:include>

	</div>


</body>
</html>

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
<title>Update product</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>


	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>Update Product</h3>
			<form method="post" action="/Websale/UploadFileServlet"
				enctype="multipart/form-data">
				Select URL to upload: <input type="file" name="iamagesfile"
					size="60" /><br />
				<br /> Select URLLogo to upload: <input type="file" name="logofile"
					size="60" /><br />
				<br /> <input type="submit" value="Upload" />
			</form>
			<form action="UpdateProduct" method="post"
				enctype="multipart/form-data">
				<table width="95%">

					NEW URL :
					<input type="file" required="" name="Iamagesfile" size="60" />
					<br />
					<br /> New URLLogo :
					<input type="file" required="" name="Logofile" size="60" />
					<br />
					<br />
					<tr>
						<td style="float: right"><b>NAME</b></td>
						<td><input type="text" class="sedang" name="name"></td>
					</tr>
					<tr>
						<td style="float: right"><b>PRICE</b></td>
						<td><input type="text" class="sedang" name="price"></td>
					</tr>
					<tr>
						<td style="float: right"><b>Unitprice</b></td>
						<td><input type="text" class="sedang" name="Unitprice"></td>
					</tr>
					<tr>
						<td style="float: right"><b>CATEGORYID</b></td>
						<td><select name="category">
								<c:forEach items="${Listcategory}" var="Listcategory">
									<option value="${Listcategory.getIdcategory()}">${Listcategory.getIdcategory()}</option>
								</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="hidden" name="command" value="update">
							<input type="hidden" name="product_id"
							value="<%=request.getParameter("product_id")%>"> <input
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
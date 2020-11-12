<%-- 
    Document   : manager_product
    Created on : 19-May-2016, 7:33:54 PM
    Author     : TUNGDUONG
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.web.com.BillDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="Model.Bill"%>
<%@page import="Model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="Dao.web.com.CustomerDAO"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Billdetails</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>Details</h3>
			<a href="ManagerServletbill">Back</a>
			<table class="data">
				<tr class="data">
					<th class="data" width="30px">ID</th>
					<th class="data">Url</th>
					<th class="data">Price</th>
					<th class="data">Qty</th>
					<th class="data">Size</th>

				</tr>
				<c:forEach items="${listbill}" var="listbill">
					<tr class="data">
						<td class="data" width="30px">${listbill.getIddbill()}</td>
						<td class="data"><img src="${listbill.getUrl()}"
							style="width: 200px; height: 150px;" /></td>
						<td class="data">${listbill.getPrice()}</td>
						<td class="data">${listbill.getQty()}</td>
						<td class="data">${listbill.getSize()}</td>

					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="clear"></div>

		<jsp:include page="footer.jsp"></jsp:include>

	</div>


</body>
</html>

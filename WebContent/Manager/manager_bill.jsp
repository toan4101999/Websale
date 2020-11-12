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
<title>Manager Bill</title>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>Invoice Management</h3>

			<table class="data">
				<tr class="data">
					<th class="data" width="20px">ID</th>
					<th class="data">User</th>
					<th class="data">Total</th>
					<th class="data">Payment</th>
					<th class="data">Address</th>
					<th class="data">Status</th>
					<th class="data">DateBuy</th>
					<th class="data" width="160px">Option</th>
				</tr>
				<c:forEach items="${listbill}" var="listbill">
					<tr class="data">
						<td class="data" width="20px">${listbill.getIdbill()}</td>
						<td class="data">${listbill.getUser().getMail()}</td>
						<td class="data">${listbill.getTotal()}</td>
						<td class="data">${listbill.getPayment()}</td>
						<td class="data">${listbill.getAddress()}</td>
						<td class="data">${listbill.getStatus()}</td>
						<td class="data">${listbill.getDate()}</td>
						<td class="data" width="160px">
							<center>

								<c:if test="${listbill.getStatus()=='unconfimred'}">
									<a
										href="ManagerServletbill?command=Confirm&bill=${listbill.getIdbill()}&username=${listbill.getUser().getUserName()}&mail=${listbill.getUser().getMail()}">Confirm</a>&nbsp;&nbsp|&nbsp;&nbsp </c:if>
								<c:if test="${listbill.getStatus()=='unconfimred'}">
									<a
										href="ManagerServletbill?command=Cancel&bill=${listbill.getIdbill()}">Cancel</a>&nbsp;&nbsp|&nbsp;&nbsp</c:if>
								<a href="ManagerServletDetailsbill?bill=${listbill.getIdbill()}">Details</a>
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

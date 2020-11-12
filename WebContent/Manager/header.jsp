<%-- 
    Document   : header
    Created on : 19-May-2016, 7:18:44 PM
    Author     : TUNGDUONG
--%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>header</title>
</head>
<body>

	<div id="header">
		<div class="inHeader">
			<div class="mosAdmin">
				<%
                HttpSession sess=request.getSession();
        		Object o=sess.getAttribute("user");
        		
                %>
				Hello,<%=o.toString()%>
				Administrator<br> <a href="/Websale/sevletindex">See
					website</a> | <a href="/Websale/servletlogout">Exit</a>
			</div>
			<div class="clear"></div>
		</div>
	</div>

</body>
</html>

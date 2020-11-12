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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Category</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#idcategory").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1000);
                });

                function check_username_ajax(username) {
                    $("#user-result").html('<img src="../images/ajax-loader.gif" />');
                    $.post('/Websale/CheckCategoryID', {'username': username}, function (data) {
                        $("#user-result").html(data);
                    });
                }
            });
        </script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>catalog information</h3>


			<form action="/Websale/ManagerServletcategory" method="post">
				<table width="95%">
					<tr>
						<td style="float: right"><b>Name Category</b></td>
						<td><input type="text" class="sedang" name="Namecategory"></td>
					</tr>
					<tr>
						<td style="float: right"><b>ID Category</b></td>
						<td><input id="idcategory" type="text" class="sedang"
							name="idcategory"><span id="user-result"></span></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="button" value="Save Data">
						</td>
					</tr>
				</table>
		</div>
		<div class="clear"></div>
		</form>
		<jsp:include page="footer.jsp"></jsp:include>

	</div>


</body>
</html>

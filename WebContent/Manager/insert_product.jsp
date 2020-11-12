<%-- 
    Document   : insert_category
    Created on : 19-May-2016, 7:39:12 PM
    Author     : TUNGDUONG
--%>

<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Product</title>

<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#Idshoes").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1000);
                });

                function check_username_ajax(username) {
                    $("#user-result").html('<img src="images/ajax-loader.gif" />');
                    $.post('/Websale/CheckShoesid', {'username': username}, function (data) {
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

			<form method="post" action="/Websale/UploadFileServlet"
				enctype="multipart/form-data">
				Select URL to upload: <input type="file" name="iamagesfile"
					size="60" /><br />
				<br /> Select URLLogo to upload: <input type="file" name="logofile"
					size="60" /><br />
				<br /> <input type="submit" value="Upload" />
				<h3>Product information</h3>
			</form>

			<form action="InsertProduct" method="post"
				enctype="multipart/form-data">
				<table width="95%">


					URL :
					<input type="file" required="" name="iamagesfile" size="60" />
					<br />
					<br /> URLLogo :
					<input type="file" required="" name="logofile" size="60" />
					<br />
					<br />
					<tr>
						<td style="float: right"><b>NAME</b></td>
						<td><input type="text" class="sedang" name="Name"></td>
					</tr>
					<tr>
						<td style="float: right"><b>PRICE</b></td>
						<td><input type="text" class="sedang" name="Price"></td>
					</tr>
					<tr>
						<td style="float: right"><b>CATEGORYID</b></td>
						<td><select name="Category">
								<c:forEach items="${listcategory}" var="listcategory">
									<option value="${listcategory.getIdcategory()}">${listcategory.getNamecategory()}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td style="float: right"><b>ShoesID</b></td>
						<td><input id="Idshoes" type="text" class="sedang"
							name="Idshoes"><span id="user-result"></span></td>
					</tr>
					<tr>
						<td style="float: right"><b>Unitprice</b></td>
						<td><input type="text" class="sedang" name="unitprice"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="button" value="Save Data" />
						</td>
					</tr>
				</table>

				<div class="clear"></div>
			</form>
			<jsp:include page="footer.jsp"></jsp:include>

		</div>
</body>
</html>

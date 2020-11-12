<!DOCTYPE html>
<html>
<head>
<title>JSP-Servlet Upload file</title>
</head>
<body>
	<h2>Upload File</h2>
	<form method="post" action="/Websale/UploadFileServlet"
		enctype="multipart/form-data">
		Select url to upload: <input type="file" name="file" size="60" /><br />
		<br /> Select urllogo to upload: <input type="file" name="file"
			size="60" /><br />
		<br /> <input type="submit" value="Upload" />
	</form>
</body>
</html>
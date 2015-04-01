<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Page</title>
</head>
<body>
<body bgcolor="black"></body>
	<form name="form1" id="form1" action="Main1" method="post" enctype="multipart/form-data">
	<input type="hidden" name="hiddenfield1" value="ok">
	Upload text file:
	<br/>
	<input type="file"  name="file1">
	<br/>
	<input type="submit" value="Upload">
	</form>
	<br/>
<%if(request.getAttribute("output") !=null){ %>
<br>
<br>
<p>Text Runner Output<br> <%=request.getAttribute("output")  %></p>
<%} %>
	
	
	
</body>
</html>
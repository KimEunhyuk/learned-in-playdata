<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.DBUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbutilTEst.jsp</title>
</head>
<body>

	<%
		out.println(DBUtil.getConnection());		
	%>

</body>
</html>
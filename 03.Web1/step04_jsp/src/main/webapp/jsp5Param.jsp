<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp5Param.jsp</title>
</head>
<body>
	<%-- web query string 으로 서버에 전송되는 데이터값 출력 
	<input type="text" name="id" value="tester"><br>
	<input type="text" name="pw" value="tester"><br>
	
	out.println(request.getParameter("id")); 와 동일
	--%>
	${param.id}-${param.pw}

</body>
</html>
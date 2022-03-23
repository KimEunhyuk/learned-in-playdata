<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>

<body>
<%	
		System.out.println(session.getId());
		session.invalidate();
		session = null;
%>	
		
jsp 파일 - 로그아웃 성공
	
</body>

</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>6조</title>
</head>
<body>
	<right>
	<form action="index.html" >
	&nbsp;&nbsp;&nbsp;<input type="submit" value="로그아웃">
	</form>
	</right>
<br><br><br>



<center>
<h3>${applicant.id} 님 환영합니다</h3>

<hr><p>

</center>

<p>

	&nbsp;&nbsp;&nbsp;<a href="controller?command=certificate">1. 지원자 등록 </a><p>
	
	&nbsp;&nbsp;&nbsp;<a href="controller?command=gkqrurAll">2. 합격자 조회 </a><p>	

<!-- 	
	<form action="controller?command=applicant" method="post" >
	&nbsp;&nbsp;&nbsp;<input type="submit" value="마이 페이지">
	</form>
 -->
 
 	&nbsp;&nbsp;&nbsp;<a href="controller?command=applicant" method="post">3. 마이 페이지 </a><p>	

<p>
	<hr>
	
	
</body>
</html>
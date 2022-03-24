<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>6조</title>
</head>
<body>
<div align="right">
	<form action="index.html" >
	&nbsp;&nbsp;&nbsp;<input type="submit" value="로그아웃">
	</form>

<br><br><br>



<center>
<h1>${applicant.id} 님 환영합니다</h1>

<hr><p>

</center>

<p>
<div align="left">
	&nbsp;&nbsp;&nbsp;<a href="controller?command=certificate">1. 지원자 등록 </a><p>
	
	&nbsp;&nbsp;&nbsp;<a href="probono?command=activistAll">2. 합격자 조회 </a><p>	

<!-- 	
	<form action="controller?command=applicant" method="post" >
	&nbsp;&nbsp;&nbsp;<input type="submit" value="마이 페이지">
	</form>
 -->
 
 	&nbsp;&nbsp;&nbsp;<a href="controller?command=applicant" method="post">3. 마이 페이지 </a><p>	
	
<!-- 
	<form action="probono?command=activist" method="post" >
	&nbsp;&nbsp;&nbsp;	
	4. 기부자 ID : <input type="text" name="activistId"><input type="submit" value="검색">
	</form>
 -->
	
	

	
	
<p>
	<hr>
	
	
</body>
</html>
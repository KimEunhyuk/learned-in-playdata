<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% System.out.println("jsp1Scripting.jsp 실행 ---------------"); %>



<%--
1. jsp만의 주석 tag		이주석은 안보임
	= 보안을 고려한 주석은 jsp 주석 tag 활용 필수
	- server내에서만 인식하고 브라우저로 미전송하는 주석

2. 1line의 tag - page 지시자
	: contentType="text/html; charset=UTF-8"
		servlet의 response.setContentType("text/html; charset=UTF-8"); 동일 

--%>

<!-- 
	html tag	이주석은 보임
-->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1Scripting.jsp</title>
</head>
<body>

	<h3>jsp scripting tag(5가지)</h3>
	1. page지시자 <br>
	2. 주석<br>
	3. scriptlet : 순수 자바 코드 개발 가능한 tag<br>
	4. 출력 tag <br>
	5. 선언자 : 멤버변수 또는 메소드 추가 구현 tag<br><br><br>
	
	<%-- scriptlet --%>
	<%
		//구현 코드는 doGet()/doPost()/service() 메소드 구현부로 변환
		String msg = "문자열";
	
		//jsp의 출력 내장객체를 참조하는 변수로 출력
		out.println(msg);
	%>
	---
	<%= msg %>
	일반 데이터
	<hr color="blue">
	
	
	<%-- 
	jsp action tag로 화면 이동 
	시작과 끝 tag 내부에 내용이 없을 경우에 / 표현을 tag 뒷단에 처리
	빈 tag라 함
	--%>
<%-- 	<jsp:forward page="jsp2Scripting.jsp" /> --%>

	<jsp:include page="jsp2Scripting.jsp" />
</body>
</html>
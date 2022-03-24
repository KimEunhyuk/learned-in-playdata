<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% String url = application.getContextPath() + "/"; %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>합격자</title>
</head>
<body>
<br><br><br>
<center>
<h3>현재 합격자입니다.</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>지원자 id</th><th>지원자 이름</th><th>총점수</th><th>합격여부</th>
		</tr>
	</thead>
	

	<c:forEach var="gkqAll" items="${requestScope.gkqrurAll}" varStatus="status">
 		<tr>
 			<td>${gkqAll.applicant_id}</td>
 			<td>${gkqAll.name}</td>
 			<td>${gkqAll.sum}</td>	
 			<td>합격</td>	
 			
 		</tr>
 	</c:forEach>

 		 		
<%--
<td>${certificateAll[status.index].sum}</td>

 	<c:forEach items="${requestScope.certificateAll}" var="cerAll">
 		<tr>
 			<td>${cerAll.sqld + cerAll.adsp + cerAll.dasp + cerAll.bda + cerAll.ipe}</td>
 			<td>${cerAll.adsp}</td>
 			
 		</tr>
 	</c:forEach>
 --%>
 


</table>
<br><br><br>
&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/loginIndex.jsp">메인 화면 이동</a>

<br><br><br>

</center>
</body>
</html>
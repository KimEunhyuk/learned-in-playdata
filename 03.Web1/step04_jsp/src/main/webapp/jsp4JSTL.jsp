<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap, model.domain.Person" %>

<%--
1. jstl library 셋팅
2. jsp 파일에 외부 library 사용하겠는 설정을 반드시 해야 함
	- tag lib
		- prefix : 구분하는 간단한 별칭
		- uri : tag를 구분하기 위한 고유한 자원
3. jstl 기본 tag 사용하겠다는 설정
	- 전 세계에서 인터넷 상의 자원의 명확한 구분자는 url
	- 사이트의 고유의 url로도 사용, tag명들이 동일한 것을 구분하기 위한 구분자로도 사용
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp4JSTL.jsp</title>
</head>
<body>
	<h3>1. if : 조건 하나짜리 tag, else tag는 미 존재</h3>
	<c:if test="${'a' == 'a'}">
	1. 'a' == 'a' <br>
	</c:if>

	<c:if test="${'a' != 'a'}">
	2. 'a' != 'a' <br>
	</c:if>

	<% // sample data 구성하는 tag 
	request.setAttribute("d1", "data1");
	%>
	<c:if test="${requestScope.d1 == 'data1'}">
	3. data1인 경우에만 출력 <br>
	</c:if>

	<c:if test="${requestScope.d1 != 'data1'}">
	4. data1이 아닌 경우에만 출력 <br>
	</c:if>
	
	<hr color="red">
	
	<h3>2. choose와 when : 다중 조건 tag</h3>
	<c:choose>
		<c:when test="${1 == 2}">
			1 == 2 <br>
		</c:when>
		<c:when test="${requestScope.d1 == 'data1'}">
			1 == 1 <br>
		</c:when>
		<c:otherwise>
			두개의 조건과 다름<br>
		</c:otherwise>
	</c:choose>


	<hr color="blue">
<%
		request.setAttribute("rd1", "rd1");
		session.setAttribute("sd1", new Person("tester", 11));
		
		Person [] all = {new Person("t1", 11), new Person("t2", 22), new Person("t3", 33)};
		session.setAttribute("sd2", all);
		
		HashMap<String, String> map = new HashMap<>();
		map.put("k1", "유재석");
		map.put("k2", "황선수");
		map.put("k3", "김연아");
		
		session.setAttribute("map", map);	
		HashMap<String, Person> map2 = new HashMap<>();
		map2.put("k1", new Person("p1", 100));
		map2.put("k2", new Person("p2", 200));
		map2.put("k3", new Person("p3", 300));
		request.setAttribute("map2", map2);
%>

		<h3>3. forEach 반복 tag</h3>
		- 장점 - java 코드 최소화<br>
		3-1. 배열 데이터 출력<br>
		<!-- 배열에 저장된 데이터를 하나씩 뽑아서 p라는 변수에 대입하겠다는 설정 -->
		<c:forEach items="${sessionScope.sd2}" var="p">
			${p.age}<br>
		</c:forEach>
		
		3-2. request에 저장된 HashMap의 Person 객체 값 출력 <br>
		<c:forEach items="${requestScope.map2}" var="q">
			${q.value} - ${q.key}<br>
		</c:forEach>
		3-3. 300만 출력<br>
		<c:forEach items="${requestScope.map2}" var="p">
			<c:if test="${p.key == 'k3'}">
				${p.value.age}
			</c:if>
		</c:forEach>
	
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- java.lang과 servlet api를 제외한 모든 package들은 import필수 --%>
<%@ page import="model.domain.Person, java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp3EL.jsp</title>
</head>
<body>
	<h3>EL : 브라우저 화면에 데이터 출력 tag</h3>
	- jsp 파일에서만 사용 가능(html 파일에선 사용 불가)<br><br>

	<table border="1">
		<tr>
			<th>non-EL</th>
			<td>EL</td>
		</tr>
		<tr>
			<td>2+3</td>
			<td>${2+3}</td>
		</tr>		
		<tr>
			<td>'a' == 'a'</td>
			<td>${'a' == 'a'}</td>
		</tr>
		<tr>
			<td>'a' != 'a'</td>
			<td>${'a' != 'a'}</td>
		</tr>
		<tr>
			<td>2 > 3</td>
			<td>${2 > 3}</td>
		</tr>

	</table>
	
	
	<hr size="5" color="red">
	
	servlet에서 request or session에 데이터를 setAttribute() 저장후에
	forward 또는 redirect 또는 단순 link로 이동되었다 가정, 
	java 객체 데이터를 EL tag로 화면에 출력<br>
	
	<% 
		//test 데이터 구성
		/* 단순 문자열 저장 및 활용 -> DTO -> 배열 -> list -> map */
		
		request.setAttribute("rd1", "rd1");
		session.setAttribute("sd1", new Person("tester", 11));
		
		Person [] all = {new Person("t1", 11), new Person("t2", 11)};
		session.setAttribute("sd2", all);
		
		//? HashMap - 문자열 -> DTO
		HashMap<String, String> map = new HashMap<>();
		map.put("k1", "유재석");
		map.put("k2", "황선수");
		map.put("k3", "김연아");
		
		session.setAttribute("map", map);	
		
		
		//DTO를 HashMap 저장
		HashMap<String, Person> map2 = new HashMap<>();
		map2.put("k1", new Person("p1", 11));
		map2.put("k2", new Person("p2", 11));
		map2.put("k3", new Person("p3", 100));
		request.setAttribute("map2", map2);
		
				
				
				
	%>
	
	<%-- out.println(request.getAttribute("rd1")); --%>
	1. ${requestScope.rd1}<br>
	2. ${sessionScope.sd1.id}-${sessionScope.sd1.age}<br>
	3. ${sessionScope.sd2[0].id}-${sessionScope.sd2[1].id} <br>
	4. ${sessionScope.map.k1 } <br>
	5. ${requestScope.map2.k3.age }<br>
	

</body>
</html>
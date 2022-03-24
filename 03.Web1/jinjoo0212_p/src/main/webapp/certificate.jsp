<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>certificate</title>
</head>
<body>
<br><br><br>
<center>
<h2>자격증 등록 및 지원</h2>
<hr><p>





<p> ${applicant.id}님의 보유하신 자격을 선택하세요</p>


<form action="controller" method="post">
	<input type="hidden" name="command" value="certificateInsert">
	<table border="1">
		<tr>
			<td>SQLD</td>
			<td>
			
			<input type="radio" name="sqld" value="10" ><label>유</label>&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sqld" value="0" checked><label>무</label>
			</td>
		</tr>
		<tr>
			<td>ADsP</td>
			<td>
			<input type="radio" name="adsp" value="15"><label>유</label>&nbsp;&nbsp;&nbsp;
			<input type="radio" name="adsp" value="0" checked><label>무</label> 
			</td>
		</tr>
		<tr>
			<td>DAsP</td>
			<td>
			<input type="radio" name="dasp" value="20"><label>유</label>&nbsp;&nbsp;&nbsp;
			<input type="radio" name="dasp" value="0" checked><label>무</label>
			</td>
		</tr>
		<tr>
			<td>빅데이터분석기사</td>
			<td>
			<input type="radio" name="bda" value="25"><label>유</label>&nbsp;&nbsp;&nbsp;
			 <input type="radio" name="bda" value="0" checked><label>무</label> 
			</td>
		</tr>
		<tr>
			<td>정보처리기사</td>
			<td>
			<input type="radio" name="ipe" value="30"><label>유</label>&nbsp;&nbsp;&nbsp;
			<input type="radio" name="ipe" value="0" checked><label>무</label>
			</td>
		</tr>

	 
	</table>
			<br>
	 		<input type="submit" value="제출">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소">


</form>
<br><br><br>
<a href="loginIndex.jsp">메인 화면으로 이동하기</a>


</body>
</html>
package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://ip:port/project/succ - 직접 요청 get
//http://localhost/step03_sessionTracking/succ
// moehod="post" 코드를 통해서 실행 - post방식

//URL mapping
@WebServlet("/succ")
public class Welcome extends HttpServlet {
	
	//get방식과 post방식 모두다 처리하는 특화된 메소드
	//doPost와 doGet와 동일
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		//client로 쿠키 객체 획득
		//해당 사이트에서 생성된 쿠키 정보만 선별해서 획득
		Cookie[] all = request.getCookies();
		
		//하나 이상의 쿠키 객체에서 key로 선별해서 value 활용
		//key는 getName() / value는 getValue()
		
//		for(Cookie c : all) {
//			System.out.println(c.getName());
//			
//					if(c.getName().equals("name")) {
//						out.print("안녕하세요 " + c.getValue() + "님");
//					}
//		}
		//server 관점에선 순수 문자열이 println() parameter
		//브라우저가 문자열 받아서 아~ tag구나 로 브라우저에서 실행해서 tag 구선
		//자바의 " 자체가 문자열 데이터인 경우 String 표현과 일치되기 때문에
		//특수 기호로 데이터라는 입증을 코드로 처리 \" -> " 문자열로 인식
		out.println("<button onclick='location.href=\"logout\"'>로그아웃</button>");
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://ip:port/context명/encore/playdata
@WebServlet("/encore/playdata")
public class LoginValidate extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		
		if(id != null && id.equals("tester")) {
			//상태유지 데이터로 생성만
			Cookie c1 = new Cookie("name", "lee");//map구조
			Cookie c2 = new Cookie("age", "30");//map구조
			
			//client 시스템에 잔존 시간 설정 - 초단위로 설정
			//client가 쿠키 삭제시 어쩔 수 없이 삭제
			c1.setMaxAge(60*60*24*365);
			c2.setMaxAge(60*60*24*365);
			
			//client에 시스템이 http 통신으로 전송해서 저장
			response.addCookie(c1);
			response.addCookie(c2);
			
			System.out.println("-----");
			
//			response.sendRedirect("succ");	//http://localhost/step03_sessionTracking/encore/succ
			response.sendRedirect("../succ");	//http://localhost/step03_sessionTracking/succ
//			response.sendRedirect("/succ");	//http://localhost/succ
//			response.sendRedirect("./succ");	//http://localhost/step03_sessionTracking/encore/succ
			
			
		}else {
			
		}
	}

}

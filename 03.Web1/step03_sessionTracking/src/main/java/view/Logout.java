package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client 시스템에 있는 쿠키 정보 삭제
		//age 쿠키 정보 삭제인 경우 age라는 이름의 key로 value값을 null로 해서 재전송
//		Cookie delete = new Cookie("age", "");
//		delete.setMaxAge(60*60*24*365);
		
		
		Cookie [] all = request.getCookies();
		for(int i=0; i < all.length; i++) {
			
			System.out.println("---------");
			
			if(all[i].getName().equals("age")) {
				
				System.out.println("---111---");
				all[i].setValue("10");
				response.addCookie(all[i]);
			}
		}
		
		
//		response.addCookie(delete); //필수코드
		//반드시 해당 key의 쿠키를 client 시스템에 재전송 필수
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("로그아웃 성공");
	}

}

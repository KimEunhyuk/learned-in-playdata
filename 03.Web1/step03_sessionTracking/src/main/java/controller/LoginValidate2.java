package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//http://ip:port/context명/encore/playdata2
@WebServlet("/encore/playdata2")
public class LoginValidate2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		
		if(id != null && id.equals("tester")) {
			//세션 생성 또는 이미 해당 user에 매핑된 세션객체가 존재할 경우엔 반환
			HttpSession session = request.getSession();
			System.out.println(session.getId()); //고유한 session 구분하기 위한 값
			
			session.setAttribute("name", "lee");
			session.setAttribute("age", "30");
			
			response.sendRedirect("../succ2");
			
		}else {
			
		}
	}

}

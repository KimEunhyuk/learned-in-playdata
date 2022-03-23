package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/succ2")
public class Welcome2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
				
		//이미 데이터값까지 보유한 세션객체 획득해서 활용
		HttpSession session = request.getSession();
		out.println("안녕하세요 " + session.getAttribute("name"));
		
		out.println("<button onclick='location.href=\"logout2.jsp\"'>로그아웃</button>");
	}

}

package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout2")
public class Logout2 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미 존재하는 해당 user만의 세션 객체 받아와서 죽.임!!!
		//혹여 client가 세션 소멸 로직 실행없이 가령 브라우저 x로 종료해 버리는 등..
		//서버 메모리는 관리하는 gc는 30분동안 모니터링(불필요한 작업)
		//로그아웃 수행 권장
		
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("로그아웃 성공");
	}

}

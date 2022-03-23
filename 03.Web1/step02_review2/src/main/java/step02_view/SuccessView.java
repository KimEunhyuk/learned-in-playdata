package step02_view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step02_model.Member;

@WebServlet("/success")
public class SuccessView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SuccessView doGet()");
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SuccessView doPost()");
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Member> sixjo = new ArrayList<Member>();
		sixjo.add(new Member("Kim Eunhyuk", 21, "M", "eun"));
		sixjo.add(new Member("Kim Young-ae", 22, "F", "young"));
		sixjo.add(new Member("Kim Jinjoo", 20, "F", "jin"));
		
		String name = request.getParameter("id");
		System.out.println(name);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		for(Member m : sixjo) {
			if(m.getId().equals(name)) {
				out.println(m.toString());
			}
		}
		
	}
	
}

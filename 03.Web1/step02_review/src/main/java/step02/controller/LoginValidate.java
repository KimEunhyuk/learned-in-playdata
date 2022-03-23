package step02.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/playdata")
public class LoginValidate extends HttpServlet {

	public LoginValidate() {
		System.out.println("생성자---------------------");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null) {
			if(id.equals("eun")) {
				System.out.println("---eun----------");
				request.getRequestDispatcher("success1").forward(request, response);
			}
			
			else if(id.equals("jin")) {
				System.out.println("------jin-------------");
				request.getRequestDispatcher("success2").forward(request, response);			
			}
			
			else if(id.equals("young")) {
				System.out.println("------young-------------");
				request.getRequestDispatcher("success3").forward(request, response);			
			}
		}

		else{
			response.sendRedirect("Fail");
			
		}
	}
			
}

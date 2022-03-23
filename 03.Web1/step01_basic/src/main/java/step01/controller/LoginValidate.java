package step01.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://ip:port/step01_basic/playdata
@WebServlet("/playdata")
public class LoginValidate extends HttpServlet {

	public LoginValidate() {
		System.out.println("생성자---------------------");
    }

	//get요청 방식만 처리하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginVaildate doGet()");
		//...
		process(request, response);
	}

	//post요청 방식만 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginVaildate doPost()");
		//...
		process(request, response);
	}

	//doGet/doPost에서 공통 로직
	/*
	 * id/pw 값 획득 -> 검증 -> 한글 데이터 화면에 출력
	 * 고려사항
	 * 		1. 입력 데이터 한글 인코딩 무시
	 * 			-request
	 * 		2. 출력시엔 한글 인코딩 처리 고려
	 * 			-response
	 */
	
	
	
	//step02 - web page 이동 기술
	/*
	 * id/pw 뽑아서 검증 -> 조건에 맞는 view 전담 servlet 지정
	 */
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");	//tester
		String pw = request.getParameter("pw");
		
		if(id != null && id.equals("tester")) {
			System.out.println("tester 맞다 -------------------");
			
			
			
			//forward 방식으로 success라는 url mapping된 servlet으로 web page 이동
			//playdata url로 요청시 web server는 해당 client만을 위한 request객체와 response객체 생성
			//doGet()/doPost()호출하면서 parameter로 대입
			//success의 doGet()/doPost() 호출시 request객체와 response 객체 새로 생성이 아닌 공유
			//success의 request.getParameter("id") 반환값은? tester
			
			//요청 객체에 새롭게 새로운 데이터 추가 저장도 가능
			//저장 구조 - 데이터 구분이 필수 따라서 key와 value구조로 저장
			//id가 tester인 자의 이름 유재석 이름을 추가
			request.setAttribute("name", "유재석");	//request.getAttribute("name")
			
			//http://ip:port/project명/playdata -> http://ip:port/project명/success
			
			request.getRequestDispatcher("success").forward(request, response);
		}else {

			//redirect 방식으로 fail이라는 url mapping된 servlet으로 web page 이동
			request.setAttribute("name", "유재석");	//의미없음 왜? fail실행시 새로운 요청 객체생성 및 활용되기 때문
			
			
			//http://ip:port/step01_basic/fail url  의미 및 실행
			//client에게 fail정보 제공하면서 응답으로 마무리
			//client가 사용하는 브라우저가 url을 재 구정해서 client가 인식 못하는 빛의속도로 재요청
			//각각의 servlet이 요청, 응답 수형 따라서 fail은 새로운 요청이기 때문에 요청객체, 응답객체 새로 생성
			response.sendRedirect("Fail");
			
		}
	}
			
	
	//step01
	protected void process2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client 데이터 획득
		//<input type="text" name="id" value="tester">
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//출력 인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		
		//2pyte의 데이터 브라우저에 출력 객체 생성
		PrintWriter out = response.getWriter();
		
		if(id != null && id.equals("tester")) {
			out.println("안녕하세요");
		}else {
			out.println("무효한 id입니다");
		}
	}
}

package probono.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import probono.model.ProbonoService;
import probono.model.dto.ActivistDTO;

@WebServlet("/probono")
public class ProbonoFrontController extends HttpServlet {
    public ProbonoFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 정보에 한해서 한글인 경우에 인코딩 처리하는 설정
		//post방식으로 전송되는 데이터에 대한 한글 인코딩 처리는 잘 됨
		//get방식인 경우 server의 설정 파일에 인코딩 설정 추가 권장 - server.xml에 URIEncoding="utf-8"
		request.setCharacterEncoding("utf-8");
	
		//command pattern
		String command = request.getParameter("command");
		
		//?		
		try{
			if(command.equals("probonoProjectAll")){//모든 probono project 정보 검색
				probonoProjectAll(request, response);
			}else if(command.equals("activistAll")){//모든 재능 기부자 검색
				activistAll(request, response);
			}else if(command.equals("activist")){//특정 재능 기부자 정보 검색
				activist(request, response);
			}else if(command.equals("activistInsert")){//재능 기부자 추가 등록
				activistInsert(request, response);
			}else if(command.equals("activistUpdateReq")){//재능 기부자 정보 수정요청
				activistUpdateReq(request, response);
			}else if(command.equals("activistUpdate")){//재능 기부자 정보 수정
				activistUpdate(request, response);
			}else if(command.equals("activistDelete")){//재능 기부자 탈퇴[삭제]
				activistDelete(request, response);
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	

	//모두 ProbonoProject 검색 메소드
	public void probonoProjectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("probonoProjectAll", ProbonoService.getAllProbonoProjects());
			url = "probonoProjectList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//???
	//모든 재능 기부자 검색 - 검색된 데이터 출력 화면[activistList.jsp]
	public void activistAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activistAll", ProbonoService.getAllActivists());
			url = "activistList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//재능 기부자 검색 
	public void activist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activist", ProbonoService.getActivist(request.getParameter("activistId")));
			url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	//재능 기부자 가입 메소드
	protected void activistInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String major = request.getParameter("major");
		
		//해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
		//if(id != null && id.length() !=0 && name != null) {
			
		
		ActivistDTO activist = new ActivistDTO(id, name, pw, major);
		try{
			boolean result = ProbonoService.addActivist(activist);
			if(result){
				request.setAttribute("activist", activist);
				request.setAttribute("successMsg", "가입 완료");
				url = "activistDetail.jsp";
			}else{
				request.setAttribute("errorMsg", "다시 시도하세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//재능 기부자 수정 요구
	public void activistUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("activist", ProbonoService.getActivist(request.getParameter("activistId")));
			url = "activistUpdate.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	//???
	//재능 기부자 수정 - 상세정보 확인 jsp[activistDetail.jsp]
	public void activistUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String activistId = request.getParameter("activistId");
			String major = request.getParameter("major");
			ProbonoService.updateActivist(activistId, major);
			request.setAttribute("activist", ProbonoService.getActivist(request.getParameter("activistId")));
			url = "activistDetail.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//???
	//재능 기부자 삭제
	public void activistDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			String activistId = request.getParameter("activistId");
			if(ProbonoService.deleteActivist(activistId)){
				request.setAttribute("activistAll", ProbonoService.getAllActivists());
				url = "activistList.jsp";
			}else{
				request.setAttribute("errorMsg", "재 실행 해 주세요");
			}
		}catch(Exception s){
			request.setAttribute("errorMsg", "진행중인 Probono Project가 있습니다");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}

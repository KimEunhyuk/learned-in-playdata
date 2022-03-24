package applicant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import applicant.model.dto.ApplicantDTO;
import applicant.model.dto.ApplicantService;
import applicant.model.dto.CertificateDTO;

@WebServlet("/controller")
public class ApplicantController extends HttpServlet {
	
	public ApplicantController() {
        super();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//요청 정보에 한해서 한글인 경우에 인코딩 처리하는 설정
		request.setCharacterEncoding("utf-8");
	
		//command pattern
		String command = request.getParameter("command");
		
		try{
			if(command.equals("applicantInsert")){//재능 기부자 추가 등록
				applicantInsert(request, response);
			}else if(command.equals("applicant")) {
				applicant(request, response);
			}else if(command.equals("applicantUpdateReq")) {
				applicantUpdateReq(request, response);
			}else if(command.equals("applicantDelete")) {
				applicantDelete(request, response);
			}else if(command.equals("applicantUpdate")) {
				applicantUpdate(request, response);
			}else if(command.equals("applicant1")) {
				applicant1(request, response);
			}else if(command.equals("certificate")) {
				certificate(request, response);
			}else if(command.equals("certificateInsert")) {
				certificateInsert(request, response);
			}else if(command.equals("applicantAll")) {
				applicantAll(request, response);
			}else if(command.equals("gkqrurAll")) {
				gkqrurAll(request, response);
			}
				//************* 추가해야함
			
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			request.getRequestDispatcher("showError.jsp").forward(request, response);
			s.printStackTrace();
		}
	}
	
	public void gkqrurAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("gkqrurAll", ApplicantService.getAllGkqrur());
			url = "applicantList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//모든 재능 기부자 검색 - 검색된 데이터 출력 화면[activistList.jsp]
	public void applicantAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			request.setAttribute("applicantAll", ApplicantService.getAllApplicant());
			request.setAttribute("certificateAll", ApplicantService.getAllCertificate());
			url = "applicantList.jsp";
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	//재능 기부자 검색 
	public void applicant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
//			ApplicantDTO applicant = ApplicantService.getApplicant(request.getParameter("id"));
			HttpSession session = request.getSession();
			ApplicantDTO applicant = (ApplicantDTO) session.getAttribute("applicant");
			System.out.println("applicant " + applicant);
//			request.setAttribute("applicant", ApplicantService.getApplicant(request.getParameter("applicant_id")));
			url = "applicantDetail.jsp";
			System.out.println("applicant -> Detail");
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public void applicant1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "showError.jsp";
		try {
			ApplicantDTO applicant = ApplicantService.getApplicant(request.getParameter("id"));
			HttpSession session = request.getSession();
			session.setAttribute("applicant",applicant);
			System.out.println("applicant1");
			url = "loginIndex.jsp";
			System.out.println("applicant1");
		}catch(Exception s){
			request.setAttribute("errorMsg", s.getMessage());
			s.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	
	// applicantInsert :재능 기부자 가입 메소드
		protected void applicantInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";	// *** 일단 실패로 만들어줌
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			
			System.out.println(phone);
			
			//해킹등으로 불합리하게 요청도 될수 있다는 가정하에 모든 데이터가 제대로 전송이 되었는지를 검증하는 로직
			//if(id != null && id.length() !=0 && name != null) {
				
			
			ApplicantDTO applicant = new ApplicantDTO(id, password, name, phone);
			try{
				System.out.println("실행됐지롱11");
				boolean result = ApplicantService.addApplicant(applicant);
				
				if(result){
					request.setAttribute("applicant", applicant);
					request.setAttribute("successMsg", "가입 완료");
					url = "ok2.jsp";	// *** 제대로 applicant insert를 했을 때 url 수정해줌
				}else{
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		

		
		//재능 기부자 수정 요구
		public void applicantUpdateReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				System.out.println("UpdateReq");
				ApplicantDTO applicant = ApplicantService.getApplicant(request.getParameter("applicantId"));
				HttpSession session = request.getSession();
				session.setAttribute("applicant", applicant);
				System.out.println("UpdateReq" + applicant);
				
//				request.setAttribute("applicant", ApplicantService.getApplicant(request.getParameter("applicant_id")));
				url = "applicantUpdate.jsp";
				System.out.println("uqdateReq -> Update.jsp");
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
				s.printStackTrace();
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		//???
		//재능 기부자 수정 - 상세정보 확인 jsp[applicantDetail.jsp]
		public void applicantUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				String applicantId = request.getParameter("applicantId");
				String password = request.getParameter("password");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				ApplicantService.updateApplicant(applicantId, password, name, phone);
				request.setAttribute("applicant", ApplicantService.getApplicant(request.getParameter("applicantId")));
				url = "applicantDetail.jsp";
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		
//		//재능 기부자 삭제
//		public void applicantDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			String url = "showError.jsp";
//			try {
//				String applicantId = request.getParameter("applicantId");
//				if(ApplicantService.deleteApplicant(applicantId)){
//					request.setAttribute("applicantAll", ApplicantService.getAllApplicant());
//					url = "applicantList.jsp";
//				}else{
//					request.setAttribute("errorMsg", "재 실행 해 주세요");
//				}
//			}catch(Exception s){
//				request.setAttribute("errorMsg", "진행중인 Probono Project가 있습니다");
//			}
//			request.getRequestDispatcher(url).forward(request, response);
//		}
		
		
		public void applicantDelete(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String url = "showError.jsp";
			
			try {
				
				HttpSession session = request.getSession();
				ApplicantDTO applicant = (ApplicantDTO) session.getAttribute("applicant");
				String applicant_id = applicant.getId();
				System.out.println(applicant_id);
				
				if (ApplicantService.deleteApplicant(applicant_id)) {
					
					request.setAttribute("applicantAll", ApplicantService.getAllApplicant());
					System.out.println(applicant_id);
					url = "index.html";
				} else {
					request.setAttribute("errorMsg", "재 실행 해 주세요");
				}
			} catch (Exception s) {
				request.setAttribute("errorMsg", "삭제할 수 없습니다");
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		//certificate
		public void certificate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";
			try {
				
				HttpSession session = request.getSession();
				ApplicantDTO applicant = (ApplicantDTO) session.getAttribute("applicant");
				String applicant_id = applicant.getId();
				
				System.out.println(applicant_id);
				url = "certificate.jsp";
				
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
				s.printStackTrace();
			}
			request.getRequestDispatcher(url).forward(request, response);
		}
		
		// 지원자 자격증 
		protected void certificateInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "showError.jsp";			
			
			System.out.println("certificateInsert");
			
			HttpSession session = request.getSession();
			ApplicantDTO applicant = (ApplicantDTO) session.getAttribute("applicant");
			
			String applicant_id = applicant.getId();
			System.out.println(applicant_id); // 여기까지 ok
			
			int sqld = Integer.parseInt(request.getParameter("sqld"));
			int adsp = Integer.parseInt(request.getParameter("adsp"));
			int dasp = Integer.parseInt(request.getParameter("dasp"));
			int bad = Integer.parseInt(request.getParameter("bda"));
			int ipe = Integer.parseInt(request.getParameter("ipe"));
			int sum = Integer.parseInt(request.getParameter("sqld"))+Integer.parseInt(request.getParameter("adsp"))+Integer.parseInt(request.getParameter("dasp")) + Integer.parseInt(request.getParameter("bda")) + Integer.parseInt(request.getParameter("ipe"));
			System.out.println(sum);

			CertificateDTO certificate = new CertificateDTO(applicant_id, sqld, adsp, dasp, bad, ipe, sum);
			
			try{
				
				boolean result = ApplicantService.addCertificate(certificate);
				
				if(result){
					//mary수정, 로그인을유지하기 위한 id pw값 넘기기 
					request.setAttribute("certificate", certificate);
					request.setAttribute("successMsg", "등록 완료");
					url = "ok.jsp";	// *** 제대로 applicant insert를 했을 때 url 수정해줌
					
					
					
				}else{
					request.setAttribute("errorMsg", "다시 시도하세요");
				}
			}catch(Exception s){
				request.setAttribute("errorMsg", s.getMessage());
			}
			request.getRequestDispatcher(url).forward(request, response);
		}		

		
		

		

	
}
package applicant.model.dto;

import java.sql.SQLException;
import java.util.ArrayList;

import applicant.exception.MessageException;
import applicant.exception.NotExistException;
import applicant.model2.ApplicantDAO;

public class ApplicantService {
	
	//모든정보
	public static ArrayList<ApplicantDTO> getAllApplicant() throws SQLException{
		return ApplicantDAO.getAllApplicant();
	}
	
	public static ArrayList<CertificateDTO> getAllCertificate() throws SQLException{
		return ApplicantDAO.getAllCertificate();
	}
	
	public static ArrayList<GkqrurDTO> getAllGkqrur() throws SQLException{
		return ApplicantDAO.getAllGkqrur();
	}
	
	
	//add
	public static boolean addApplicant(ApplicantDTO applicant) throws MessageException{
		boolean result = false;
		try{
			System.out.println("실행됐지롱22");
			result = ApplicantDAO.addApplicant(applicant);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}
	
	//update
	public static boolean updateApplicant(String applicantId, String password, String name, String phone) throws SQLException, NotExistException{		
		notExistApplicant(applicantId);
		boolean result = ApplicantDAO.updateApplicant(applicantId, password, name, phone);
		if(!result){
			throw new NotExistException("지원자 정보 갱신 실패");
		}
		return result;
	}
	
	//delete
	public static boolean deleteApplicant(String applicantId) throws SQLException, NotExistException{
		notExistApplicant(applicantId);
		boolean result = ApplicantDAO.deleteApplicant(applicantId);
		
		System.out.println(result);
		
		if(!result){
			throw new NotExistException("지원자 정보 삭제 실패");
		}
		return result;
	}
	
	//get
	public static ApplicantDTO getApplicant(String applicantId) throws SQLException, NotExistException{
		ApplicantDTO applicant = ApplicantDAO.getApplicant(applicantId);
		if(applicant == null){
			throw new NotExistException("검색하는 지원자가 미 존재합니다.");
		}
		return applicant;
	}

	//Applicant - CRUD
	public static void notExistApplicant(String applicantId) throws NotExistException, SQLException{
		ApplicantDTO applicant = ApplicantDAO.getApplicant(applicantId);
		if(applicant == null){
			throw new NotExistException("검색하는 지원자가 미 존재합니다.");
		}
	}
	
	// 지원자 자격증 정보 등록 
	public static boolean addCertificate(CertificateDTO certificate) throws MessageException{
		boolean result = false;
		try{
			
			result = ApplicantDAO.addCertificate(certificate);
		}catch(SQLException s){
			throw new MessageException("이미 존재하는 ID입니다 다시 시도 하세요");
		}
		return result;
	}

}
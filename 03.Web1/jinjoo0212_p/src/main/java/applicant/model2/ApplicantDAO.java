package applicant.model2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import applicant.model.dto.ApplicantDTO;
import applicant.model.dto.CertificateDTO;
import applicant.model.dto.GkqrurDTO;
import applicant.util.DBUtil;

public class ApplicantDAO {
	
	public static boolean addApplicant(ApplicantDTO applicant) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try{
			con = DBUtil.getConnection();
			System.out.println("실행됐지롱22__22");
			
			pstmt = con.prepareStatement("insert into applicant values(?, ?, ?, ?)");
			pstmt.setString(1, applicant.getId());
			pstmt.setString(2, applicant.getPassword());
			pstmt.setString(3, applicant.getName());
			pstmt.setString(4, applicant.getPhone());
			System.out.println("실행됐지롱33");
			
			pstmt2 = con.prepareStatement("insert into certificate values(?, ?, ?, ?, ?, ?, ?)");
			
			pstmt2.setString(1, applicant.getId());
			pstmt2.setInt(2, 0);
			pstmt2.setInt(3, 0);
			pstmt2.setInt(4, 0);
			pstmt2.setInt(5, 0);
			pstmt2.setInt(6, 0);
			pstmt2.setInt(7, 0);

			
			
			int result = pstmt.executeUpdate();
			int result2 = pstmt2.executeUpdate();
		
			if(result == 1 && result2 ==1){
				System.out.println("실행됐지롱44");
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
			finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//수정  
	//기부자 id로 주요 기부 내용 수정하기
	public static boolean updateApplicant(String applicantId, String password, String name, String phone) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement("update applicant set password=?, name=?, phone=? where applicant_id=?");
			
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, applicantId);
			
			int result = pstmt.executeUpdate();
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	public static boolean deleteApplicant(String applicant_id) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try{
			con = DBUtil.getConnection();
			System.out.println("deleteApplicant -connection됐어 2");
			
			System.out.println(applicant_id+" deleteApplicant");
			
			
			pstmt1 = con.prepareStatement("delete from certificate where applicant_id=?");
			pstmt2 = con.prepareStatement("delete from applicant where applicant_id=?");
			
			pstmt1.setString(1, applicant_id);
			pstmt2.setString(1, applicant_id);
			
			System.out.println(applicant_id+ " deleteApplicant2");
			
			
			int result1 = pstmt1.executeUpdate();
			int result2 = pstmt2.executeUpdate();
			
			
			
			System.out.println(result1);	
			System.out.println(result2);	
			
			if(result1 == 1 && result2 == 1){
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
			finally{
				DBUtil.close(con, pstmt1,pstmt2);
		}
		
		return false;
	}

	
	//id로 해당 기부자의 모든 정보 반환
	public static ApplicantDTO getApplicant(String applicantId) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ApplicantDTO applicant = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from applicant where applicant_id=?");
			pstmt.setString(1, applicantId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				applicant = new ApplicantDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return applicant;
	}
	
	//???모든 기부자 검색해서 반환
	//sql - select * from activist
	public static ArrayList<ApplicantDTO> getAllApplicant() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ApplicantDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from applicant");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ApplicantDTO>();
			while(rset.next()){
				list.add(new ApplicantDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<CertificateDTO> getAllCertificate() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CertificateDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * from (SELECT c.* FROM certificate c LEFT JOIN applicant a ON c.APPLICANT_ID =a.APPLICANT_ID ORDER BY sum DESC) WHERE rownum <=3");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<CertificateDTO>();
			while(rset.next()){
				list.add(new CertificateDTO(rset.getString(1), rset.getInt(2), rset.getInt(3), rset.getInt(4), rset.getInt(5), rset.getInt(6), rset.getInt(7)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static ArrayList<GkqrurDTO> getAllGkqrur() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<GkqrurDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT c.applicant_id , a.name , sum from(SELECT rownum AS rn, applicant_id, sum FROM (SELECT applicant_id, SUM FROM certificate ORDER BY SUM DESC)) c ,applicant a WHERE c.applicant_id= a.applicant_id AND rn BETWEEN 1 AND 3 ORDER BY sum desc");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<GkqrurDTO>();
			while(rset.next()){
				list.add(new GkqrurDTO(rset.getString(1), rset.getString(2), rset.getInt(3)) );
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	public static boolean addCertificate(CertificateDTO certificate) throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			System.out.println("실행됐지롱22__22");
		
			pstmt = con.prepareStatement("update certificate set sqld =?, adsp =? , dasp =? , bda = ?, ipe =? ,sum =? where applicant_id =?");
			
			pstmt.setInt(1, certificate.getSqld());
			pstmt.setInt(2, certificate.getAdsp());
			pstmt.setInt(3, certificate.getDasp());
			pstmt.setInt(4, certificate.getBda());
			pstmt.setInt(5, certificate.getIpe());
			pstmt.setInt(6, certificate.getSqld()+certificate.getAdsp()+certificate.getDasp()+certificate.getBda()+certificate.getIpe());
			pstmt.setString(7, certificate.getApplicant_id());
			
			int result = pstmt.executeUpdate();
		
			if(result == 1){
				System.out.println("실행됐지롱44");
				return true;
			}

		}catch(Exception e){
			e.printStackTrace();
		}
			finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	

}
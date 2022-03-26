package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JNDI API 활용 기술
 * WAS의 설정 정보 활용 가능하게 해주는 API
 * 자원의 이름으로 검색(lookup)해서 반환해주는 API
 */
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//Connection 객체를 정해진 개수만큼 관리 및 제공해주는 핵심 API

import javax.sql.DataSource;

public class DBUtil {
	
	private static DataSource ds;
	
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	
	//CP 기능의 close()는 CP메모리에 반환
	public static void close(Connection con, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public static void close(Connection con, Statement stmt, ResultSet rset) {
		try {
			if (rset != null) {
				rset.close();
				rset = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}
	
}

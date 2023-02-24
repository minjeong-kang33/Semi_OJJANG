package com.itwillbs.report.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReportDAO {

	public Connection getConnection() throws Exception{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con = ds.getConnection();
		return con;
	
	} //getConnection() 끝
	
	
	public void insertReport(ReportDTO dto) {
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();

			//신고폼에서 작성되는 Data 등록하기
			String sql="insert into report values(?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getR_type());
			pstmt.setString(2, dto.getM_id());
			pstmt.setString(3, dto.getR_id()); // test로 (구매자 땡겨오는거 아직 못해서)
			pstmt.setString(4, dto.getR_reason());
			pstmt.setString(5, dto.getR_category());
			pstmt.setString(6, dto.getR_writeNum());
			pstmt.setString(7, dto.getR_title());
			pstmt.setString(8, dto.getR_play());
			pstmt.setTimestamp(9, dto.getR_date());
			
			pstmt.executeUpdate();	
			}
			catch (Exception e) {
			e.printStackTrace();//어느부분에 에러가 발생했는지 찾아줌
			}
			finally {
				if (pstmt != null)try {pstmt.close();} catch (Exception e2) {}
				if (con != null)try {con.close();} catch (Exception e2) {}
				if(rs!=null) try {rs.close();} catch (Exception e2) {}
			}
	} //insertReport()끝 수정중입니다. 
	
	
	
	
	
}

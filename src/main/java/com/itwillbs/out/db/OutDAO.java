package com.itwillbs.out.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class OutDAO {

	public Connection getConnection() throws Exception{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con = ds.getConnection();
		return con;
	
	} //getConnection() 끝
	
	
	public void insertOut(OutDTO dto2) {
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			int O_num=1;
			String sql ="select max(O_num) from outs";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				O_num=rs.getInt("max(O_num)")+1;
			}
			sql="insert into outs(O_num,M_id,O_reason,O_outday) values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setInt(1, O_num);
			pstmt.setString(2, dto2.getM_id());
			pstmt.setString(3, dto2.getO_reason());
			pstmt.setTimestamp(4, dto2.getO_outday());
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
	} 
	
	
	
	
}

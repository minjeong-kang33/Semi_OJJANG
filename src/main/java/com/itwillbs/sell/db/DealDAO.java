package com.itwillbs.sell.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.deal.db.DealDTO;

public class DealDAO {
	
		public Connection getConnection() throws Exception{
			Context init=new InitialContext();
			DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
			Connection con=ds.getConnection();
			return con;
		}
			
	public ArrayList<DealDTO> dealList(String M_id){
		ArrayList<DealDTO> dealList=new ArrayList<DealDTO>();
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from deal where D_buy=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				
				DealDTO dto=new DealDTO();
				dto.setD_num(rs.getInt("D_num"));
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setD_buy(rs.getString("D_buy"));
				dto.setD_date(rs.getTimestamp("D_date"));
				
				dealList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return dealList;
	}//판매내역
	

	
}

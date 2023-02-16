package com.itwillbs.comment.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;




public class CommentDAO {
	public Connection getConnection() throws Exception{
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	} //getConnection()

	public ArrayList<CommentDTO> getList(int B_num, int pageNumber){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<CommentDTO> List=new ArrayList<CommentDTO>();
		try {
			con = getConnection();
			String SQL="SELECT * FROM comment WHERE Co_num<? AND Co_available=1 AND B_num=? ORDER BY Co_num DESC LIMIT 10";
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, getNext()-(pageNumber-1)*10);
			pstmt.setInt(2, B_num);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				CommentDTO reply=new CommentDTO();
				reply.setM_id(rs.getString(1));
				reply.setCo_num(rs.getInt(2));
				reply.setCo_text(rs.getString(3));
				reply.setB_num(B_num);
				reply.setCo_available(1); // rs.getInt(5) => out of index 오류
				List.add(reply);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
	}
		return List;
	}
	
	
	public int getNext() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String SQL="select Co_num FROM comment ORDER BY Co_num DESC";
			pstmt=con.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1)); // select문에서 첫번째 값
				return rs.getInt(1)+1;  // 현재 인덱스(현재 게시글 개수) +1 반환
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
	}
		return -1;
	}
	
	public CommentDTO getComment(int Co_num) {
		CommentDTO reply = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con =  getConnection();
			String SQL = "select Co_text from comment where Co_num = ?";
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1,Co_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reply = new CommentDTO();
				reply.setCo_text(rs.getString("Co_text"));
			}else {
		}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return reply;
		
	}
	
	public int write(int B_num,String Co_text,String M_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();
			String SQL="INSERT INTO comment VALUES(?,?,?,?,?)";
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,M_id);
			pstmt.setInt(2, getNext());
			pstmt.setString(3, Co_text);
			pstmt.setInt(4,B_num);
			pstmt.setInt(5,1);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
	}
		return -1;
	}
	
	public int delete(int Co_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		con = getConnection();
		String SQL="update comment set Co_available=0 where Co_num=?";
		pstmt=con.prepareStatement(SQL);
		pstmt.setInt(1, Co_num);
		return pstmt.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}finally {
		// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
		if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
		if(con!=null) try { con.close();} catch (Exception e2) {}
		}
			return -1;
		}
	
	public int update(int Co_num, String Co_text) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String SQL="update comment set Co_text=? where Co_num=?";
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, Co_text);
			pstmt.setInt(2, Co_num);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
			}
				return -1;
			}
	
	
	
	
}

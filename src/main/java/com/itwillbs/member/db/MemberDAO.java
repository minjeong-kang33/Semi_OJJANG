package com.itwillbs.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	public Connection getConnection() throws Exception{
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	}
	
	public void insertMembers(MemberDTO dto) {
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="insert into member(M_id,M_pw,M_name,M_nick,M_gender,M_phone,M_address,M_address2,M_email,M_createdate) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getM_id());
			pstmt.setString(2, dto.getM_pw());
			pstmt.setString(3, dto.getM_name());
			pstmt.setString(4, dto.getM_nick());
			pstmt.setString(5, dto.getM_gender());
			pstmt.setString(6, dto.getM_phone());
			pstmt.setString(7, dto.getM_address());
			pstmt.setString(8, dto.getM_address2());
			pstmt.setString(9, dto.getM_email());
			pstmt.setTimestamp(10,dto.getM_createdate());
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				if (pstmt != null) try {pstmt.close();} catch (Exception e2) {}
				if (con != null) try {con.close();} catch (Exception e2) {}
			}
	}

	public MemberDTO M_userCheck(String M_id, String M_pw) {
		MemberDTO dto=null;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con = getConnection();
		     String sql="select * from member where M_id=? and M_pw=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,M_id);
			 pstmt.setString(2,M_pw);
			 rs=pstmt.executeQuery(); 
			 
			 if(rs.next()){
				dto=new MemberDTO(); 
				dto.setM_id(rs.getString("M_id"));
				dto.setM_pw(rs.getString("M_pw"));
			 }else{
				 
			 }
		}catch (Exception e) {	
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
			if(rs!=null)try {rs.close();} catch (Exception e2) {}

		}
		return dto;
	}
	
	public MemberDTO getMember(String M_id) {
		MemberDTO dto=null;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			
			String sql="select * from member where M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			
			rs=pstmt.executeQuery();

			if(rs.next()){

				dto=new MemberDTO();
				
				dto.setM_id(rs.getString("M_id"));
				dto.setM_pw(rs.getString("M_pw"));
				dto.setM_name(rs.getString("M_name"));
				dto.setM_nick(rs.getString("M_nick"));
				dto.setM_gender(rs.getString("M_gender"));
				dto.setM_address(rs.getString("M_address"));
				dto.setM_address2(rs.getString("M_address2"));
				dto.setM_email(rs.getString("M_email"));
				dto.setM_createdate(rs.getTimestamp("M_createdate"));
				dto.setM_play(rs.getInt("M_play"));
				dto.setM_admin(rs.getString("M_admin"));
				dto.setM_phone(rs.getString("M_phone"));
			}
		
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
		
		finally {
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return dto;
	}//getMember()	


	public void updateMember(MemberDTO updateDto) {
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			
			con=getConnection();
			
			String sql="update member set M_nick=?, M_email=?, M_address=? where M_id =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, updateDto.getM_nick()); 
			pstmt.setString(2, updateDto.getM_email());  
			pstmt.setString(3, updateDto.getM_address());  
			pstmt.setString(4, updateDto.getM_id());  
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
	}//updateMember()
	
	public void updatePw(MemberDTO updatePwDto) {
		System.out.println("pw변경");
		Connection con =null;
		PreparedStatement pstmt=null;
		
		System.out.println(updatePwDto.getM_pw());
		System.out.println(updatePwDto.getM_id());
		try {
			
			con=getConnection();			
			String sql="update member set M_pw=? where M_id =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, updatePwDto.getM_pw());
			pstmt.setString(2, updatePwDto.getM_id());			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
	} //updatePw()
	
	//회원인지 아닌지 체크하는 매서드
	public int registerCheck(String M_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM MEMBER WHERE M_id = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, M_id);
			rs = pstmt.executeQuery();
			if (rs.next() || M_id.equals("")) {
				return 0; // 이미 존재하는 회원
			} else {
				return 1; // 가입 가능한 회원 아이디
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
		return -1;  // 데이터베이스 오류
	}
	public int duplecateID(String M_id){
		int cnt=0;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    try{
	    	con=getConnection();
	        StringBuilder sql=new StringBuilder();
	        
	  
	        sql.append(" SELECT count(M_id) as cnt ");
	        sql.append(" FROM member ");
	        sql.append(" WHERE M_id = ? ");
	        
	        pstmt=con.prepareStatement(sql.toString());
	        pstmt.setString(1, M_id);
	        
	        rs=pstmt.executeQuery();
	        if(rs.next()){
	        	cnt=rs.getInt("cnt");
	        }
	    }catch(Exception e){
	     	System.out.println("아이디 중복 확인 실패 : " + e);
	    }
	    finally {
	    	if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
		}
		return cnt;
	}//idCheck
	public int duplecateNick(String M_nick){
		int cnt=0;
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    try{
	    	con=getConnection();
	        StringBuilder sql=new StringBuilder();
	        
	  
	        sql.append(" SELECT count(M_nick) as cnt ");
	        sql.append(" FROM member ");
	        sql.append(" WHERE M_nick = ? ");
	        
	        pstmt=con.prepareStatement(sql.toString());
	        pstmt.setString(1, M_nick);
	        
	        rs=pstmt.executeQuery();
	        if(rs.next()){
	        	cnt=rs.getInt("cnt");
	        }
	    }catch(Exception e){
	     	System.out.println("닉네임 중복 확인 실패 : " + e);
	    }
	    finally {
	    	if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
			if(rs!=null)try {rs.close();} catch (Exception e2) {}
		}
		return cnt;
	}//nick체크
	public String findId(String M_name, String M_phone) {
		String M_id = null;
		
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql = "select M_id from member where M_name=? and M_phone=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, M_name);
			pstmt.setString(2, M_phone);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				M_id=rs.getString("M_id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(pstmt!=null)try {pstmt.close();} catch (Exception e2) {}
			if(con!=null)try {con.close();} catch (Exception e2) {}
			if(rs!=null)try {rs.close();} catch (Exception e2) {}

		}
		return M_id;
	}//ID찾기
	
}

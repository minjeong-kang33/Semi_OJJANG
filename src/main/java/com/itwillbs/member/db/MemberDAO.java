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
			String sql="insert into member(M_id,M_pw,M_name,M_nick,M_gender,M_phone,M_address,M_address2,M_email,M_createdate,M_admin,M_play) values(?,?,?,?,?,?,?,?,?,?,'U','일반')";
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
				dto.setM_play(rs.getString("M_play"));
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
			
			String sql="update member set M_nick=?, M_email=?, M_address=?, M_address2=? where M_id =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, updateDto.getM_nick()); 
			pstmt.setString(2, updateDto.getM_email());  
			pstmt.setString(3, updateDto.getM_address());  
			pstmt.setString(4, updateDto.getM_address2());  			
			pstmt.setString(5, updateDto.getM_id());  
			
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
	
	
	
	public String findID(String M_name, String M_email) {
		String M_id = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT M_id ");
			sql.append(" FROM member ");
			sql.append(" WHERE M_name=? and M_email=?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, M_name);
			pstmt.setString(2, M_email);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				M_id = rs.getString("M_id");
			
			}//if end
			
		} catch (Exception e) {
			System.out.println("이메일 중복확인 실패:" + e);
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (Exception e2) {}
			if (con != null)try {con.close();} catch (Exception e2) {}
			if (rs != null)try {rs.close();} catch (Exception e2) {}
		}//end			
		return M_id;
	}//findID() end

	public String randomPasswd(int length){
		int index = 0;
		char[] charset = new char[] {
			'0','1','2','3','4','5','6','7','8','9'
			,'A','B','C','D','E','F','G','H','I','J','K','L','M'
			,'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
			,'a','b','c','d','e','f','g','h','i','j','k','l','m'
			,'n','o','p','q','r','s','t','u','v','w','x','y','z'
		};

		StringBuffer sb = new StringBuffer();
		for(int i = 0 ; i<length ; i++){
			index = (int) (charset.length * Math.random());
			sb.append(charset[index]);
		}//for end
		return sb.toString();
	}//randomPasswd() end

	public int updatePasswd(MemberDTO dto) {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE member ");
			sql.append(" SET M_pw = ? ");
			sql.append(" WHERE M_id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getM_pw());
			pstmt.setString(2, dto.getM_id());
			pstmt.executeUpdate();

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)try {pstmt.close();} catch (Exception e2) {}
			if (con != null)try {con.close();} catch (Exception e2) {}
			if (rs != null)try {rs.close();} catch (Exception e2) {}
		}
		return cnt;	
	}	
	
	//profile 인트값 있는지 없는지
		public int profile(String M_id, String M_Profile) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String SQL = "UPDATE member SET M_Profile = ? WHERE M_id = ?";
			try {
				con = getConnection();
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, M_Profile);
				pstmt.setString(2, M_id);
	            return pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
			return -1;  // 데이터베이스 오류
		}
		
		// 프로필 기본값
		public String getProfile(String M_id) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String SQL = "SELECT M_Profile FROM Member WHERE M_id = ?";
			try {
				con = getConnection();
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, M_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if(rs.getString("M_Profile").equals("")) {
						return "http://localhost:8080/SemiProject_OJJANG/images/icon.png";
					}
					return "http://localhost:8080/SemiProject_OJJANG/upload/" + rs.getString("M_Profile");
				} 
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
			return "http://localhost:8080/SemiProject_OJJANG/images/icon.png";
		}
		
		
		// 로그인 1 = 로그인 , 2 = 실패 , 0 = 해당 사용자 존재X
		public int login(String M_id, String M_pw) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String SQL = "SELECT * FROM Member WHERE M_id = ?";
			try {
				con = getConnection();
				pstmt = con.prepareStatement(SQL);
				pstmt.setString(1, M_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if(rs.getString("M_pw").equals(M_pw)) {
						return 1; // 로그인에 성공
					}
					return 2; // 비밀번호가 틀림 
				} else {
					return 0; // 해당 사용자가 존재하지 않음
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				} catch (Exception e) {
				    e.printStackTrace();
				}
			}
			return -1;  // 데이터 베이스 오류
		}
		public void DeleteMember(String M_id) {
			Connection con =null;
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			try {
				//1,2 디비연결 메서드
				con=getConnection();
				String sql="update member set M_play='탈퇴', M_pw=null where M_id =?";
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, M_id); 
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if (pstmt != null)try {pstmt.close();} catch (Exception e2) {}
				if (con != null)try {con.close();} catch (Exception e2) {}
				if (rs != null)try {rs.close();} catch (Exception e2) {}
			}
		}// Delete
		public String M_playCheck(String M_id) {
				Connection con=null;
				PreparedStatement pstmt=null;
				ResultSet rs=null;
				String M_play=null;
				try {
					con=getConnection();
					String sql="select M_play from member where M_id=?";
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1, M_id);
					rs=pstmt.executeQuery();
					if(rs.next()) {
						M_play=rs.getString("M_play");
					}
				}catch(Exception e){
					e.printStackTrace();
				}finally {
					if(con!=null) try {con.close();} catch (Exception e2) {}
					if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
					if(rs!=null) try {rs.close();} catch (Exception e2) {}
				} return M_play;
		}//M_playCheck(), M_play 확인하는 메서드
	
}

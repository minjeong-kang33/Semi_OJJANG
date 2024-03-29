package com.itwillbs.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.buy.db.BuyDTO;
import com.itwillbs.deal.db.DealDTO;
import com.itwillbs.like.db.LikeDTO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.sell.db.SellDTO;


public class MypageDAO {
	
	public Connection getConnection() throws Exception{
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	}
	
	//================like===========================================
	
//	//likePro_insertlike
	
	public void insertlike(int S_num, String M_id) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			
			String sql="insert into likes(S_num,M_id) values(?,?)";
			pstmt=con.prepareStatement(sql);	
			pstmt.setInt(1, S_num);
			pstmt.setString(2, M_id);			
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {				
				if (con != null) try {con.close();} catch (Exception e2) {}
				if (pstmt != null) try {pstmt.close();} catch (Exception e2) {}
				if (rs != null) try {rs.close();} catch (Exception e2) {}
			}
		
	}	//insertlike

	

	//likePro_insertlike
	public void insertlike_S_like(int S_num) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="update sell set S_like=S_like+1 where S_num=?";
			pstmt=con.prepareStatement(sql);			
			pstmt.setInt(1,S_num);			
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {				
				if (con != null) try {con.close();} catch (Exception e2) {}
				if (pstmt != null) try {pstmt.close();} catch (Exception e2) {}
				if (rs != null) try {rs.close();} catch (Exception e2) {}
			}
		
	}	//insertlike

	
	//likePro_getLike(체크하는거)
	public LikeDTO getLike(String M_id, int S_num) {
		LikeDTO dto=null;
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con = getConnection();
		     String sql="select * from likes where M_id=? and S_num=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,M_id);
			 pstmt.setInt(2,S_num);
			 rs=pstmt.executeQuery(); 
			 
			 if(rs.next()){
				dto=new LikeDTO(); 
				dto.setM_id(rs.getString("M_id"));
				dto.setS_num(rs.getInt("S_num"));
				dto.setL_date(rs.getTimestamp("L_date"));
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
	}//likePro_getLike
	
	
	//delete_like //글삭제할때 되게!!!!
	public void deleteLike(int S_num) {
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="delete from likes where S_num =?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, S_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
	} //delete_like

	
	//좋아요 취소
	public void cancelLike(int S_num, String M_id) {
		Connection con =null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="delete from likes where S_num =? and M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, S_num);
			pstmt.setString(2, M_id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
	}
		
	
	//minus //좋아요취소하면 S_like -1되는거
	public void minusSlike(int S_num) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			String sql="update sell set S_like=S_like-1 where S_num=?";
			pstmt=con.prepareStatement(sql);			
			pstmt.setInt(1,S_num);			
			pstmt.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {				
				if (con != null) try {con.close();} catch (Exception e2) {}
				if (pstmt != null) try {pstmt.close();} catch (Exception e2) {}
				if (rs != null) try {rs.close();} catch (Exception e2) {}
			}
		
	} //delete_like
	

//============================페이징
	

	public ArrayList<SellDTO> sellList(int startRow, int pageSize, String M_id){
		System.out.println("SellDAO sellList()");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<SellDTO> sellList=new ArrayList<>();
		try {
			
			con=getConnection();
			
			String sql="select * from sell where M_id=? order by S_num desc limit ?,?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			
			rs=pstmt.executeQuery();
			//5
			while(rs.next()) {
				// 하나의 글의 바구니에 저장
				SellDTO dto=new SellDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setS_num(rs.getInt("S_num"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_price(rs.getString("S_price"));
				dto.setS_text(rs.getString("S_text"));
				dto.setS_like(rs.getInt("S_like"));
				dto.setS_view(rs.getInt("S_view"));
				dto.setS_send1(rs.getString("S_send1"));
				dto.setS_send2(rs.getString("S_send2"));
				dto.setS_sido1(rs.getString("S_sido1"));
				dto.setS_gugun1(rs.getString("S_gugun1"));
				dto.setS_createdate(rs.getTimestamp("S_createdate"));
				dto.setS_category(rs.getString("S_category"));
				dto.setS_img(rs.getString("S_img"));
				
				// 바구니의 주소값을 배열 한칸에 저장
				sellList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return sellList;
	}
	
	
	public ArrayList<BuyDTO> buyList(int startRow, int pageSize, String M_id){
		System.out.println("BuyDAO buyList()");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<BuyDTO> buyList=new ArrayList<>();
		try {
		
			con=getConnection();

			String sql="select * from buy where M_id=? order by B_num desc limit ?,?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);

			rs=pstmt.executeQuery();
			//5
			while(rs.next()) {
				// 하나의 글의 바구니에 저장
				BuyDTO dto=new BuyDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setB_num(rs.getInt("B_num"));
				dto.setB_category(rs.getString("B_category"));
				dto.setB_title(rs.getString("B_title"));
				dto.setB_text(rs.getString("B_text"));
				dto.setB_send1(rs.getString("B_send2"));
				dto.setB_sido1(rs.getString("B_sido1"));
				dto.setB_gugun1(rs.getString("B_gugun1"));
				dto.setB_view(rs.getInt("B_view"));
				dto.setB_time(rs.getTimestamp("B_time"));
				dto.setB_img(rs.getString("B_img"));
				dto.setB_time(rs.getTimestamp("B_time"));
				
				// 바구니의 주소값을 배열 한칸에 저장
				buyList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return buyList;
	}
	
	//likeList 찜한 목록
	public ArrayList<SellDTO> likeList(int startRow, int pageSize,String M_id) {
		ArrayList<SellDTO> likeList=new ArrayList<SellDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql= "select s.S_num, s.S_img, s.M_id, s.S_category, s.S_title, s.S_text, s.S_price from sell s join likes l on s.S_num=l.S_num where l.M_id=?  order by l.L_date desc limit ?,?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_img(rs.getString("S_img"));
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setS_category(rs.getString("S_category"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_text(rs.getString("S_text"));
				dto.setS_price(rs.getString("S_price"));
			
				likeList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return likeList;
	}
	

	//구매내역2
	   public ArrayList<DealDTO> buyHistory(int startRow, int pageSize,String M_id) {
		      ArrayList<DealDTO> buyHistory=new ArrayList<DealDTO>();
		      Connection con=null;
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      try {
		         con=getConnection();
		         String sql=(" select s.S_img as S_img, s.S_title as S_title, s.S_price as S_price, d.M_id as M_id, d.D_date as D_date, s.S_category as S_category, s.S_num as S_num, d.D_buy as D_buy"
		               + " from sell s join deal d"
		               + " on s.S_num=d.S_num"
		               + " where D_buy=? and D_play='거래완료'"
		               + " order by d.D_date desc limit ?,?");
		         pstmt=con.prepareStatement(sql);
		         pstmt.setString(1, M_id);
		         pstmt.setInt(2, startRow-1);
		         pstmt.setInt(3, pageSize);
		         rs=pstmt.executeQuery();
		         while(rs.next()) {
		            DealDTO dto=new DealDTO();
		            dto.setS_num(rs.getInt("S_num"));
		            dto.setM_id(rs.getString("M_id"));
		            dto.setS_category(rs.getString("S_category"));
		            dto.setS_title(rs.getString("S_title"));
		            dto.setS_price(rs.getString("S_price"));
		            dto.setS_img(rs.getString("S_img"));
		            dto.setD_buy(rs.getString("D_buy"));
		            dto.setD_date(rs.getTimestamp("D_date"));
		         
		            buyHistory.add(dto);
		         }
		      }catch(Exception e) {
		         e.printStackTrace();
		      }finally {
		         if(con!=null) try {con.close();} catch (Exception e2) {}
		         if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		         if(rs!=null) try {rs.close();} catch (Exception e2) {}
		      }
		      return buyHistory;
		   }
	
	  //판매내역
	   public ArrayList<DealDTO> sellHistory(int startRow, int pageSize,String M_id) {
		      ArrayList<DealDTO> sellHistory=new ArrayList<DealDTO>();
		      Connection con=null;
		      PreparedStatement pstmt=null;
		      ResultSet rs=null;
		      try {
		         con=getConnection();
		         String sql=( " select s.S_num, s.S_img, s.S_title, s.S_price, d.D_buy, d.D_date, d.M_id "
		        		 	+ " from sell s join deal d"
		        		 	+ " on s.S_num=d.S_num"
		        		 	+ " where d.M_id=? and D_play='거래완료'"
		        		 	+ " order by d.D_date desc limit ?,?");
		         pstmt=con.prepareStatement(sql);
		         pstmt.setString(1, M_id);
		         pstmt.setInt(2, startRow-1);
		         pstmt.setInt(3, pageSize);
		         rs=pstmt.executeQuery();
		         while(rs.next()) {
		            DealDTO dto=new DealDTO();
					dto.setS_num(rs.getInt("S_num"));
					dto.setM_id(rs.getString("M_id"));
					dto.setS_title(rs.getString("S_title"));
					dto.setS_price(rs.getString("S_price"));
					dto.setS_img(rs.getString("S_img"));
					dto.setD_buy(rs.getString("D_buy"));
					dto.setD_date(rs.getTimestamp("D_date"));
		            sellHistory.add(dto);
		         }
		      }catch(Exception e) {
		         e.printStackTrace();
		      }finally {
		         if(con!=null) try {con.close();} catch (Exception e2) {}
		         if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		         if(rs!=null) try {rs.close();} catch (Exception e2) {}
		      }
		      return sellHistory;
		   }
	


	
	
// Count=============================================================
	
	
	public int getsellCount(String M_id) {
		int count=0;
		Connection con =null;
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		try {
			
			con=getConnection();
			
			String sql="select count(*) from Sell where M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt("count(*)");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return count;
	}
	

	
	public int getbuyCount(String M_id) {
		int count=0;
		Connection con =null;
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		try {
			
			con=getConnection();
			
			String sql="select count(*) from Buy where M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt("count(*)");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return count;
	}
	
	
	public int getlikeCount(String M_id) {
		int count=0;
		Connection con =null;
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		try {
			
			con=getConnection();
			
			String sql="select count(*) from likes where M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt("count(*)");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return count;
	}
	
	
	
	public int getdealCount(String M_id) {
		int count=0;
		Connection con =null;
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		try {
			
			con=getConnection();
			
			String sql="select count(*) from deal where D_buy=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt("count(*)");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return count;
	}
	
	public int getdealCount1(String M_id) {
		int count=0;
		Connection con =null;
		PreparedStatement pstmt=null;	
		ResultSet rs=null;
		try {
			
			con=getConnection();
			
			String sql="select count(*) from deal where M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				count=rs.getInt("count(*)");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 예외 상관없이 마무리작업 => 객체생성한 기억장소 해제
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


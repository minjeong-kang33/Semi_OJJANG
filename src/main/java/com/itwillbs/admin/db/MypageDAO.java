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


	//판매내역1
//	public ArrayList<SellDTO> sellHistory(String M_id) {
//		ArrayList<SellDTO> sellHistory=new ArrayList<SellDTO>();
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con=getConnection();
//			String sql="select * from sell where M_id in ( select M_id from deal where M_id=?)";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, M_id);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				SellDTO dto=new SellDTO();
//				dto.setS_title(rs.getString("S_title"));
//				dto.setS_price(rs.getInt("S_price"));		
//				dto.setS_category(rs.getString("S_category"));
//				dto.setS_num(rs.getInt("S_num"));
//				sellHistory.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(con!=null) try {con.close();} catch (Exception e2) {}
//			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
//			if(rs!=null) try {rs.close();} catch (Exception e2) {}
//		}
//		return sellHistory;
//	};
	
	
	//판매내역2
//	public ArrayList<DealDTO> dealHistory(String M_id) {
//		ArrayList<DealDTO> dealHistory=new ArrayList<DealDTO>();
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con=getConnection();
//			String sql= "select D_buy, D_date from deal where M_id in (select M_id from sell where M_id=?)";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, M_id);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				DealDTO dto=new DealDTO();
//				dto.setD_buy(rs.getString("D_buy"));
//				dto.setD_date(rs.getTimestamp("D_date"));
//			
//				dealHistory.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(con!=null) try {con.close();} catch (Exception e2) {}
//			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
//			if(rs!=null) try {rs.close();} catch (Exception e2) {}
//		}
//		return dealHistory;
//	}
	

	

	//buyHistory_dealListS
//	public ArrayList<SellDTO> dealListS(String M_id) {
//		ArrayList<SellDTO> dealListS=new ArrayList<SellDTO>();
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con=getConnection();
//			String sql="select* from sell where S_num in ( select S_num from deal where D_buy=?)";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, M_id);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				SellDTO dto=new SellDTO();
//				dto.setM_id(rs.getString("M_id"));
//				dto.setS_title(rs.getString("S_title"));
//				dto.setS_price(rs.getInt("S_price"));		
//				dto.setS_category(rs.getString("S_category"));
//				dto.setS_num(rs.getInt("S_num"));
//				dealListS.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(con!=null) try {con.close();} catch (Exception e2) {}
//			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
//			if(rs!=null) try {rs.close();} catch (Exception e2) {}
//		}
//		return dealListS;
//	}

//	public ArrayList<DealDTO> dealListB(String M_id){
//		ArrayList<DealDTO> dealListB=new ArrayList<DealDTO>();
//		Connection con =null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con=getConnection();
//			String sql="select * from deal where D_buy=?";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, M_id);
//			
//			rs=pstmt.executeQuery();	
//
//			while(rs.next()) {
//				
//				DealDTO dto=new DealDTO();
//				dto.setD_num(rs.getInt("D_num"));
//				dto.setS_num(rs.getInt("S_num"));
//				dto.setM_id(rs.getString("M_id"));
//				dto.setD_buy(rs.getString("D_buy"));
//				dto.setD_date(rs.getTimestamp("D_date"));
//				
//				dealListB.add(dto);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			
//			if(rs!=null) try { rs.close();} catch (Exception e2) {}
//			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
//			if(con!=null) try { con.close();} catch (Exception e2) {}
//		}
//		return dealListB;
//	}
	
	//================like===========================================
	
	//likePro_insertlike
	public void insertlike(int S_num, String M_id) {
		Connection con = null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
		
			int Like_id=1;
			String sql ="select max(Like_id) from likes";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Like_id=rs.getInt("max(Like_id)")+1;}
			
			sql="insert into likes(Like_id,S_num,M_id) values(?,?,?)";
			pstmt=con.prepareStatement(sql);	
			pstmt.setInt(1,Like_id);
			pstmt.setInt(2, S_num);
			pstmt.setString(3, M_id);			
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

	
	//likelist
//	public ArrayList<SellDTO> likeHistory(String M_id) {
//		ArrayList<SellDTO> likeHistory=new ArrayList<SellDTO>();
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		try {
//			con=getConnection();
//			String sql= "select s.S_num, s.M_id, s.S_category, s.S_title, s.S_text, s.S_price from sell s join likes l on s.S_num=l.S_num where l.M_id=?"; 
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, M_id);
//			rs=pstmt.executeQuery();
//			while(rs.next()) {
//				SellDTO dto=new SellDTO();
//				dto.setS_num(rs.getInt("S_num"));
//				dto.setM_id(rs.getString("M_id"));
//				dto.setS_category(rs.getString("S_category"));
//				dto.setS_title(rs.getString("S_title"));
//				dto.setS_text(rs.getString("S_text"));
//				dto.setS_price(rs.getInt("S_price"));
//			
//				likeHistory.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(con!=null) try {con.close();} catch (Exception e2) {}
//			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
//			if(rs!=null) try {rs.close();} catch (Exception e2) {}
//		}
//		return likeHistory;
//	}

	
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
	
	
	
	
	
	//===========================글 쓴 내역

	
	public ArrayList<BuyDTO> WriteHistoryB2(String M_id){
		ArrayList<BuyDTO> WriteHistoryB2=new ArrayList<BuyDTO>();
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from buy where M_id=? and date(b_time)>=date(now())-2";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				
				BuyDTO dto=new BuyDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setB_num(rs.getInt("B_num"));
				dto.setB_category(rs.getString("B_category"));
				dto.setB_title(rs.getString("B_title"));
				dto.setB_text(rs.getString("B_text"));
				dto.setB_view(rs.getInt("B_view"));
				dto.setB_img(rs.getString("B_img"));
			
				
				WriteHistoryB2.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return WriteHistoryB2;
	}
	
	public ArrayList<SellDTO> WriteHistoryS2(String M_id){
		ArrayList<SellDTO> WriteHistoryS2=new ArrayList<SellDTO>();
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from sell where M_id=? and date(S_createdate)>=date(now())-2";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setS_price(rs.getInt("S_price"));
				dto.setM_id(rs.getString("M_id"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_text(rs.getString("S_text"));
				dto.setS_like(rs.getInt("S_like"));
				dto.setS_view(rs.getInt("S_view"));
				dto.setS_category(rs.getString("S_category"));
				dto.setS_send1(rs.getString("S_send1"));	
				dto.setS_send2(rs.getString("S_send2"));
				dto.setS_createdate(rs.getTimestamp("S_createdate"));
				dto.setS_category(rs.getString("S_category"));
				
				WriteHistoryS2.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return WriteHistoryS2;
	}
	
	
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
				dto.setS_price(rs.getInt("S_price"));
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
	
	public ArrayList<SellDTO> likeList(int startRow, int pageSize,String M_id) {
		ArrayList<SellDTO> likeList=new ArrayList<SellDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql= "select s.S_num, s.M_id, s.S_category, s.S_title, s.S_text, s.S_price from sell s join likes l on s.S_num=l.S_num where l.M_id=?  order by S_num desc limit ?,?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setS_category(rs.getString("S_category"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_text(rs.getString("S_text"));
				dto.setS_price(rs.getInt("S_price"));
			
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
	
	//구매리스트
	public ArrayList<DealDTO> dealListB1(int startRow, int pageSize,String M_id) {
		ArrayList<DealDTO> dealListB1=new ArrayList<DealDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql= "select * from deal where D_play='거래완료' and D_buy=? order by S_num desc limit ?,?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DealDTO dto=new DealDTO();
				dto.setD_num(rs.getInt("D_num"));
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setD_buy(rs.getString("D_buy"));
				dto.setD_date(rs.getTimestamp("D_date"));
				
				dealListB1.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return dealListB1;
	}
	
	//구매리스트
	public ArrayList<SellDTO> dealListS1(int startRow, int pageSize,String M_id) {
		ArrayList<SellDTO> dealListS1=new ArrayList<SellDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql= "select * from sell where S_num in ( select S_num from deal where D_buy=?) order by S_num desc limit ?,?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setS_category(rs.getString("S_category"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_text(rs.getString("S_text"));
				dto.setS_price(rs.getInt("S_price"));
				
				dealListS1.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return dealListS1;
	}
	
	//판매리스트 
	public ArrayList<DealDTO> dealHistory1(int startRow, int pageSize,String M_id) {
		ArrayList<DealDTO> dealHistory1=new ArrayList<DealDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql= "select * from deal where D_play='거래완료' and  M_id in (select M_id from sell where M_id=?) order by S_num desc limit ?,?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				DealDTO dto=new DealDTO();
				dto.setD_num(rs.getInt("D_num"));
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setD_buy(rs.getString("D_buy"));
				dto.setD_date(rs.getTimestamp("D_date"));
			
				dealHistory1.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return dealHistory1;
	}
	
	//판매리스트
	public ArrayList<SellDTO> sellHistory1(int startRow, int pageSize,String M_id) {
		ArrayList<SellDTO> sellHistory1=new ArrayList<SellDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql= ("select * from sell where M_id in ( select M_id from deal where M_id=?)  order by S_num desc limit ?,?"); 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setS_category(rs.getString("S_category"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_text(rs.getString("S_text"));
				dto.setS_price(rs.getInt("S_price"));
			
				sellHistory1.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return sellHistory1;
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
			
			String sql="select count(*) from like where M_id=?";
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
	
	
	//연습
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


package com.itwillbs.sell.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class SellDAO {
	
	public Connection getConnection() throws Exception{
			Context init=new InitialContext();
			DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
			Connection con=ds.getConnection();
			return con;
		}//getConnection() 끝
	
	public void insertSellBoard(SellDTO dto) {		
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			try {
				con = getConnection();
				int S_num = 1;
				String sql="select max(S_num) from sell";
				
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					// 현존하는 최대 num에서 +1한 값을 num으로서 사용
					S_num = rs.getInt("max(S_num)") + 1;
				}
				
				sql="insert into sell(S_num,M_id,S_title,S_price,S_text,S_like,S_view,S_send1,S_send2,S_sido1,S_gugun1,S_createdate,S_category,S_img)"
						+ "value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, S_num);  
				pstmt.setString(2, dto.getM_id()); 
				pstmt.setString(3, dto.getS_title());
				pstmt.setInt(4, dto.getS_price());
				pstmt.setString(5, dto.getS_text());
				pstmt.setInt(6, dto.getS_like());
				pstmt.setInt(7, dto.getS_view());
				pstmt.setString(8, dto.getS_send1());
				pstmt.setString(9, dto.getS_send2());
				pstmt.setString(10, dto.getS_sido1());
				pstmt.setString(11, dto.getS_gugun1());
				pstmt.setTimestamp(12, dto.getS_createdate());
				pstmt.setString(13, dto.getS_category());
				pstmt.setString(14, dto.getS_img());
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
				if(con!=null) try { con.close();} catch (Exception e2) {}
			}
			return;
		} //insertSellBoard 끝 (글번호 부여하면서 입력된 내용을 등록)
	
	public ArrayList<SellDTO> getsellList(int startRow, int pageSize){
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<SellDTO> sellList=new ArrayList<SellDTO>();
		try {
			con=getConnection();
			String sql="select * from sell order by S_num desc limit ?, ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
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
				
				sellList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return sellList;
	} // sellList 끝 (메인 글목록에서 사용)
	
	public ArrayList<SellDTO> getsellOuterList(int startRow, int pageSize){
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<SellDTO> sellOuterList=new ArrayList<SellDTO>();
		try {
			con=getConnection();
			String sql="select * from sell where S_category = 'outer' order by S_num desc limit ?, ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
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
				
				sellOuterList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return sellOuterList;
	} // sellOuterList 끝 (outer 글목록에서 사용)
	
	public ArrayList<SellDTO> getsellShirtsList(int startRow, int pageSize){
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<SellDTO> sellShirtsList=new ArrayList<SellDTO>();
		try {
			con=getConnection();
			String sql="select * from sell where S_category = 'shirts' order by S_num desc limit ?, ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
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
				
				sellShirtsList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return sellShirtsList;
	} // sellShirtsList 끝 (Shirts 글목록에서 사용)
	
	public ArrayList<SellDTO> getsellPantsList(int startRow, int pageSize){
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<SellDTO> sellPantsList=new ArrayList<SellDTO>();
		try {
			con=getConnection();
			String sql="select * from sell where S_category = 'pants' order by S_num desc limit ?, ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
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
				
				sellPantsList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return sellPantsList;
	} // sellPantsList 끝 (Pants 글목록에서 사용)
	
	public ArrayList<SellDTO> getsellDressList(int startRow, int pageSize){
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		ArrayList<SellDTO> sellDressList=new ArrayList<SellDTO>();
		try {
			con=getConnection();
			String sql="select * from sell where S_category = 'dress' order by S_num desc limit ?, ?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
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
				
				sellDressList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return sellDressList;
	} // sellDressList 끝 (Dress 글목록에서 사용)
	
	public int getSellBoardCount() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select count(*) from sell";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return count;
	} // getSellBoardCount (페이징에서 사용)
	
	public SellDTO getSellBoard(int S_num){
		
		boardCnt(S_num);
		
		SellDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from sell where S_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,S_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new SellDTO();
				//TO.승민 **여기서 상세게시글에 출력되는 결과만 남기고 지울것! **
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
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
			}else {
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return dto;
		
	} // getSellBoard 끝 (상세게시글 볼 때 사용)
	
	public void boardCnt(int S_num) {            // 게시판 조회수
	     
        Connection con = null;
		PreparedStatement pstmt = null;
     	        
        try {
        	con = getConnection();
			String sql = "update sell SET S_view =(S_view+1) where S_num = ?";
			pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, S_num);
            pstmt.executeUpdate();
            	            
        } catch (Exception e) {
            e.printStackTrace();
          }
 
    }
	
	public ArrayList<SellDTO> sellHistory(String M_id){
		ArrayList<SellDTO> sellHistory=new ArrayList<SellDTO>();
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from sell where M_id=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				
				SellDTO dto=new SellDTO();
				dto.setS_num(rs.getInt("S_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_text(rs.getString("S_text"));
				dto.setS_like(rs.getInt("S_like"));
				dto.setS_view(rs.getInt("S_view"));
				dto.setS_send1(rs.getString("S_send1"));	
				dto.setS_send2(rs.getString("S_send2"));
				dto.setS_createdate(rs.getTimestamp("S_createdate"));
				dto.setS_category(rs.getString("S_category"));
				
				sellHistory.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return sellHistory;
	} //sellHistory 끝
	
	
	
	
	//구매내역 수정해야함..
	public ArrayList<SellDTO> dealListS(String M_id){ 
		ArrayList<SellDTO> dealListS=new ArrayList<SellDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = getConnection();
			String sql="select s.M_id, s.S_title, s.S_price"
					+ "from sell s join deal d"
					+ "on s.M_id=d.M_id"
					+ "where d.D_buy=?";				
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			
			rs=pstmt.executeQuery();	

			while(rs.next()) {
				
				SellDTO dto=new SellDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setS_title(rs.getString("S_title"));
				dto.setS_price(rs.getInt("S_price"));		
				dto.setS_category(rs.getString("S_category"));
				
				dealListS.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return dealListS;
	} // dealListS 끝 구매내역
	
	public void updateSellBoard(SellDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update sell set S_title=?, S_price=?, S_category=?, S_text=?, S_send1=?, S_send2=?, S_sido1=?, S_gugun1=?, S_img=? where S_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getS_title());
			pstmt.setInt(2, dto.getS_price());
			pstmt.setString(3, dto.getS_category());
			pstmt.setString(4, dto.getS_text());
			pstmt.setString(5, dto.getS_send1());
			pstmt.setString(6, dto.getS_send2());
			pstmt.setString(7, dto.getS_sido1());
			pstmt.setString(8, dto.getS_gugun1());
			pstmt.setString(9, dto.getS_img());
			pstmt.setInt(10, dto.getS_num());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con!=null) try { con.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
		}
		
	} //update 수정 (제목, 내용, 카테고리, 거래유형, 시도, 구군, 이미지 변경가능)
	
	public void deleteLikeSellBoard(int S_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//	찜 삭제 먼저
			try {
				con = getConnection();
				String sql = "delete from likes where S_num = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, S_num);
				pstmt.executeUpdate();
				
				System.out.println("like canceled");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
				if(con!=null) try { con.close();} catch (Exception e2) {}
			}
	}//	찜 삭제
	
	public void deleteSellBoard(int S_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = getConnection();
			String sql2 = "delete from sell where S_num=?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, S_num);
			pstmt.executeUpdate();
			
			System.out.println("sell post deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
	} //delete (글삭제)
	

	//검색리스트
		public ArrayList<SellDTO> getsellSearch(int startRow, int pageSize,String search){
			Connection con =null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			ArrayList<SellDTO> getsellSearch=new ArrayList<SellDTO>();
			try {
				con=getConnection();
				String sql = "SELECT * FROM SELL WHERE S_TITLE LIKE ? order by S_num desc limit ?,?" ;
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, "%"+search+"%");
				pstmt.setInt(2, startRow-1);
				pstmt.setInt(3, pageSize);
				
				
				rs=pstmt.executeQuery();	

				while(rs.next()) {
					SellDTO dto=new SellDTO();
					dto.setS_num(rs.getInt("S_num"));
					dto.setM_id(rs.getString("M_id"));
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
					
					getsellSearch.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				
				if(rs!=null) try { rs.close();} catch (Exception e2) {}
				if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
				if(con!=null) try { con.close();} catch (Exception e2) {}
			}
			return getsellSearch;
		} 

	
}



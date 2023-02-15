package com.itwillbs.buy.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class BuyDAO {
	public Connection getConnection() throws Exception{
		Context init=new InitialContext();
		DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
		Connection con=ds.getConnection();
		return con;
	} //getConnection (DB연결)

	public void insertBuyBoard(BuyDTO dto) {		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = getConnection();
			int B_num = 1;
			String sql="select max(B_num) from buy";
			
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				// 현존하는 최대 num에서 +1한 값을 num으로서 사용
				B_num = rs.getInt("max(B_num)") + 1;
			}
			
			sql="insert into Buy(M_id, B_num, B_category, B_title, B_text, B_send1, B_send2, B_sido1, B_gugun1, B_view, B_time, B_img)"
		               + "value(?,?,?,?,?,?,?,?,?,?,?,?)";
		         pstmt=con.prepareStatement(sql);
		         pstmt.setString(1, dto.getM_id());  
		         pstmt.setInt(2, B_num); 
		         pstmt.setString(3, dto.getB_category()); 
		         pstmt.setString(4, dto.getB_title()); 
		         pstmt.setString(5, dto.getB_text());
		         pstmt.setString(6, dto.getB_send1());
		         pstmt.setString(7, dto.getB_send2());
		         pstmt.setString(8, dto.getB_sido1());
		         pstmt.setString(9, dto.getB_gugun1());
		         pstmt.setInt(10, dto.getB_view()); 
		         pstmt.setTimestamp(11, dto.getB_time());
		         pstmt.setString(12, dto.getB_img());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return;
	} //insertBuyBoard (글번호 부여하면서 입력된 내용을 등록)
	
	
	public ArrayList<BuyDTO> getList(int startRow, int pageSize){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BuyDTO> buyList=new ArrayList<BuyDTO>();
	
		try {
			con = getConnection();
			String sql = "select * from buy order by B_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			// 다음으로 작성될 글의 번호 : getNext, 
			// 현재 게시글이 5개라면 getNext = 6, 
			// pageNumber = 6-(1-1)*10
			rs = pstmt.executeQuery();

			while(rs.next()) {
				BuyDTO dto = new BuyDTO();
				dto.setB_num(rs.getInt("B_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setB_category(rs.getString("B_category"));
				dto.setB_text(rs.getString("B_text"));
				dto.setB_send1(rs.getString("B_send1"));
				dto.setB_send2(rs.getString("B_send2"));
				dto.setB_sido1(rs.getString("B_sido1"));
				dto.setB_gugun1(rs.getString("B_gugun1"));
				dto.setB_title(rs.getString("B_title"));
				dto.setB_time(rs.getTimestamp("B_time"));
				dto.setB_view(rs.getInt("B_view"));
				dto.setB_img(rs.getString("B_img"));
				
				buyList.add(dto);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		return buyList;
	} //getList (startRow, pageSize) (글목록에서 사용)
	
	public int getBuyBoardCount() {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select count(*) from buy";
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
		
	} //getBuyBoardCount (페이징에서 사용)
	
	public BuyDTO getBuyBoard(int B_num){
		
		boardCnt(B_num);
		
		System.out.println("getBuyBoard");
		BuyDTO dto = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			String sql = "select * from buy where B_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,B_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BuyDTO();
				dto.setB_num(rs.getInt("B_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setB_category(rs.getString("B_category"));
				dto.setB_text(rs.getString("B_text"));
				dto.setB_send1(rs.getString("B_send1"));
				dto.setB_send2(rs.getString("B_send2"));
				dto.setB_sido1(rs.getString("B_sido1"));
				dto.setB_gugun1(rs.getString("B_gugun1"));
				dto.setB_title(rs.getString("B_title"));
				dto.setB_time(rs.getTimestamp("B_time"));
				dto.setB_view(rs.getInt("B_view"));
				dto.setB_img(rs.getString("B_img"));
				
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
		
	} // getBuyBoard (상세글읽기에서 사용)
	
	public void boardCnt(int B_num) {            // 게시판 조회수
	     
        Connection con = null;
		PreparedStatement pstmt = null;
     	        
        try {
        	con = getConnection();
			String sql = "update buy SET B_view =(B_view+1) where B_num = ?";
			pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, B_num);
            pstmt.executeUpdate();
            	            
        } catch (Exception e) {
            e.printStackTrace();
          }
 
    }
	
	public void updateBuyBoard(BuyDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String sql = "update buy set B_title=?, B_category=?, B_text=?, B_send1=?, B_send2=?, B_sido1=?, B_gugun1=?, B_img=? where B_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getB_title());
			pstmt.setString(2, dto.getB_category());
			pstmt.setString(3, dto.getB_text());
			pstmt.setString(4, dto.getB_send1());
			pstmt.setString(5, dto.getB_send2());
			pstmt.setString(6, dto.getB_sido1());
			pstmt.setString(7, dto.getB_gugun1());
			pstmt.setString(8, dto.getB_img());
			pstmt.setInt(9, dto.getB_num());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(con!=null) try { con.close();} catch (Exception e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
		}
		
	} //update 수정 (제목, 내용, 카테고리, 거래유형, 시도, 구군, 이미지 변경가능)
	
	public void deleteBuyBoard(int B_num) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//	댓글 삭제	먼저
		try {
			con = getConnection();
			String sql = "delete from comment where B_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, B_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
		
		// 그 다음 게시글 삭제
		try {
			con = getConnection();
			String sql = "delete from buy where B_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, B_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
			if(con!=null) try { con.close();} catch (Exception e2) {}
		}
	} //delete (글삭제)
	
}

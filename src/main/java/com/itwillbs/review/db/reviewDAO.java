package com.itwillbs.review.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class reviewDAO {

	public Connection getConnection() throws Exception{

		Context init = new InitialContext();
	    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
	    Connection con = ds.getConnection();
	    return con;
	} // getConnection끝
	
	
	public void insertreview(reviewDTO dto) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			con=getConnection();
			
			//게시판 번호 자동 넘버링
			int rE_id=1;
			String sql= "select max(RE_num) from review";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				rE_id=rs.getInt("max(RE_num)")+1;
			}
			
			
			//게시판 DB입력
			
			sql = "insert into review(RE_num,S_id,RE_writer,RE_title,RE_text,RE_createtime,RE_view,"
					+ "RE_img1,RE_delivery,RE_manner,RE_ProductStatus,RE_fast,RE_time) value (?,?,?,?,?,?,?,?,?,?,?,?,?)";//13개
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, rE_id);
			pstmt.setInt(2, 1);//test값 (판매번호)
			pstmt.setString(3, dto.getRE_writer());
			pstmt.setString(4, dto.getRE_title());
			pstmt.setString(5, dto.getRE_text());
			pstmt.setTimestamp(6, dto.getRE_createtime());
			pstmt.setInt(7, dto.getRE_view());
			pstmt.setString(8, dto.getRE_img1());
			pstmt.setString(9, dto.getRE_delivery());
			pstmt.setString(10, dto.getRE_manner());
			pstmt.setString(11, dto.getRE_ProductStatus());
			pstmt.setString(12, dto.getRE_fast());
			pstmt.setString(13, dto.getRE_time());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {e2.printStackTrace();}
			if(con!=null) try {con.close();} catch (Exception e2) {e2.printStackTrace();}
			if(rs!=null) try {rs.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}//reviewWriteBoard 끝 (리뷰글쓰기)
	
	
	public ArrayList<reviewDTO> getReviewList(int startRow,int pageSize){
		
		System.out.println("reviewDTO getReviewList");
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		ArrayList<reviewDTO> reviewList = new ArrayList<>();
		
		try {
			con = getConnection();
			
			String sql="select * from review order by RE_num desc limit ?,?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			rs=pstmt.executeQuery();                      
			
			while(rs.next()) {
				reviewDTO dto = new reviewDTO();
				dto.setRE_num(rs.getInt("RE_num"));
				dto.setRE_img1(rs.getString("RE_img1"));
				dto.setRE_title(rs.getString("RE_title"));
				dto.setRE_createtime(rs.getTimestamp("RE_createtime"));
				dto.setRE_view(rs.getInt("RE_view"));
				dto.setRE_writer(rs.getString("RE_writer"));
				dto.setRE_text(rs.getString("RE_text"));
				dto.setRE_delivery(rs.getString("RE_delivery"));
				dto.setRE_manner (rs.getString("RE_manner"));
				dto.setRE_ProductStatus(rs.getString("RE_ProductStatus"));
				dto.setRE_fast(rs.getString("RE_fast"));
				dto.setRE_time(rs.getString("RE_time"));
				dto.setRE_writer(rs.getString("RE_writer"));
				
				reviewList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		
		return reviewList;
	} //getReviewList() 끝 (리스트 가져오기)
	
	
	
	
	public reviewDTO getBoard(int RE_num) {
		
		reviewDTO dto = null;
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		try {
			
			con = getConnection();
			String sql = "select * from review where num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, RE_num);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				dto=new reviewDTO();
				dto.setRE_img1(rs.getString("RE_img1"));
				dto.setRE_title(rs.getString("RE_title"));
				dto.setRE_writer(rs.getString("RE_writer"));
				dto.setRE_createtime(rs.getTimestamp("RE_createtime"));
				dto.setRE_view(rs.getInt("RE_view"));
				dto.setRE_text(rs.getString("RE_text"));
				dto.setRE_delivery(rs.getString("RE_delivery"));
				dto.setRE_manner (rs.getString("RE_manner"));
				dto.setRE_ProductStatus(rs.getString("RE_ProductStatus"));
				dto.setRE_fast(rs.getString("RE_fast"));
				dto.setRE_time(rs.getString("RE_time"));
				dto.setRE_writer(rs.getString("RE_writer"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		
		return dto;
	} // getBoard() 끝 (게시글 내용 가져오기)  
	
	 public int getreviewCount() {
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			int count=0;
			
			try {
				
				con=getConnection();
				
				String sql ="select count(*) from review";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()) {
					count=rs.getInt("count(*)");
				}
			}  catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(rs!=null) try { rs.close();} catch (Exception e2) {}
				if(pstmt!=null) try { pstmt.close();} catch (Exception e2) {}
				if(con!=null) try { con.close();} catch (Exception e2) {}		
			}
		 return count;
	 } // getreviewCount 페이징처리
	
	
}

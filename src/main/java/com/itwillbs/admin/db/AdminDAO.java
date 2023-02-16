package com.itwillbs.admin.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.buy.db.BuyDTO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.report.db.ReportDTO;
import com.itwillbs.sell.db.SellDTO;

public class AdminDAO {
	
	public Connection getConnection() throws Exception {
	Context init=new InitialContext();
	DataSource ds=(DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
	Connection con=ds.getConnection();
	return con;
	}//getConnection()
	
	//    ----Member----
	public ArrayList<MemberDTO> adUserList(int startRow, int pageSize) {
		ArrayList<MemberDTO> adUserList=new ArrayList<MemberDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO dto=null;
		try {
			con=getConnection();
			String sql="select * from member order by M_play desc, M_id limit ?, ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto=new MemberDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setM_name(rs.getString("M_name"));
				dto.setM_nick(rs.getString("M_nick"));
				dto.setM_createdate(rs.getTimestamp("M_createdate"));
				dto.setM_play(rs.getString("M_play"));
				adUserList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adUserList;
	}//adUserList()
	
	public int adUserCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from member";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		} return count;
	}//adUserCount()
	
	public ArrayList<MemberDTO> adUserListPro(String info, String search) {
		ArrayList<MemberDTO> adUserListPro=new ArrayList<MemberDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from member where ";
			if(info.equals("M_id")) {sql+="M_id like ?";}
			else if(info.equals("M_name")) {sql+="M_name like ?";}
			else if(info.equals("M_nick")) {sql+="M_nick like ?";}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setM_name(rs.getString("M_name"));
				dto.setM_nick(rs.getString("M_nick"));
				dto.setM_createdate(rs.getTimestamp("M_createdate"));
				dto.setM_play(rs.getString("M_play"));
				adUserListPro.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adUserListPro;
	}//adUserListPro()
	
	public ArrayList<MemberDTO> adOutList(int startRow, int pageSize) {
		ArrayList<MemberDTO> adOutList=new ArrayList<MemberDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from member where M_play in ('탈퇴', '강퇴') order by M_id limit ?, ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setM_name(rs.getString("M_name"));
				dto.setM_nick(rs.getString("M_nick"));
				dto.setM_createdate(rs.getTimestamp("M_createdate"));
				dto.setM_play(rs.getString("M_play"));
				adOutList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adOutList;
	}//adOutList()
	
	public int adOutCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from member where M_play in ('탈퇴', '강퇴')";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		} return count;
	}//adOutCount()
	
	public ArrayList<MemberDTO> adOutListPro(String info, String search) {
		ArrayList<MemberDTO> adOutListPro=new ArrayList<MemberDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from member where M_play in ('탈퇴', '강퇴')";
			if(info.equals("M_id")) {sql+="and M_id like ?";}
			else if(info.equals("M_name")) {sql+="and M_name like ?";}
			else if(info.equals("M_nick")) {sql+="and M_nick like ?";}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto=new MemberDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setM_name(rs.getString("M_name"));
				dto.setM_nick(rs.getString("M_nick"));
				dto.setM_createdate(rs.getTimestamp("M_createdate"));
				dto.setM_play(rs.getString("M_play"));
				adOutListPro.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adOutListPro;
	}//adOutListPro()
	
	public ArrayList<ReportDTO> adUserReportList(int startRow, int pageSize) {
		ArrayList<ReportDTO> adUserReportList=new ArrayList<ReportDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from report order by R_type desc, M_id limit ?, ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ReportDTO dto=new ReportDTO();
				dto.setR_type(rs.getString("R_type"));
				dto.setM_id(rs.getString("M_id"));
				dto.setR_id(rs.getString("R_id"));
				dto.setR_reason(rs.getString("R_reason"));
				dto.setR_writeNum(rs.getString("R_writeNum"));
				dto.setR_category(rs.getString("R_category"));
				dto.setR_title(rs.getString("R_title"));
				adUserReportList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adUserReportList;
	}//adUserReportList()
	
	public int adUserReportCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select * from report order by R_type desc, M_id";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		} return count;
	}//adUserReportCount()
	
	public ArrayList<ReportDTO> adUserReportListPro(String info, String search) {
		ArrayList<ReportDTO> adUserReportListPro=new ArrayList<ReportDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from report where ";
			if(info.equals("M_id")) {sql+="M_id like ?";}
			else if(info.equals("M_name")) {sql+="M_name like ?";}
			else if(info.equals("M_nick")) {sql+="M_nick like ?";}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ReportDTO dto=new ReportDTO();
				dto.setR_type(rs.getString("R_type"));
				dto.setM_id(rs.getString("M_id"));
				dto.setR_id(rs.getString("R_id"));
				dto.setR_reason(rs.getString("R_reason"));
				dto.setR_writeNum(rs.getString("R_writeNum"));
				dto.setR_category(rs.getString("R_category"));
				dto.setR_title(rs.getString("R_title"));
				adUserReportListPro.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adUserReportListPro;
	}//adUserReportListPro()
	
	public void adUserDeletePro(String M_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="update member set M_play='강퇴' where M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, M_id);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		}
	}//adUserDeletePro()
		
	//    ----Sell----
	public ArrayList<SellDTO> adSellList(int startRow, int pageSize) {
		ArrayList<SellDTO> adSellList=new ArrayList<SellDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from sell order by S_createdate desc limit ?, ?";
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
				dto.setS_createdate(rs.getTimestamp("S_createdate"));
				dto.setS_category(rs.getString("S_category"));
				adSellList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adSellList;
	}//adSellList()
	
	public int adSellCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from sell";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		} return count;
	}//adSellCount()
	
	public void adSellDelete(int S_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="delete from sell where S_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, S_num);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		}
	}//adSellDelete()
		
		
	//    ----Buy----
	public ArrayList<BuyDTO> adBuyList(int startRow, int pageSize) {
		ArrayList<BuyDTO> adbuyList=new ArrayList<BuyDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select * from buy order by B_time desc limit ?, ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BuyDTO dto=new BuyDTO();
				dto.setB_num(rs.getInt("B_num"));
				dto.setM_id(rs.getString("M_id"));
				dto.setB_title(rs.getString("B_title"));
				dto.setB_time(rs.getTimestamp("B_time"));
				dto.setB_view(rs.getInt("B_view"));
				dto.setB_category(rs.getString("B_category"));
				adbuyList.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		}
		return adbuyList;
	}//adBuyList()
	
	public int adBuyCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from buy";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count(*)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
			if(rs!=null) try {rs.close();} catch (Exception e2) {}
		} return count;
	}//adBuyCount()
	
	public void adBuyDelete(int B_num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="delete from buy where B_num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, B_num);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		}
	}//adBuyDelete()
	
}//class
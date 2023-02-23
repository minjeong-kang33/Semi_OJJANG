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
import com.itwillbs.out.db.OutDTO;
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
		System.out.println("AdminDAO adUserList()");
		ArrayList<MemberDTO> adUserList=new ArrayList<MemberDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO dto=null;
		try {
			con=getConnection();
			String sql="select * from member where M_play not in ('탈퇴', '강퇴') and M_admin != 'M' order by M_play desc, M_id limit ?, ?";
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
	
	public ArrayList<MemberDTO> adUserList(int startRow, int pageSize, String info, String search) {
		ArrayList<MemberDTO> adUserList=new ArrayList<MemberDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		MemberDTO dto=null;
		String Uorder=" like ? order by M_play desc, M_id limit ?, ?";
		try {
			con=getConnection();
			String sql="select * from member where M_play not in ('탈퇴', '강퇴') and M_admin != 'M' and ";
			if(info.equals("M_id")) {sql+="M_id";}
			else if(info.equals("M_name")) {sql+="M_name";}
			else if(info.equals("M_nick")) {sql+="M_nick";}
			sql+=Uorder;
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
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
	}//adUserList(info, search)
	
	public int adUserCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from member where M_play not in ('탈퇴', '강퇴') and M_admin != 'M'";
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
	
	public int adUserCount(String info, String search) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from member where M_play not in ('탈퇴', '강퇴') and M_admin != 'M' and ";
			if(info.equals("M_id")) {sql+="M_id like ?";}
			else if(info.equals("M_name")) {sql+="M_name like ?";}
			else if(info.equals("M_nick")) {sql+="M_nick like ?";}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
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
	}//adUserCount(info, search)
	
	public ArrayList<OutDTO> adOutList(int startRow, int pageSize) {
		ArrayList<OutDTO> adOutList=new ArrayList<OutDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select m.M_id, m.M_nick, o.O_reason, o.O_outday, m.M_play from outs o right join member m on o.M_id=m.M_id where M_play in ('탈퇴', '강퇴') order by M_play desc, O_outday limit ?, ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OutDTO dto=new OutDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setM_nick(rs.getString("M_nick"));
				dto.setO_reason(rs.getString("O_reason"));
				dto.setO_outday(rs.getTimestamp("O_outday"));
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
	
	public ArrayList<OutDTO> adOutList(int startRow, int pageSize, String info, String search) {
		ArrayList<OutDTO> adOutList=new ArrayList<OutDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String Oorder=" like ? order by m.M_play desc, o.O_outday limit ?, ?";
		try {
			con=getConnection();
			String sql="select m.M_id, m.M_nick, o.O_reason, o.O_outday, m.M_play from outs o right join member m on o.M_id=m.M_id where m.M_play in ('탈퇴', '강퇴') and ";
			if(info.equals("M_id")) {sql+="m.M_id";}
			else if(info.equals("M_nick")) {sql+="m.M_nick";}
			sql+=Oorder;
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				OutDTO dto=new OutDTO();
				dto.setM_id(rs.getString("M_id"));
				dto.setM_nick(rs.getString("M_nick"));
				dto.setO_reason(rs.getString("O_reason"));
				dto.setO_outday(rs.getTimestamp("O_outday"));
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
	}//adOutList(info, search)
	
	public int adOutCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from outs o right join member m on o.M_id=m.M_id where M_play in ('탈퇴', '강퇴')";
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
	
	public int adOutCount(String info, String search) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from outs o right join member m on o.M_id=m.M_id where M_play in ('탈퇴', '강퇴') and ";
			if(info.equals("M_id")) {sql+="m.M_id like ?";}
			else if(info.equals("M_nick")) {sql+="m.M_nick like ?";}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
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
	}//adOutCount(info, search)
	
	public ArrayList<ReportDTO> adUserReportList(int startRow, int pageSize) {
		ArrayList<ReportDTO> adUserReportList=new ArrayList<ReportDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="select R_type, M_id, R_id, R_reason, R_category, R_writeNum, R_title, R_play from report order by R_play, R_writeNum limit ?, ?";
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
				dto.setR_play(rs.getString("R_play"));
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
	
	public ArrayList<ReportDTO> adUserReportList(int startRow, int pageSize, String info, String search) {
		ArrayList<ReportDTO> adUserReportList=new ArrayList<ReportDTO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String Rorder=" like ? order by R_play, R_writeNum limit ?, ?";
		try {
			con=getConnection();
			String sql="select R_type, M_id, R_id, R_reason, R_category, R_writeNum, R_title, R_play from report where ";
			if(info.equals("M_id")) {sql+="M_id";}
			else if(info.equals("R_id")) {sql+="R_id";}
			sql+=Rorder;
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startRow-1);
			pstmt.setInt(3, pageSize);
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
				dto.setR_play(rs.getString("R_play"));
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
	}//adUserReportList(info, search)
	
	public int adUserReportCount() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from report";
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
	
	public int adUserReportCount(String info, String search) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=getConnection();
			String sql="select count(*) from report where ";
			if(info.equals("M_id")) {sql+="M_id like ?";}
			else if(info.equals("R_id")) {sql+="R_id like ?";}
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
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
	}//adUserReportCount(info, search)
	
	public void adUserDeletePro(String M_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="update member set M_play='강퇴', M_pw=null where M_id=?";
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
	
	public void adOut(String M_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			int O_num=1;
			String sql ="select max(O_num) from outs";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				O_num=rs.getInt("max(O_num)")+1;
			}
			sql="insert into outs(O_num,M_id,O_reason) values(?,?,'강퇴')";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, O_num);
			pstmt.setString(2, M_id);
			pstmt.executeUpdate();	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		}
	}//adOut()
	
	public void adOut(OutDTO dto) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			int O_num=1;
			String sql ="select max(O_num) from outs";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				O_num=rs.getInt("max(O_num)")+1;
			}
			sql="insert into outs(O_num,M_id,O_reason) values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, O_num);
			pstmt.setString(2, dto.getM_id());
			pstmt.setString(3, dto.getO_reason());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		}
	}//adOut(dto)
	
	public void adUserReportDelete(String R_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="update member set M_play='강퇴', M_pw=null where M_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, R_id);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		}
	}//adUserReportDelete()
	
	public void adUserReportOut(String R_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=getConnection();
			String sql="update report set R_play='강퇴처리' where R_id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, R_id);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(con!=null) try {con.close();} catch (Exception e2) {}
			if(pstmt!=null) try {pstmt.close();} catch (Exception e2) {}
		}
	}//adUserReportOut()
		
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
				dto.setS_price(rs.getString("S_price"));
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
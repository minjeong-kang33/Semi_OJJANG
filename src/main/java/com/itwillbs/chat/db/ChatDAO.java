package com.itwillbs.chat.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

	
	
    
    public class ChatDAO {
    	
    	public Connection getConnection() throws Exception{
    		//서버에서 미리 1, 2 단계 => 디비연결 => 이름을 불러 연결정보를 가져오기
    		// => 속도 향상, 디비연결 정보 수정 최소화
    		// DataBase Connection Pool (DBCP)=> 디비 연결정보 서버 저장
    		// 1. META-INF context.xml (디비연결정보)
    		// 2. MemberDAO 디비연결정보 불러서 사용
    		Context init=new InitialContext();
    		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
    		Connection con=ds.getConnection();
    		return con;
    	}
        
    	
    
        //			ChatDTO 객체를 가져온다. 시, 분, 초 나타냄			
	public ArrayList<ChatDTO> getChatListByID(String fromID, String toID, String chatID) {
		ArrayList<ChatDTO> chatList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM CHAT WHERE ((fromID = ? AND toID =?) OR (fromID = ? AND toID = ?)) AND chatID > ? ORDER BY chatTime";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, fromID);
			pstmt.setString(2, toID);
			pstmt.setString(3, toID);
			pstmt.setString(4, fromID);
			pstmt.setInt(5, Integer.parseInt(chatID));
			rs = pstmt.executeQuery();
			chatList = new ArrayList<ChatDTO>();
			while (rs.next()) {
				ChatDTO chat = new ChatDTO();
				chat.setchatID(rs.getInt("chatID"));
				chat.setFromID(rs.getString("fromID").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chat.setToID(rs.getString("toID").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chat.setChatContent(rs.getString("chatContent").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int chatTime = Integer.parseInt(rs.getString("chatTime").substring(11, 13));
				String timeType = "오전";
				if(chatTime >= 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				if(chatTime == 12) {
					timeType = "오후";
				}
				chat.setChatTime(rs.getString("chatTime").substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getString("chatTime").substring(14, 16) + "");
				chatList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return chatList; // 리스트 반환
	}
	
	// 최신순으로 나타내는 sql 구문 빨리온걸 위쪽에 배치
	public ArrayList<ChatDTO> getChatListByRecent(String fromID, String toID, int number) {
		ArrayList<ChatDTO> chatList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM CHAT WHERE ((fromID = ? AND toID = ?) OR (fromID = ? AND toID = ?)) AND chatID > (SELECT MAX(chatID) - ? FROM CHAT WHERE (fromID = ? AND toID = ?) OR (fromID = ? AND toID = ?)) ORDER BY chatTime";                     
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fromID);
			pstmt.setString(2, toID);
			pstmt.setString(3, toID);
			pstmt.setString(4, fromID);
			pstmt.setInt(5, number);
			pstmt.setString(6, fromID);
			pstmt.setString(7, toID);
			pstmt.setString(8, toID);
			pstmt.setString(9, fromID);
			rs = pstmt.executeQuery();
			chatList = new ArrayList<ChatDTO>();
			while (rs.next()) {
				ChatDTO chat = new ChatDTO();
				chat.setchatID(rs.getInt("chatID"));
				chat.setFromID(rs.getString("fromID").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chat.setToID(rs.getString("toID").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chat.setChatContent(rs.getString("chatContent").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int chatTime = Integer.parseInt(rs.getString("chatTime").substring(11, 13));
				String timeType = "오전";
				if(chatTime >= 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getString("chatTime").substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getString("chatTime").substring(14, 16) + "");
				chatList.add(chat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return chatList; // 리스트 반환
	}
	
	//메세지함 getBox에 모든 맴버객체를 받는다.
	public ArrayList<ChatDTO> getBox(String M_id) {
		ArrayList<ChatDTO> chatList = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 나와 상대방 내용을 그룹으로 묶어서 대화 내용을 저장한다.
		String SQL = "SELECT * FROM CHAT WHERE chatID IN (SELECT MAX(chatID) FROM CHAT WHERE toID = ? OR fromID = ? GROUP BY fromID, toID)";                     
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, M_id);
			pstmt.setString(2, M_id);
			rs = pstmt.executeQuery();
			chatList = new ArrayList<ChatDTO>();
			while (rs.next()) {
				ChatDTO chat = new ChatDTO();
				chat.setchatID(rs.getInt("chatID"));
				chat.setFromID(rs.getString("fromID").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chat.setToID(rs.getString("toID").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				chat.setChatContent(rs.getString("chatContent").replaceAll(" ", "&nbsp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
				int chatTime = Integer.parseInt(rs.getString("chatTime").substring(11, 13));
				String timeType = "오전";
				if(chatTime >= 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getString("chatTime").substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getString("chatTime").substring(14, 16) + "");
				chatList.add(chat);
			}
			for(int i=0; i<chatList.size(); i++) {
				ChatDTO x = chatList.get(i);
				for(int j=0; j<chatList.size(); j++) {
					ChatDTO y = chatList.get(j);
					if(x.getFromID().equals(y.getToID()) && x.getToID().equals(y.getFromID())) {
						if(x.getChatID() < y.getChatID()) {
							chatList.remove(x);
							i--;
							break;
							// 10번째까지 저장하고 그 이상이 되면 break 시킨다.
						} else {
							chatList.remove(y);
							j--;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return chatList; // 리스트 반환
	}
	
	// 메신저 수신 읽음 처리  0은 안읽은거, 1은 읽은거
	public int submit(String fromID, String toID, String chatContent) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "INSERT INTO CHAT VALUES (NULL, ?, ?, ?, NOW(), 0)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, fromID);
			pstmt.setString(2, toID);
			pstmt.setString(3, chatContent);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1; // 데이터베이스 오류
	}
	
	// 받는사람입장에서 메세지를 받았다.
	public int readChat(String fromID, String toID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "UPDATE CHAT SET chatRead = 1 WHERE (fromID = ? AND toID = ?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, toID);
			pstmt.setString(2, fromID);
			return pstmt.executeUpdate(); // 반환한 결과를 업데이트한다.
		} catch (Exception e) {
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
		return -1; // 데이터베이스 오류
	}
			
	
	//읽지않는 메세지 모두 가져오는 매서드
	public int getAllUnreadChat(String M_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//읽지않는 전부 가져온다.
		String SQL = "SELECT COUNT(chatID) FROM CHAT WHERE toID = ? AND chatRead = 0";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, M_id);
			//실행한 결과를 가져온다.
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("COUNT(chatID)");
			}
			return 0; // 받은 메세지가 0이다.
		} catch (Exception e) {
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
		return -1; // 데이터베이스 오류
	}
	// 실시간으로 업데이트하는 매서드
	public int getUnreadChat(String fromID, String toID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = "SELECT COUNT(chatID) FROM CHAT WHERE fromID = ? AND toID = ? AND chatRead = 0";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, fromID);
			pstmt.setString(2, toID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("COUNT(chatID)");
			}
			return 0;
		} catch (Exception e) {
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
		return -1; // 데이터베이스 오류
	}
}

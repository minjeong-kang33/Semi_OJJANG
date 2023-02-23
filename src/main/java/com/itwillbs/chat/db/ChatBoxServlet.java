package com.itwillbs.chat.db;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;



@WebServlet("/ChatBoxServlet")
public class ChatBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");		
		String M_id = request.getParameter("M_id");
		if(M_id == null || M_id.equals("")) {
			response.getWriter().write("");
		} else {
			try {
				HttpSession session = request.getSession();
				if(!URLDecoder.decode(M_id, "UTF-8").equals((String) session.getAttribute("M_id"))) {
					response.getWriter().write("");
					return;
				}
				M_id = URLDecoder.decode(M_id, "UTF-8");
				response.getWriter().write(getBox(M_id));
			} catch (Exception e) {
				response.getWriter().write("");
			}
		}
	}  //기본 M_id 설정
	
	
	
	// getBox M_id를 담을 상자
	public String getBox(String M_id) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");
		ChatDAO chatDAO = new ChatDAO();
		ArrayList<ChatDTO> chatList = chatDAO.getBox(M_id);
		if(chatList.size() == 0) return "";
		for(int i=chatList.size()-1; i>=0; i--) {
			String unread = "";
			String M_Profile = null;
			if(M_id.equals(chatList.get(i).getToID())) {
				unread = chatDAO.getUnreadChat(chatList.get(i).getFromID(), M_id) + "";
				if(unread.equals("0")) unread = "";
			}
			if(M_id.equals(chatList.get(i).getToID())) {
				M_Profile = new MemberDAO().getProfile(chatList.get(i).getFromID());
			} else {
				M_Profile = new MemberDAO().getProfile(chatList.get(i).getToID());
			}
			result.append("[{\"value\": \"" + chatList.get(i).getFromID() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getToID() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatContent() + "\"},");
			result.append("{\"value\": \"" + chatList.get(i).getChatTime() + "\"},");
			result.append("{\"value\": \"" + unread + "\"},");
			result.append("{\"value\": \"" + M_Profile + "\"}]");
			if(i != 0) result.append(",");
		}
		result.append("], \"last\":\"" + chatList.get(chatList.size() - 1).getChatID() + "\"}");
		return result.toString();
	}

}

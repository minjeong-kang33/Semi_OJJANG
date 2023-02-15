package com.itwillbs.chat.db;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChatUnreadServlet")
public class ChatUnreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");		
		String M_id = request.getParameter("M_id");
		if(M_id == null || M_id.equals("")) {
			response.getWriter().write("0");
		} else {
			HttpSession session = request.getSession();
			if(!URLDecoder.decode(M_id, "UTF-8").equals((String) session.getAttribute("M_id"))) {
				response.getWriter().write("");
				return;
			}
			response.getWriter().write(new ChatDAO().getAllUnreadChat(M_id) + "");
		}
	}

}
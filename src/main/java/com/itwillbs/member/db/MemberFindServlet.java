package com.itwillbs.member.db;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MemberFindServlet")
public class MemberFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String M_id = request.getParameter("M_id");
		if(M_id == null || M_id.equals("")) {
			response.getWriter().write("-1");
		} else if(new MemberDAO().registerCheck(M_id) == 0) {
			try {
				response.getWriter().write(find(M_id));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("-1");
			}
		} else {
			response.getWriter().write("-1");
		}
	}
	
	
	public String find(String M_id) throws Exception {
		StringBuffer result = new StringBuffer("");
		result.append("{\"M_id\":\"" + new MemberDAO().getMember(M_id) + "\"}");
		return result.toString();
	}
}

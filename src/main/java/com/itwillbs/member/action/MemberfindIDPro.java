package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberfindIDPro implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberfindIDPro.me execute()");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		PrintWriter out = response.getWriter();
		String M_name = request.getParameter("M_name");
		String M_email = request.getParameter("M_email");
		String M_pw = dao.randomPasswd(10);
		dto.setM_name(M_name);
		dto.setM_email(M_email);
		String M_id = dao.findID(M_name, M_email);
		ActionForward forward = new ActionForward();
		if (M_id != null) {
			out.println("<form action=\"MembersendPw.me?M_id="+M_id+"&M_pw"+M_pw+"\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"M_email\" id=\"M_email\" value=\""+M_email+"\">");
		    out.println("<input type=\"hidden\" name=\"M_pw\" id=\"M_pw\" value=\""+M_pw+"\">");
		    out.println("<input type=\"hidden\" name=\"M_id\" id=\"M_id\" value=\""+M_id+"\">");
	        out.println("회원님의 아이디는 "+M_id+" 입니다.<br><br>");
	        out.println("임시 비밀번호를 발급 받으시겠습니까?<br><br>");
	        out.println("<input type=\"submit\" value=\"발급\" class=\"btn btn-danger\">");
	        out.println("</form>");
	  
		} else {
			
			out.println("<p>일치하는 정보가 없습니다</p>");
			out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
		
		}
		return forward;
	}
}

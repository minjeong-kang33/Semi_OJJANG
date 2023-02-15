package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;


public class MemberLoginPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginPro execute()");
		
		request.setCharacterEncoding("utf-8");
		String M_id = request.getParameter("M_id");
		String M_pw = request.getParameter("M_pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.M_userCheck(M_id, M_pw);
		
		ActionForward forward = null;
		
		if(M_id.equals("admin")&&(M_pw.equals("1234"))){
			response.sendRedirect("../admin/admain_test.jsp");
			} else if (dto != null) {
			HttpSession session=request.getSession();
			session.setAttribute("M_id", M_id);
			
			forward = new ActionForward();
			forward.setPath("home/main.jsp");
			forward.setRedirect(false);
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디와 비밀번호가 다릅니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			forward = null;
		}
		return forward;
	}
	
}
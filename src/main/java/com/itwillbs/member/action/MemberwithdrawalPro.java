package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberwithdrawalPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String M_id=request.getParameter("M_id");
		String M_pw=request.getParameter("M_pw");
		MemberDAO dao=new MemberDAO();
		MemberDTO dto=dao.M_userCheck(M_id, M_pw);
		ActionForward forward=null;
		if(dto!=null) {
			dao.DeleteMember(M_id);
			HttpSession session=request.getSession();
			session.invalidate();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			forward=new ActionForward();
			forward.setPath("Main.me");
			forward.setRedirect(true);
		}else{
			// id,pass 틀림
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 비밀번호가 틀립니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			

			forward=null;
		}
		
		return forward;
	}
}

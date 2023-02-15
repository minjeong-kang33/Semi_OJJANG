package com.itwillbs.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class PwUpdatePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		String M_id=request.getParameter("M_id");
		String M_pw=request.getParameter("M_pw");
		String M_pw2=request.getParameter("M_pw2");

		MemberDTO updatePwDto=new MemberDTO();
		updatePwDto.setM_id(M_id);
		updatePwDto.setM_pw(M_pw2);
		
		MemberDAO dao=new MemberDAO();

		MemberDTO dto=dao.M_userCheck(M_id, M_pw);
		
		ActionForward forward=null;
		if(dto!=null) {
			dao.updatePw(updatePwDto);
			forward=new ActionForward();
			forward.setPath("MemberMain.me");
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
			forward=null;
		}
		return null;
	}

}

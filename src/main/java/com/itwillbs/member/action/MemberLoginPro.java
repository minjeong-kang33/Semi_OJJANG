package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
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
		String checkbox= request.getParameter("checkbox");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.M_userCheck(M_id, M_pw);
		String M_play=dao.M_playCheck(M_id);
		
		ActionForward forward = null;
		
		if (dto!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("M_id", M_id);
			
			forward = new ActionForward();
			forward.setPath("Main.me");
			forward.setRedirect(true);
			//}
		} else if("탈퇴".equals(M_play)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('탈퇴 회원입니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			forward = null;
		} else if("강퇴".equals(M_play)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('강퇴 회원입니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			forward = null;	
		} else{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('아이디와 비밀번호가 다릅니다.');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				forward = null;
			}
		Cookie cookie = new Cookie("M_id", M_id);// 일단 쿠키 생성
		System.out.println(checkbox);
		if (checkbox != null) { // 체크박스 체크여부에 따라 쿠키 저장 확인
			cookie.setMaxAge(60*60*24*5);
			response.addCookie(cookie);
		} else {
		}	
		return forward;
	}
	
}
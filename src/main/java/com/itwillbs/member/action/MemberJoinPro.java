package com.itwillbs.member.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberJoinPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberJoinPro execute()");
		
		request.setCharacterEncoding("utf-8");
		String M_id=request.getParameter("M_id");
		String M_pw=request.getParameter("M_pw");
		String M_name=request.getParameter("M_name");
		String M_nick=request.getParameter("M_nick");
		String M_gender=request.getParameter("M_gender");
		String M_phone=request.getParameter("M_phone");
		String M_address=request.getParameter("M_address");
		String M_address2=request.getParameter("M_address2");
		String M_email=request.getParameter("M_email");
		Timestamp M_createdate=new Timestamp(System.currentTimeMillis());
		

		MemberDTO dto=new MemberDTO();

		dto.setM_id(M_id);
		dto.setM_pw(M_pw);
		dto.setM_name(M_name);
		dto.setM_nick(M_nick);
		dto.setM_gender(M_gender);
		dto.setM_phone(M_phone);
		dto.setM_address(M_address);
		dto.setM_address2(M_address2);
		dto.setM_email(M_email);
		dto.setM_createdate(M_createdate);
		

		MemberDAO dao=new MemberDAO();
		dao.insertMembers(dto);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('회원가입이 완료되었습니다.');");
		out.println("location.href='MemberLoginForm.me'");
		out.println("</script>");
		out.close();
		return null;
	}

}

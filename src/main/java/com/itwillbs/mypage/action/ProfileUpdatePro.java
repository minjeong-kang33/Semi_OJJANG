package com.itwillbs.mypage.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class ProfileUpdatePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//폼에서 입력한 내용이 서버에 전달 => request 내장객체 저장
		//request 한글처리
		request.setCharacterEncoding("utf-8");
		
		//request 태그이름에 해당하는 값을 가져오기 => 변수에 저장(id, pass, name)
		String M_id=request.getParameter("M_id");
		String M_name=request.getParameter("M_name");
		String M_pw=request.getParameter("M_pw");
		String M_nick=request.getParameter("M_nick");
		String M_phone=request.getParameter("M_phone");
		String M_address=request.getParameter("M_address");
		String M_address2=request.getParameter("M_address2");
		String M_email=request.getParameter("M_email");
		
		//수정할 내용을 바구니 객체생성 => 바구니에 저장
		MemberDTO updateDto=new MemberDTO();
		updateDto.setM_id(M_id);
		updateDto.setM_name(M_name);
		updateDto.setM_nick(M_nick);
		updateDto.setM_phone(M_phone);
		updateDto.setM_address(M_address);
		updateDto.setM_address2(M_address2);
		updateDto.setM_email(M_email);

		MemberDAO dao=new MemberDAO();
		MemberDTO dto=dao.M_userCheck(M_id, M_pw);
		
		ActionForward forward=null;
		if(dto!=null) {
			dao.updateMember(updateDto);
			forward=new ActionForward();
			forward.setPath("Membermain.me");
			forward.setRedirect(true);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
			forward=null;
		}
		return forward;
	}

}

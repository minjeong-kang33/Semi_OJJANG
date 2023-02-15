package com.itwillbs.mypage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class ProfileUpdateForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		
		MemberDAO dao=new MemberDAO();
		MemberDTO dto=dao.getMember(M_id);
		
		// dto 정보 들고가기(request 정보를 담아가기)
		request.setAttribute("dto", dto);
		
		// member/updateForm.jsp 주소 변경없이(false) 이동
		ActionForward forward=new ActionForward();
		forward.setPath("Mypage/profileUpdate.jsp");
		forward.setRedirect(false);
		return forward;
	}
}



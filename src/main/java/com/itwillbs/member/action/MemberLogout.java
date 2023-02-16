package com.itwillbs.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberLogout implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session=request.getSession();
		session.invalidate();
		
		//이동 MemberMain.me
		ActionForward forward=new ActionForward();
		forward.setPath("Main.me");
		forward.setRedirect(true);
		return forward;
	}

}

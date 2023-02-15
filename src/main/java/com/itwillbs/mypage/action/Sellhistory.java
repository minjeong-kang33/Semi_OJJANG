package com.itwillbs.mypage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class Sellhistory implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		
		// 이동
		ActionForward forward=new ActionForward();
		forward.setPath("Mypage/sellHistory.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

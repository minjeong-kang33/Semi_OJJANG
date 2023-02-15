package com.itwillbs.mypage.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.db.MypageDAO;
import com.itwillbs.deal.db.DealDAO;
import com.itwillbs.deal.db.DealDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.sell.db.SellDTO;

public class Buyhistory implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		
		// 이동
		ActionForward forward=new ActionForward();
		forward.setPath("Mypage/buyHistory.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

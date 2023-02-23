package com.itwillbs.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.buy.db.BuyDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class AdBuyDelete2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdBuyDelete2 execute()");
		
		int B_num = Integer.parseInt(request.getParameter("B_num"));
		
			BuyDAO dao = new BuyDAO();
			dao.deleteBuyBoard(B_num);

			ActionForward forward = new ActionForward();
			forward.setPath("AdBuyList.ad");
			forward.setRedirect(true);
			
			return forward;
		}
}

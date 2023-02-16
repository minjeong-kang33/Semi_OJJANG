package com.itwillbs.buy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.buy.db.BuyDAO;

public class BuyDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BuyDelete execute()");

		int B_num = Integer.parseInt(request.getParameter("B_num"));

		BuyDAO dao = new BuyDAO();
		dao.deleteBuyBoard(B_num);

		ActionForward forward = new ActionForward();
		forward.setPath("BuyList.buy");
		forward.setRedirect(true);
		
		return forward;
	}

}

package com.itwillbs.sell.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.sell.db.SellDAO;


public class SellDeletePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDeletePro execute()");

		int S_num = Integer.parseInt(request.getParameter("S_num"));

		SellDAO dao = new SellDAO();
		dao.deleteLikeSellBoard(S_num);
		dao.deleteSellBoard(S_num);

		ActionForward forward = new ActionForward();
		forward.setPath("/Outer.sell");
		forward.setRedirect(false);
		
		return forward;
	}

}

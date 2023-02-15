package com.itwillbs.sell.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.sell.db.SellDAO;
import com.itwillbs.sell.db.SellDTO;

public class SellOuterDetails implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SellOuterDetails execute()");

		int S_num = Integer.parseInt(request.getParameter("S_num"));

		SellDAO dao = new SellDAO();

		SellDTO dto = dao.getSellBoard(S_num);
		request.setAttribute("dto", dto);

		ActionForward forward = new ActionForward();
		forward.setPath("sell/sellDetails.jsp");
		forward.setRedirect(false);

		return forward;
	}

}

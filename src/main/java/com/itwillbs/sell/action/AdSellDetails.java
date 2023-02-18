package com.itwillbs.sell.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.sell.db.SellDAO;
import com.itwillbs.sell.db.SellDTO;

public class AdSellDetails implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SellDetails execute()");

		int S_num = Integer.parseInt(request.getParameter("S_num"));

		SellDAO dao = new SellDAO();
		SellDTO dto = dao.getSellBoard(S_num);
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		request.setAttribute("dto", dto);

		ActionForward forward = new ActionForward();
		forward.setPath("admin/adsellDetails.jsp");
		forward.setRedirect(false);

		return forward;
	}
	
}

package com.itwillbs.buy.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.buy.db.BuyDAO;
import com.itwillbs.buy.db.BuyDTO;


public class BuyEditForm implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 int B_num = Integer.parseInt(request.getParameter("B_num"));
		 BuyDAO dao = new BuyDAO(); 
		 BuyDTO dto = dao.getBuyBoard(B_num);
		
		request.setAttribute("dto", dto);
		
		//주소 변경없이 이동
		ActionForward forward = new ActionForward();
		forward.setPath("buy/buyEditForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}

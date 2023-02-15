package com.itwillbs.sell.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.sell.db.SellDAO;
import com.itwillbs.sell.db.SellDTO;

public class SellEditForm implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int S_num = Integer.parseInt(request.getParameter("S_num"));

		SellDAO dao = new SellDAO();
		SellDTO dto = dao.getSellBoard(S_num);
		
		request.setAttribute("dto", dto);
		
		//주소 변경없이 이동
		ActionForward forward = new ActionForward();
		forward.setPath("sell/sellEditForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
	
}

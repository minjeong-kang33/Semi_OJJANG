package com.itwillbs.sell.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.deal.db.DealDAO;
import com.itwillbs.sell.db.SellDAO;


public class SellDeletePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardDeletePro execute()");

		int S_num = Integer.parseInt(request.getParameter("S_num"));
		
		DealDAO ddao = new DealDAO();
		ddao.dealList(S_num);
		
		if(S_num>=1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('거래중인 게시글은 삭제가 불가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		SellDAO sdao = new SellDAO();
		sdao.deleteLikeSellBoard(S_num);
		sdao.deleteSellBoard(S_num);

		ActionForward forward = new ActionForward();
		forward.setPath("/Outer.sell");
		forward.setRedirect(false);
		
		return forward;
	}

}

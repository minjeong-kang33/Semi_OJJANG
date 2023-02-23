package com.itwillbs.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.buy.db.BuyDAO;
import com.itwillbs.deal.db.DealDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.sell.db.DealDAO;
import com.itwillbs.sell.db.SellDAO;

public class AdSellDelete2 implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdSellDelete2 execute()");
		
		int S_num = Integer.parseInt(request.getParameter("S_num"));
		
		DealDAO ddao = new DealDAO();
		DealDTO dto=ddao.getBoard(S_num);
			
			if(dto!=null) {
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
			forward.setPath("/AdSellList.ad");
			forward.setRedirect(false);
			
			return forward;
	}
}

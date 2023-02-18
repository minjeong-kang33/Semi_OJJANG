package com.itwillbs.deal.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.deal.db.DealDAO;
import com.itwillbs.deal.db.DealDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class EndDealPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		int S_num=Integer.parseInt(request.getParameter("S_num"));
		String D_buy=request.getParameter("D_buy");
		
		
		DealDAO dao = new DealDAO();
		DealDTO dto = dao.CheckDeal2(M_id, S_num);
		ActionForward forward=null;

		if(dto==null) {	
		dao.EndDeal(S_num, D_buy);
		dao.deleteDeal(S_num);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter(); //프린트라이트에 쓰기 권한을 받아서 리스폰스 어쩌구에 담음
		out.println("<script type='text/javascript'>");
		out.println("alert('거래가 완료되었습니다.')");
		out.println("history.back()");
		out.println("</script>");
		out.close();	
		}else{		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter(); //프린트라이트에 쓰기 권한을 받아서 리스폰스 어쩌구에 담음
		out.println("<script type='text/javascript'>");
		out.println("alert('이미 거래가 완료된 상품입니다.')");
		out.println("history.back()");
		out.println("</script>");
		out.close();	
		forward=null;
	 }
			
			
		return forward;
	}

}

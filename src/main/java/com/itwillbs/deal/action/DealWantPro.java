package com.itwillbs.deal.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.deal.db.DealDAO;
import com.itwillbs.deal.db.DealDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.sell.db.SellDTO;

public class DealWantPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DealWantPro execute()");
		
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		int S_num=Integer.parseInt(request.getParameter("S_num"));
		String M_ids=request.getParameter("M_id");
		
		SellDTO dto=new SellDTO();
		DealDAO dao=new DealDAO();
		DealDTO Dto=dao.CheckDeal(M_id, S_num);
		
		
		ActionForward forward=null;
		
		if(Dto==null){	
			dao.insertDeal(S_num, M_id, M_ids);	
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter(); //프린트라이트에 쓰기 권한을 받아서 리스폰스 어쩌구에 담음
			out.println("<script type='text/javascript'>");
			out.println("alert('거래신청 완료')");
			out.println("history.back()");
			out.println("</script>");
			out.close();		 
					
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter(); //프린트라이트에 쓰기 권한을 받아서 리스폰스 어쩌구에 담음
			out.println("<script type='text/javascript'>");
			out.println("alert('이미 신청된 상품입니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();	
			forward=null;
		 }

		return forward;

	}

}

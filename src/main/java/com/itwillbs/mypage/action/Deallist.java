package com.itwillbs.mypage.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.db.MypageDAO;
import com.itwillbs.deal.db.DealDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.sell.db.SellDTO;

public class Deallist implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Deallist execute()");
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		
		MypageDAO dao=new MypageDAO();
		int pageSize=10;
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";		
		}
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
//		int endRow = startRow+pageSize-1;

		ArrayList<DealDTO> dealListB1=dao.dealListB1(startRow, pageSize, M_id);
		ArrayList<SellDTO> dealListS1=dao.dealListS1(startRow, pageSize, M_id);
		
		
	
		int pageBlock=10;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int count = dao.getdealCount(M_id);
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		// request 가져온 데이터 담기
		request.setAttribute("dealListB1", dealListB1);		
		request.setAttribute("dealListS1", dealListS1);		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		

		
		int pageSize1=10;
		String pageNum1=request.getParameter("pageNum1");
		if(pageNum1==null){
			pageNum1="1";		
		}
		int currentPage1=Integer.parseInt(pageNum1);
		int startRow1=(currentPage1-1)*pageSize1+1;
//		int endRow = startRow+pageSize-1;

		ArrayList<DealDTO> dealHistory1=dao.dealHistory1(startRow1, pageSize1, M_id);
		ArrayList<SellDTO> sellHistory1=dao.sellHistory1(startRow1, pageSize1, M_id);
		
		
	
		int pageBlock1=10;
		int startPage1=(currentPage1-1)/pageBlock1*pageBlock1+1;
		int endPage1=startPage1+pageBlock1-1;
		int count1 = dao.getdealCount1(M_id);
		int pageCount1=count1/pageSize1+(count1%pageSize1==0?0:1);
		if(endPage1 > pageCount1){
			endPage1 = pageCount1;
		}
		
		// request 가져온 데이터 담기
		request.setAttribute("sellHistory1", sellHistory1);		
		request.setAttribute("dealHistory1", dealHistory1);		
		request.setAttribute("currentPage1", currentPage1);
		request.setAttribute("startPage1", startPage1);
		request.setAttribute("pageBlock1", pageBlock1);
		request.setAttribute("endPage1", endPage1);
		request.setAttribute("pageCount1", pageCount1);
		
		
		ActionForward forward=new ActionForward();
		forward.setPath("Mypage/dealList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

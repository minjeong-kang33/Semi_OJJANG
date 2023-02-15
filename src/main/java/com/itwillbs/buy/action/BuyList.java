package com.itwillbs.buy.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.buy.db.BuyDAO;
import com.itwillbs.buy.db.BuyDTO;

public class BuyList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BuyList execute()");
		// 한 페이지에 보여줄 글 
		BuyDAO dao=new BuyDAO();

		int pageSize=10;

		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
			pageNum="1";
		}

		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		ArrayList<BuyDTO> buyList=dao.getList(startRow, pageSize);

	
		
		int pageBlock=10;

		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int count = dao.getBuyBoardCount();
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		request.setAttribute("buyList", buyList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		// 이동 buy/buyList.jsp
		ActionForward forward=new ActionForward();
		forward.setPath("buy/buyList.jsp");
		forward.setRedirect(false);
		return forward;
	}
	
}

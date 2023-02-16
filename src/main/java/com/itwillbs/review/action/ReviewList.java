package com.itwillbs.review.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.review.db.reviewDAO;
import com.itwillbs.review.db.reviewDTO;

public class ReviewList implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ReviewList execute");
		
		
//		String M_id=(String)session.getAttribute("M_id"); 혹시몰라서 둠 

		reviewDAO dao = new reviewDAO();
		int pageSize=5;
	
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){
		   	pageNum="1";		
		   }
		 
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;

		ArrayList<reviewDTO> reviewList= dao.getReviewList(startRow, pageSize);
		
		int pageBlock = 10;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int count = dao.getreviewCount();
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		ActionForward forward = new ActionForward();
		forward.setPath("review/reviewList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

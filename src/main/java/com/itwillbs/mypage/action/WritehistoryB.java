package com.itwillbs.mypage.action;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.db.MypageDAO;
import com.itwillbs.buy.db.BuyDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class WritehistoryB implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BuyList execute()");
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
		int endRow = startRow+pageSize-1;

		ArrayList<BuyDTO> buyList=dao.buyList(startRow, pageSize, M_id);
		
		int pageBlock=10;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int count = dao.getbuyCount(M_id);
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		if(endPage > pageCount){
			endPage = pageCount;
		}
		
		// request 가져온 데이터 담기
		request.setAttribute("buyList", buyList);		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		// 이동
		ActionForward forward=new ActionForward();
		forward.setPath("Mypage/WriteHistoryB.jsp");
		forward.setRedirect(false);
		return forward;
	}
}

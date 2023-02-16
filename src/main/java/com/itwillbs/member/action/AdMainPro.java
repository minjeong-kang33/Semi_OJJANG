package com.itwillbs.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.sell.db.SellDAO;
import com.itwillbs.sell.db.SellDTO;

public class AdMainPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdMainPro execute()");
		SellDAO dao =new SellDAO();
		
		int pageSize = 9;
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum==null){
			pageNum="1";
		}
		
		int currentPage=Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		
		int endRow = startRow + pageSize -1;
		
		ArrayList<SellDTO> sellList = dao.getsellList(startRow, pageSize);
		
		// 가져온 데이터 담기
		request.setAttribute("sellList", sellList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("home/admain.jsp");
		forward.setRedirect(false);

		return forward;
	}
	
}

package com.itwillbs.sell.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.sell.db.SellDAO;
import com.itwillbs.sell.db.SellDTO;

public class SellPantsList implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SellDAO dao = new SellDAO();
		int pageSize = 9;

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = startRow + pageSize - 1;

		ArrayList<SellDTO> sellPantsList = dao.getsellPantsList(startRow, pageSize);

		int pageBlock = 10;
		int startPage = (currentPage - 1) / pageBlock * pageBlock + 1;
		int endPage = startPage + pageBlock - 1;

		int count = dao.getSellBoardCount("Pants");
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);

		if (endPage > pageCount) {
			endPage = pageCount;
		}
		// 가져온 데이터 담기
		request.setAttribute("sellPantsList", sellPantsList);

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);

		// 이동
		ActionForward forward = new ActionForward();
		forward.setPath("sell/pants.jsp");
		forward.setRedirect(false);

		return forward;
	}

}

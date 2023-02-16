package com.itwillbs.buy.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itwillbs.buy.db.BuyDAO;
import com.itwillbs.buy.db.BuyDTO;
import com.itwillbs.comment.db.CommentDAO;
import com.itwillbs.comment.db.CommentDTO;

public class BuyDetails implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BuyDetails execute()");
		
		int B_num = Integer.parseInt(request.getParameter("B_num"));
		BuyDAO dao = new BuyDAO();
		BuyDTO dto = dao.getBuyBoard(B_num);
		request.setAttribute("dto", dto);
		
		int pageNumber=1;
		if(request.getParameter("pageNumber")!=null){
			pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		}
			CommentDAO comment=new CommentDAO();
			ArrayList<CommentDTO>List=comment.getList(B_num, pageNumber);
			
		ActionForward forward = new ActionForward();
		forward.setPath("buy/buyDetails.jsp");
		forward.setRedirect(false);

		return forward;
		
	}

}

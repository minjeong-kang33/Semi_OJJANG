package com.itwillbs.buy.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.comment.db.CommentDAO;

public class CommentDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentDelete execute()");
		int B_num=Integer.parseInt(request.getParameter("B_num"));
		int Co_num=Integer.parseInt(request.getParameter("Co_num"));
		
				CommentDAO commentDAO=new CommentDAO();

				commentDAO.delete(Co_num);
				String url = "BuyDetails.buy?B_num=" + B_num;
				PrintWriter script= response.getWriter();
				script.println("<script>");
				script.println("location.href='"+url+"'");
				script.println("</script>");
		return null;
	}

}

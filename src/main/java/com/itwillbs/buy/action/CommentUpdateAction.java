package com.itwillbs.buy.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.comment.db.CommentDAO;
import com.itwillbs.comment.db.CommentDTO;

public class CommentUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentUpdateAction execute()");
		
		request.setCharacterEncoding("utf-8");
		CommentDTO comment = new CommentDTO();	

	    int Co_num=Integer.parseInt(request.getParameter("Co_num"));
		String Co_text=request.getParameter("Co_text");
		request.setAttribute("Co_num", Co_num);
		if(Co_text == ""){
				PrintWriter script= response.getWriter();
				script.println("<script>");
				script.println("alert('댓글을 입력해주세요.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else{
				CommentDAO commentDAO=new CommentDAO();
				
				commentDAO.update(Co_num, Co_text);
				PrintWriter script= response.getWriter();
				script.println("<script>");
				script.println("window.opener.parent.location.reload();");
				script.println("window.close()");
				script.println("</script>");

				}
		return null;
	}
	
}

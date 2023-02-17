package com.itwillbs.buy.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.comment.db.CommentDAO;
import com.itwillbs.comment.db.CommentDTO;

public class CommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentAction execute()");
		
		request.setCharacterEncoding("UTF-8");
		int B_num=1;
		if(request.getParameter("B_num")!=null){
			B_num=Integer.parseInt(request.getParameter("B_num"));
		}
		HttpSession session = request.getSession();
		String M_id = (String)session.getAttribute("M_id");
		
		if(M_id!=null){
			M_id=(String)session.getAttribute("M_id");
		}
		if(M_id==null){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('로그인이 필요합니다.')");
			script.println("location.href='MemberLoginForm.me'");
			script.println("</script>");	
		}
		
		else{
			CommentDTO comment = new CommentDTO();	
			String Co_text=request.getParameter("Co_text");
			if(
				Co_text == null ){
				PrintWriter script= response.getWriter();
				script.println("<script>");
				script.println("alert('댓글을 입력해주세요.')");
				script.println("history.back()");
				script.println("</script>");
			}
			else{
				CommentDAO commentDAO=new CommentDAO();
				
				commentDAO.write(B_num, Co_text, M_id);
				
				String url = "BuyDetails.buy?B_num=" + B_num;
				PrintWriter script= response.getWriter();
				script.println("<script>");
				script.println("location.href='"+url+"'");
				script.println("</script>");

				}
			}
		
	
		return null;
	}

}

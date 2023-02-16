package com.itwillbs.buy.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.comment.db.CommentDAO;
import com.itwillbs.comment.db.CommentDTO;

public class CommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CommentAction execute()");
		

		int B_num=1;
		if(request.getParameter("B_num")!=null){
			B_num=Integer.parseInt(request.getParameter("B_num"));
		}
	    // 세션값어떻게들고오더라
		String M_id=null;
		BuyDTO dto = dao.getMember(M_id);
		if(dto!=null){
			M_id=(String)session.getAttribute("M_id");
		}
		if(dto==null){
			PrintWriter script=response.getWriter();
			script.println("<script>");
			script.println("alert('로그인이 필요합니다.')");
			script.println("location.href='login.jsp'");
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
				
				commentDAO.write(B_num, Co_text, dto);
				
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

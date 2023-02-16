package com.itwillbs.like.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.db.MypageDAO;
import com.itwillbs.like.db.LikeDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class LikePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LikePro execute()");

		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		int S_num=Integer.parseInt(request.getParameter("S_num"));
		
		MypageDAO dao=new MypageDAO();
		LikeDTO getLikeDto=dao.getLike(M_id, S_num);
		
		ActionForward forward=null;
		
		if(getLikeDto==null){			
			dao.insertlike(S_num, M_id);
			dao.insertlike_S_like(S_num);			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter(); //프린트라이트에 쓰기 권한을 받아서 리스폰스 어쩌구에 담음
			out.println("<script type='text/javascript'>");
			out.println("alert('찜완료')");
			out.println("history.back()");
			out.println("</script>");
			out.close();		
					
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter(); //프린트라이트에 쓰기 권한을 받아서 리스폰스 어쩌구에 담음
			out.println("<script type='text/javascript'>");
			out.println("alert('이미 찜한 상품입니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();	
			forward=null;
		 }

		return forward;

	}

}

package com.itwillbs.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.db.AdminDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class AdUserDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("AdUserDelete execute()");
		AdminDAO dao=new AdminDAO();
		
		String M_id=request.getParameter("M_id");
		String R_type=request.getParameter("R_type");
		
		System.out.println(M_id);
		System.out.println(R_type);
		
		dao.adUserDeletePro(M_id);
		dao.adOut(M_id, R_type);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('강퇴완료');");
		out.println("window.close()");
		out.println("opener.parent.location.reload();");
		out.println("</script>");
		out.close();

		return null;
	}
}

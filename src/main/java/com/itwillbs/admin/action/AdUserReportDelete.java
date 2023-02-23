package com.itwillbs.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.db.AdminDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.out.db.OutDTO;

public class AdUserReportDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println("AdUserDelete execute()");
		AdminDAO dao=new AdminDAO();
		String R_id=request.getParameter("R_id");
		String R_type=request.getParameter("R_type");
		OutDTO dto=new OutDTO();
		dto.setM_id(R_id);
		dto.setO_reason(R_type);
		
		dao.adUserReportDelete(R_id);
		dao.adUserReportOut(R_id);
		dao.adOut(dto);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('강퇴완료');");
		out.println("location.href=\'AdUserReportList.ad'");
		out.println("</script>");
		out.close();
		
		return null;
	}
}
package com.itwillbs.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.db.AdminDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class AdUserReportDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdUserDelete execute()");
		AdminDAO dao=new AdminDAO();
		
		String R_idArr[]=request.getParameterValues("ck");
		String R_id=null;
		if(R_idArr!=null){
			for(int i=0;i<R_idArr.length;i++){
				R_id=R_idArr[i];
				dao.adUserReportDelete(R_id);
				dao.adUserReportOut(R_id);
			}
		}
		
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
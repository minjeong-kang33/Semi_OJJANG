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
		
		String M_idArr[]=request.getParameterValues("ck");
		String M_id=null;
		if(M_idArr!=null){
			for(int i=0;i<M_idArr.length;i++){
				M_id=M_idArr[i];
				dao.adUserDeletePro(M_id);
			}
		}
		
		ActionForward forward=null;
		if(M_id!=null) {
			forward=new ActionForward();
			forward.setPath("AdUserReportList.ad");
			forward.setRedirect(true);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('강퇴완료');");
			out.println("location.href=\'AdUserReportList.ad'");
			out.println("</script>");
		}
		return forward;
	}
}
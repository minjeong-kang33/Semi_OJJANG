package com.itwillbs.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.db.AdminDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class AdBuyDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdBuyDelete execute()");
		AdminDAO dao=new AdminDAO();
		
		String S_numArr[]=request.getParameterValues("ck");
		String S_num=null;
		if(S_numArr!=null){
			for(int i=0;i<S_numArr.length;i++){
				S_num=S_numArr[i];
				dao.adBuyDelete(Integer.parseInt(S_num));
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script type='text/javascript'>");
		out.println("alert('삭제완료');");
		out.println("location.href=\'AdBuyList.ad'");
		out.println("</script>");
		out.close();
		
		return null;
	}
}

package com.itwillbs.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.db.AdminDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.member.db.MemberDTO;

public class AdOutListPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdOutListPro execute()");
		request.setCharacterEncoding("utf-8");
		AdminDAO dao=new AdminDAO();
		
		String info = request.getParameter("info");
		String search = request.getParameter("search");
		ArrayList<MemberDTO> adOutListPro=dao.adOutListPro(info, search);
		
		int count=dao.adOutCount();
		
		request.setAttribute("adOutListPro", adOutListPro);
		request.setAttribute("adOutCount", count);
		
		ActionForward forward=new ActionForward();
		forward.setPath("admin/adOutListPro.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

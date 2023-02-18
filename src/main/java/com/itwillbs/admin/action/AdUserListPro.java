package com.itwillbs.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.db.AdminDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.member.db.MemberDTO;

public class AdUserListPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdUserListPro execute()");
		request.setCharacterEncoding("utf-8");
		AdminDAO dao=new AdminDAO();
		
		String info = request.getParameter("info");
		String search = request.getParameter("search");
		ArrayList<MemberDTO> adUserListPro=dao.adUserListPro(info, search);
		int count=dao.adUserCount();
		
		if(info.equals("M_id")) {
			info="아이디";
		}else if(info.equals("M_name")) {
			info="이름";
		}else {
			info="닉네임";
		}
		
		request.setAttribute("adUserListPro", adUserListPro);
		request.setAttribute("adUserCount", count);
		request.setAttribute("search", search);
		request.setAttribute("info", info);
		
		ActionForward forward=new ActionForward();
		forward.setPath("admin/adUserListPro.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
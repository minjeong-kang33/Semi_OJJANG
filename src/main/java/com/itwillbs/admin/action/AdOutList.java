package com.itwillbs.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.admin.db.AdminDAO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.member.db.MemberDTO;

public class AdOutList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AdOutList execute()");
		request.setCharacterEncoding("utf-8");
		String info = request.getParameter("info");
		String infoD = null;
		String search = request.getParameter("search");
		
		AdminDAO dao=new AdminDAO();
		int pageSize=10;
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){pageNum="1";}
		int currentPage=Integer.valueOf(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		ArrayList<MemberDTO> adOutList=null;
		
		if(search==null&&info==null) {
			adOutList=dao.adOutList(startRow,pageSize);
		}else {
			adOutList=dao.adOutList(startRow,pageSize, info, search);
		}
		
		int pageBlock=10;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int count=0;
		
		if(search==null&&info==null) {
			count=dao.adOutCount();
		}else {
			count=dao.adOutCount(info, search);
		}
		
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		if(endPage>pageCount){endPage=pageCount;}
		
		if(info!=null) {
			if(info.equals("M_id")) {
				infoD="아이디";
			}else if(info.equals("M_name")) {
				infoD="이름";
			}else {
				infoD="닉네임";
			}
		}
		
		request.setAttribute("adOutList", adOutList);
		request.setAttribute("adOutCount", count);
		request.setAttribute("info", info);
		request.setAttribute("infoD", infoD);
		request.setAttribute("search", search);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("endPage", endPage);
		request.setAttribute("pageCount", pageCount);
		
		ActionForward forward=new ActionForward();
		forward.setPath("admin/adOutList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

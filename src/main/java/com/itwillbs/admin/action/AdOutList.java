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
		AdminDAO dao=new AdminDAO();
		
		int pageSize=10;
		String pageNum=request.getParameter("pageNum");
		if(pageNum==null){pageNum="1";}
		int currentPage=Integer.valueOf(pageNum);
		int startRow=(currentPage-1)*pageSize+1;
		int endRow=startRow+pageSize-1;
		ArrayList<MemberDTO> adOutList=dao.adOutList(startRow,pageSize);
		
		int pageBlock=10;
		int startPage=(currentPage-1)/pageBlock*pageBlock+1;
		int endPage=startPage+pageBlock-1;
		int count=dao.adOutCount();
		int pageCount=count/pageSize+(count%pageSize==0?0:1);
		if(endPage>pageCount){endPage=pageCount;}
		
		request.setAttribute("adOutList", adOutList);
		request.setAttribute("adOutCount", count);
		
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

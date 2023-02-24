package com.itwillbs.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.sell.db.SellDAO;
import com.itwillbs.sell.db.SellDTO;
public class SearchPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				request.setCharacterEncoding("UTF-8");
				String search =request.getParameter("search"); 
				SellDAO dao=new SellDAO();
				int pageSize=9;
				String pageNum=request.getParameter("pageNum");
				if(pageNum==null){
					pageNum="1";		
				}
				int currentPage=Integer.parseInt(pageNum);				
				int startRow=(currentPage-1)*pageSize+1;
				int endRow=startRow+pageSize-1;
				
	
		
				int pageBlock=10;
				int startPage=(currentPage-1)/pageBlock*pageBlock+1;
				int endPage=startPage+pageBlock-1;
				int count = 0;
				if(search!=null) {
					count = dao.getSearchCount(search);		
				}else {
					// 검색어 없음
					count = dao.getSearchCount();		
				}
				int pageCount=count/pageSize+(count%pageSize==0?0:1);
				if(endPage > pageCount){
					endPage = pageCount;
				}
				
				ArrayList<SellDTO> sellList = null;
				if(search!=null){
					System.out.println("startRow"+startRow);
					sellList = dao.getsellSearch(startRow, pageSize, search);
					System.out.println("pageSize"+pageSize);
					System.out.println("pageNum"+pageNum);
				}else{
					 sellList = dao.getsellList(startRow, pageSize);
				}
				
				// request 가져온 데이터 담기
				request.setAttribute("sellList", sellList);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("startPage", startPage);
				request.setAttribute("pageBlock", pageBlock);
				request.setAttribute("pageSize", pageSize);
				request.setAttribute("endPage", endPage);
				request.setAttribute("pageCount", pageCount);
				
				
			
				// 이동
				ActionForward forward=new ActionForward();
				forward.setPath("home/main.jsp");
				forward.setRedirect(false);
				return forward;
			}
		}
	
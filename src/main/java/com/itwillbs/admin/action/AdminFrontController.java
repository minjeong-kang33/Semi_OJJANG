package com.itwillbs.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;

public class AdminFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("AdminFrontController doPost()");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("가상주소 : "+request.getServletPath());
		String sPath=request.getServletPath();
		
		ActionForward forward=null;
		Action action=null;
		
		/* 관리자관련 가상주소 .ad 입니다!! */
		/* 여기 아래부터 if문 작성. 각 if이 끝나는 괄호 뒤에는 작성자 이름 함께 적기 */
		
		if(sPath.equals("/AdUserList.ad")) {
			action=new AdUserList();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdUserListPro.ad")) {
			action=new AdUserListPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdUserDelete.ad")) {
			action=new AdUserDelete();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdUserReportList.ad")) {
			action=new AdUserReportList();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdUserReportListPro.ad")) {
			action=new AdUserReportListPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdOutList.ad")) {
			action=new AdOutList();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdOutListPro.ad")) {
			action=new AdOutListPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdUserReportDelete.ad")) {
			action=new AdUserReportDelete();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdBuyList.ad")) {
			action=new AdBuyList();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdBuyDelete.ad")) {
			action=new AdBuyDelete();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdSellDelete.ad")) {
			action=new AdSellDelete();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/AdSellList.ad")) {
			action=new AdSellList();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//노은주
			
		}else if(sPath.equals("/Popup2.ad")) {
			forward=new ActionForward();
			forward.setPath("popup/popup2.jsp");
			forward.setRedirect(false);
			}//노은주
		
		
		
		
		
		/* 여기 위까지 if문 작성 */
		
		if(forward != null) {
			//이동방식비교
			if(forward.isRedirect()==true) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher=
				request.getRequestDispatcher(forward.getPath());
		        dispatcher.forward(request, response);
			}
		}//이동방식
		
	}//doProcess()
	
}//클래스

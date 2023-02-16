package com.itwillbs.buy.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BuyFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BuyFrontController doPost()");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("가상주소 : "+request.getServletPath());
		String sPath=request.getServletPath();
		
		ActionForward forward=null;
		Action action=null;
		
		/* 삽니다 게시판 관련 가상주소 .buy 입니다!! */
		/* 여기 아래부터 if문 작성. 각 if이 끝나는 괄호 뒤에는 작성자 이름 함께 적기 */
		if(sPath.equals("/BuyList.buy")) {
			action=new BuyList();
			try {
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} // 임호정
		else if (sPath.equals("/BuyDetails.buy")) {
			action = new BuyDetails();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} // 임호정
		}else if (sPath.equals("/CommentAction.buy")) {
			action = new CommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (sPath.equals("/CommentDelete.buy")) {
			action = new CommentDelete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (sPath.equals("/CommentUpdateForm.buy")) {
			
			forward=new ActionForward();
			forward.setPath("buy/commentupdateForm.jsp");
			forward.setRedirect(false);
			
			}else if (sPath.equals("/CommentUpdateAction.buy")) {
				action = new CommentUpdateAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}// 임호정
				
			}else if (sPath.equals("/BuyInsertForm.buy")) {

				forward = new ActionForward();
				forward.setPath("buy/buyInsertForm.jsp");
				forward.setRedirect(false);
				// 강민정
				
			}else if (sPath.equals("/BuyInsertPro.buy")) {
				action = new BuyInsertPro();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} // 강민정
				
			}else if (sPath.equals("/BuyEditForm.buy")) {
				action = new BuyEditForm();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} // 강민정
				
			}else if (sPath.equals("/BuyEditPro.buy")) {
				action = new BuyEditPro();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} // 강민정
				
			}else if (sPath.equals("/BuyDelete.buy")) {
				action = new BuyDelete();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				} // 강민정
				
			}
		
		
		
		
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
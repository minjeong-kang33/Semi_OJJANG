package com.itwillbs.sell.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SellFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SellFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SellFrontController doPost()");
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("가상주소 : " + request.getServletPath());
		String sPath = request.getServletPath();

		ActionForward forward = null;
		Action action = null;

		/* 팝니다 게시판 관련 가상주소 .sell 입니다!! */
		/* 여기 아래부터 if문 작성. 각 if이 끝나는 괄호 뒤에는 작성자 이름 함께 적기 */

		if (sPath.equals("/Outer.sell")) {
			action = new SellOuterList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/Shirts.sell")) {
			action = new SellShirtsList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/Pants.sell")) {
			action = new SellPantsList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/Dress.sell")) {
			action = new SellDressList();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/SellInsertForm.sell")) {
			forward=new ActionForward();
			forward.setPath("sell/sellInsertForm.jsp");
			forward.setRedirect(false);
		} 

		else if (sPath.equals("/SellInsertPro.sell")) {
			action = new SellInsertPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/SellInsertPro.sell")) {
			action = new SellInsertPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/SellDetails.sell")) {
			action = new SellDetails();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정
		
		else if (sPath.equals("/SellOuterDetails.sell")) {
			action = new SellOuterDetails();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정
		
		else if (sPath.equals("/SellShirtsDetails.sell")) {
			action = new SellShirtsDetails();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정
		
		else if (sPath.equals("/SellPantsDetails.sell")) {
			action = new SellPantsDetails();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정
		
		else if (sPath.equals("/SellDressDetails.sell")) {
			action = new SellDressDetails();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/SellEditForm.sell")) {
			action = new SellEditForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/SellEditPro.sell")) {
			action = new SellEditPro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		else if (sPath.equals("/SellDelete.sell")) {
			action = new SellDeletePro();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // 강민정

		/*
		 * else if (sPath.equals("/SellDetails.sell")) { action = new
		 * SellOuterDetails(); try { forward = action.execute(request, response); }
		 * catch (Exception e) { e.printStackTrace(); } } // 강민정  // 이건 필요없을지도.. 문제있으면 살려요
		 */
		
		
		
		
		/* 여기 위까지 if문 작성 */

		if (forward != null) {
			// 이동방식비교
			if (forward.isRedirect() == true) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} // 이동방식

	}// doProcess()

}
// 클래스

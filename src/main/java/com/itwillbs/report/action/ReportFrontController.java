package com.itwillbs.report.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.review.action.ReviewList;

public class ReportFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReportFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ReportFrontController doPost()");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("가상주소 : "+request.getServletPath());
		String sPath=request.getServletPath();
		
		ActionForward forward=null;
		Action action=null;
		
		/* 신고 관련 가상주소 .rpt 입니다!! */
		/* 여기 아래부터 if문 작성. 각 if이 끝나는 괄호 뒤에는 작성자 이름 함께 적기 */

		
		// 신고하기 폼 (승민)
		if(sPath.equals("/ReportForm.rpv")){
		     forward = new ActionForward();
	         forward.setPath("report/reportForm.jsp");
	         forward.setRedirect(false);
	         
	    //신고하기 Pro
		} else if(sPath.equals("/ReportPro.rpv")) {
	    	  action = new ReportPro();
	    	  try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
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

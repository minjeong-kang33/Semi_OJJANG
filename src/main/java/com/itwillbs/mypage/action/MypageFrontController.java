package com.itwillbs.mypage.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;


public class MypageFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MypageFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MypageFrontController doGet()");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("가상주소 : "+request.getServletPath());
		String sPath=request.getServletPath();
		
		ActionForward forward=null;
		Action action=null;
		
		/* 마이페이지관련 가상주소 .me 입니다!! */
		/* 여기 아래부터 if문 작성. 각 if이 끝나는 괄호 뒤에는 작성자 이름 함께 적기 */
		
		if(sPath.equals("/ProfileUpdateForm.moi")) {
			System.out.println("가상주소 /ProfileUpdateForm.moi");
			action=new ProfileUpdateForm();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} //박은지
			
		}else if(sPath.equals("/ProfileUpdatePro.moi")) {
			action=new ProfileUpdatePro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지
			
		}else if(sPath.equals("/PwUpdateForm.moi")) {
			action=new PwUpdateForm();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지
			
		}else if(sPath.equals("/PwUpdatePro.moi")) {
			action=new PwUpdatePro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지
			
		}else if(sPath.equals("/Profile.moi")) {
			action=new Profile();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지
			
		}else if(sPath.equals("/Writehistory.moi")) {
			action=new Writehistory();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지
			
		}else if(sPath.equals("/WritehistoryB.moi")) {
			action=new WritehistoryB();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지
			
		}else if(sPath.equals("/WritehistoryS.moi")) {
			action=new WritehistoryS();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지	
			
		}else if(sPath.equals("/Likelist.moi")) {
			action=new Likelist();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}//박은지
		}else if(sPath.equals("/Buyhistory.moi")) {
			action=new Buyhistory();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(sPath.equals("/Sellhistory.moi")) {
			action=new Sellhistory();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else if(sPath.equals("/Mypage.moi")) {
			forward=new ActionForward();
			forward.setPath("Mypage/mypage.jsp");
			forward.setRedirect(false);
			
			
			
			
			
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

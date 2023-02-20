package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doGet()");
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController doPost()");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("가상주소 : "+request.getServletPath());
		String sPath=request.getServletPath();
		
		ActionForward forward=null;
		Action action=null;
		
		/* 회원 관련 가상주소 .me 입니다!! */
		/* 여기 아래부터 if문 작성. 각 if이 끝나는 괄호 뒤에는 작성자 이름 함께 적기 */
		
		
		if(sPath.equals("/Main.me")) {
	         action = new SearchPro();
	         try {
	            forward=action.execute(request, response);
	         } catch (Exception e) {
	            e.printStackTrace();
	         }
	         
	      } //신영환
		
		else if(sPath.equals("/MemberLoginForm.me")) {
			forward=new ActionForward();
			forward.setPath("login/loginForm.jsp");
			forward.setRedirect(false);
			
		} //강민정
		
		else if(sPath.equals("/MemberLoginPro.me")) {
			action = new MemberLoginPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} //강민정
		
		else if(sPath.equals("/MemberLogout.me")) {
			action=new MemberLogout();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//로그아웃 김광원

		
		else if(sPath.equals("/MemberJoinForm.me")) {
			forward=new ActionForward();
			forward.setPath("join/joinForm.jsp");
			forward.setRedirect(false);
		}else if(sPath.equals("/MemberJoinPro.me")) {
			action=new MemberJoinPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// 회원가입 김광원
		
		else if(sPath.equals("/MemberidCheckForm.me")){
			forward=new ActionForward();
			forward.setPath("join/idCheck.jsp");
			forward.setRedirect(false);
			
		}
		else if(sPath.equals("/MemberidCheckPro.me")) {
			action=new MemberidCheckPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// 아이디중복확인 김광원
		
		else if(sPath.equals("/MembernikCheckForm.me")){
			forward=new ActionForward();
			forward.setPath("join/nickCheck.jsp");
			forward.setRedirect(false);
			
		}
		else if(sPath.equals("/MembernikCheckPro.me")) {
			action=new MembernikCheckPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// 닉네임 중복확인 김광원
		
		else if(sPath.equals("/MemberfindIDForm.me")){
			forward=new ActionForward();
			forward.setPath("login/findID.jsp");
			forward.setRedirect(false);
			
		}
		else if(sPath.equals("/MemberfindIDPro.me")) {
			action=new MemberfindIDPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(sPath.equals("/MembersendPw.me")) {
			action=new MembersendPw();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// 이메일보내기 김광원
		else if(sPath.equals("/MemberwithdrawalForm.me")){
			forward=new ActionForward();
			forward.setPath("withdrawal/withdrawal.jsp");
			forward.setRedirect(false);
			
		}
		else if(sPath.equals("/MemberwithdrawalPro.me")) {
			action=new MemberwithdrawalPro();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// 회원탈퇴
		
		
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

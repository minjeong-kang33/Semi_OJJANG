package com.itwillbs.out.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;
import com.itwillbs.out.db.OutDAO;
import com.itwillbs.out.db.OutDTO;

public class OutwithdrawalPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String M_id=request.getParameter("M_id");
		String M_pw=request.getParameter("M_pw");
		
		Timestamp O_outday=new Timestamp(System.currentTimeMillis()); 
		String O_reason = request.getParameter("O_reason");
		OutDTO dto2 = new OutDTO();
		
		dto2.setM_id(M_id);
		dto2.setO_outday(O_outday); 
		dto2.setO_reason(O_reason);
		OutDAO dao2=new OutDAO();
		
		MemberDAO dao=new MemberDAO();
		MemberDTO dto=dao.M_userCheck(M_id, M_pw);
		ActionForward forward=null;
		if(dto!=null) {
			dao.DeleteMember(M_id);
			dao2.insertOut(dto2);
			HttpSession session=request.getSession();
			session.invalidate();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			forward=new ActionForward();
			forward.setPath("Main.me");
			forward.setRedirect(true);
		}else{
			// id,pass 틀림
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 비밀번호가 틀립니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();

			forward=null;
		}
		
		return forward;
	}
}

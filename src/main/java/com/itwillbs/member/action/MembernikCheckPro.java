package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;

public class MembernikCheckPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberidCheckPro.me execute()");
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String M_nick = request.getParameter("M_nick");
		MemberDAO dao = new MemberDAO();
		int cnt = dao.duplecateNick(M_nick);
		out.println("입력 닉네임 : <strong>" + M_nick + "</stong>");
			ActionForward forward = new ActionForward();
			if (cnt == 0) {
				out.println("<p>사용 가능한 닉네임입니다.</p>");
				out.println("<a href='javascript:apply(\"" + M_nick + "\")'>[적용]</a>");
		        out.println("<script type=\"text/javascript\">");
		        out.println("function apply(M_nick) {");
		        out.println("window.opener.document.getElementById(\"M_nick\").value =M_nick;");
		        out.println("window.close();}");
		        out.println("</script>");
		        out.close();
					
			}
			else {
				out.println("<p style='color: red'>해당 닉네임은 사용하실 수 없습니다.</p>");
				out.println("<a href=\"javascript:history.back()\">[다시시도]</a> &nbsp; &nbsp;");
				out.println("<a href=\"javascript:window.close()\">[창닫기]</a>");
				return null;
			}
		return forward;
	}

}

package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberidCheckPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberidCheckPro.me execute()");
		request.setCharacterEncoding("utf-8");
		String M_id = request.getParameter("M_id");
		MemberDAO dao = new MemberDAO();
		int cnt = dao.duplecateID(M_id);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
		out.println("입력된 ID <strong>" + M_id + "</stong>" + "는");
			ActionForward forward = new ActionForward();
			if (cnt == 0) {
				out.println("<p>사용 가능한 아이디입니다.</p>");
				out.println("<a href='javascript:apply(\"" + M_id + "\")'>[적용하기]</a>");
		        out.println("<script type=\"text/javascript\">");
		        out.println("function apply(M_id) {");
		        out.println("window.opener.document.getElementById(\"M_id\").value =M_id;");
		        out.println("window.close();}");
		        out.println("</script>");
		        out.close();
					
			}
			else {
				out.println("<p style='color: red'>해당 아이디는 사용하실 수 없습니다.</p>");
				out.println("<a href=\"javascript:history.back()\">[다시시도]</a> &nbsp; &nbsp;");
				out.println("<a href=\"javascript:window.close()\">[창닫기]</a>");
				return null;
			}
		return forward;
	}

}

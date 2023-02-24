package com.itwillbs.report.action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.report.db.ReportDAO;
import com.itwillbs.report.db.ReportDTO;

public class ReportPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	request.setCharacterEncoding("utf-8");
	String R_type = request.getParameter("R_type"); // 신고유형
	String M_id = request.getParameter("M_id"); 
	String R_id = request.getParameter("R_id"); //가해자
	String R_reason = request.getParameter("R_reason");
	String R_category = request.getParameter("R_category");
	String R_writeNum = request.getParameter("R_writeNum");
	String R_title = request.getParameter("R_title");
	String R_play = request.getParameter("R_play");
	Timestamp R_date = new Timestamp(System.currentTimeMillis());
	
	
	ReportDTO dto = new ReportDTO();
	dto.setR_type(R_type);
	dto.setM_id(M_id);
	dto.setR_id(R_id); 
	dto.setR_reason(R_reason);
	dto.setR_writeNum(R_writeNum);
	dto.setR_category(R_category);
	dto.setR_title(R_title);
	dto.setR_play(R_play);
	dto.setR_date(R_date);
	
	ReportDAO dao = new ReportDAO();
	
	dao.insertReport(dto);

	response.setContentType("text/html; charset=UTF-8");
	
	PrintWriter out = response.getWriter(); // 이거 맞나?
      out.println("<script>");
      out.println("alert('신고가 완료되었습니다.')");
      out.println("window.close();");
      out.println("</script>");
      out.close();
      
		return null;
	}

}

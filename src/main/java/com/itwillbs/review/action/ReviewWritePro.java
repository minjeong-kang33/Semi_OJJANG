package com.itwillbs.review.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.review.db.reviewDAO;
import com.itwillbs.review.db.reviewDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWritePro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String uploadPath=request.getRealPath("img/review");
		System.out.println(uploadPath);

		int maxSize=10*1024*1024;

		MultipartRequest multi=new MultipartRequest
		(request, uploadPath,maxSize,"utf-8",new DefaultFileRenamePolicy());
				
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String M_id=(String)session.getAttribute("M_id");
		String RE_title=multi.getParameter("RE_title");
		String RE_text =multi.getParameter("RE_text");
		String RE_delivery = multi.getParameter("RE_delivery");
		String RE_manner = multi.getParameter("RE_manner");
		String RE_ProductStatus = multi.getParameter("RE_ProductStatus");
		String RE_fast = multi.getParameter("RE_fast");
		String RE_time = multi.getParameter("RE_time");
		String RE_img1 = multi.getFilesystemName("RE_img1");

		Timestamp RE_createtime = new Timestamp(System.currentTimeMillis());

		reviewDTO dto = new reviewDTO();
		dto.setRE_writer(M_id); // M_id;
		dto.setRE_title(RE_title);
		dto.setRE_text(RE_text);
		dto.setRE_delivery(RE_delivery);

		dto.setRE_manner(RE_manner);
		dto.setRE_ProductStatus(RE_ProductStatus);
		dto.setRE_fast(RE_fast);
		dto.setRE_time(RE_time);
		dto.setRE_createtime(RE_createtime);
		dto.setRE_img1(RE_img1);

		reviewDAO dao = new reviewDAO();

		dao.insertreview(dto);

		ActionForward forward = new ActionForward();
		forward.setPath("review/reviewList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

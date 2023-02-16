package com.itwillbs.buy.action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.buy.db.BuyDAO;
import com.itwillbs.buy.db.BuyDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BuyInsertPro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BuyInsertPro execute()");

		String uploadPath = request.getRealPath("/img/buy");
		System.out.println(uploadPath);
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8",
				new DefaultFileRenamePolicy());

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String M_id = (String) session.getAttribute("M_id");

		String B_category = multi.getParameter("B_category");
		String B_title = multi.getParameter("B_title");
		String B_text = multi.getParameter("B_text");
		String B_send1 = multi.getParameter("B_send1");
		String B_send2 = multi.getParameter("B_send2");
		String B_sido1 = multi.getParameter("B_sido1");
		String B_gugun1 = multi.getParameter("B_gugun1");
		int B_view = 0;
		Timestamp B_time = new Timestamp(System.currentTimeMillis());
		String B_img = multi.getFilesystemName("B_img");

		if (B_img == null) {
			B_img = "otzang_logo_top.png";
		}

		BuyDTO dto = new BuyDTO();

		dto.setM_id(M_id);
		dto.setB_category(B_category);
		dto.setB_title(B_title);
		dto.setB_text(B_text);
		dto.setB_send1(B_send1);
		dto.setB_send2(B_send2);
		dto.setB_sido1(B_sido1);
		dto.setB_gugun1(B_gugun1);
		dto.setB_view(B_view);
		dto.setB_time(B_time);
		dto.setB_img(B_img);

		BuyDAO dao = new BuyDAO();
		dao.insertBuyBoard(dto);

		ActionForward forward = new ActionForward();
		forward.setPath("BuyList.buy");
		forward.setRedirect(true);

		return forward;
	}

}

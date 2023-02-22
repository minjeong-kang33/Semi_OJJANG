package com.itwillbs.sell.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.deal.db.DealDTO;
import com.itwillbs.sell.db.DealDAO;
import com.itwillbs.sell.db.SellDAO;


public class SellDeletePro implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*  게시글 삭제 deletePro */
		System.out.println("BoardDeletePro execute()");
		
		// 게시글에서 S_num(게시글 번호)을 가져옴
		int S_num = Integer.parseInt(request.getParameter("S_num"));
		
		DealDAO ddao = new DealDAO();
		// S_num(게시글 번호)을 이용하여 deal(거래내역) 테이블의 내용을 조회
		DealDTO dto=ddao.getBoard(S_num);
		
		/* deal(거래내역) 테이블에 해당 S_num(게시글 번호)이 존재하는 경우 */
		if(dto!=null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('거래중인 게시글은 삭제가 불가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		/* 글삭제 되기전 모든 유저의 찜목록에서도 삭제되도록 함 */
		SellDAO sdao = new SellDAO();
		sdao.deleteLikeSellBoard(S_num);
		sdao.deleteSellBoard(S_num);

		ActionForward forward = new ActionForward();
		forward.setPath("/Outer.sell");
		forward.setRedirect(false);
		
		return forward;
	}

}

package com.itwillbs.mypage.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.admin.db.MypageDAO;
import com.itwillbs.buy.db.BuyDTO;
import com.itwillbs.member.action.Action;
import com.itwillbs.member.action.ActionForward;
import com.itwillbs.sell.db.SellDTO;

public class Writehistory implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Writehistory execute()");
		HttpSession session=request.getSession();
		String M_id=(String)session.getAttribute("M_id");
		MypageDAO dao=new MypageDAO();
		
		ArrayList<BuyDTO> WriteHistoryB2=dao.WriteHistoryB2(M_id);
		ArrayList<SellDTO> WriteHistoryS2=dao.WriteHistoryS2(M_id);
		
		
		// 이동
		ActionForward forward=new ActionForward();
		forward.setPath("Mypage/WriteHistory.jsp");
		forward.setRedirect(false);
		return forward;
	}

}

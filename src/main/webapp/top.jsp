<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="assets/css/logout.css" rel="stylesheet" type="text/css">
<link href="assets/css/top.css" rel="stylesheet" type="text/css">
<header class="header-area header-sticky">
	<!-- 로그인/회원가입 -->


	<!--    로그인/회원가입끝 -->
	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav class="main-nav" >
					<!-- ***** 로고 시작 ***** -->
					<a href="Main.me" class="logo"> <img src="assets/images/otzang_logo_top.png" height="60px" style="display: flex !important">
					</a>
					<!-- ***** 로고 끝 ***** -->

					<%
                 String M_id = (String) session.getAttribute("M_id");
            MemberDTO dto = new MemberDTO();
               %>

					<ul class="nav23" style="margin-right: 10px; width: 500px;">

						<%
                  if(M_id != null){
               %>
						<li style="color: #434242; margin-right: 10px;"><%=M_id%> 님 
					|  <a href="MemberLogout.me" id="top_logout"
							style="color: #434242; margin-left: 7px;">로그아웃</a><%
                  } else {
               %> <a href="MemberLoginForm.me" id="top_login"
							style="color: #434242">로그인</a> 
                  
                | <a href="MemberJoinForm.me" id="top_logout"
							style="color: #434242; margin-left: 7px;">회원가입</a></li> <%
                  }%>
					</ul>


					<ul class="nav" style="margin-bottom: 15px;">
						<li><a href="Main.me" class="active">홈</a></li>
					<%

                  if(!"admin".equals(M_id)){
                     //admin이면 안보이게 
               %>

						<li><a href="Outer.sell">아우터</a></li>
						<li><a href="Shirts.sell">상의</a></li>
						<li><a href="Pants.sell">하의</a></li>
						<li><a href="Dress.sell">원피스</a></li>
						<li><a href="BuyList.buy">삽니다</a></li>

						<%
                     }
                  if (M_id != null) {
                	  if(!"admin".equals(M_id)){
                  %>	<li><a href="Mypage.moi">마이페이지</a></li>
						<!-- <li class="submenu"><a>마이페이지</a>
							<ul>
								<li><a href="Profile.moi">프로필</a></li>
								<li><a href="Likelist.moi">찜목록</a></li>
								<li><a href="Deallist.moi">거래내역</a></li>
								<li><a href="Writehistory.moi">작성글</a></li>
								<li><a href="#">거래후기</a></li>
							</ul></li> -->

						<!-- 커뮤니티에는 링크 걸지않기 -->
						<li class="submenu"><a href="#">커뮤니티</a>
							<ul>
								<li><a href="ReviewList.rev">리뷰보기</a></li>
								<li><a
									href="javascript:void(window.open('find.ch', '판매자찾기','width=450, height=450'))">판매자찾기</a></li>
								<li><a
									href="javascript:void(window.open('box.ch', '메세지함','width=450, height=450'))">메세지함</a></li>
							</ul></li>
						<%
                	  }
                  }
                  %>
						<%
               //로그인 한 회원
               if (M_id != null) {
                  // admin 인 경우 
                  if (M_id.equals("admin")) {
               %>
               
						<li class="submenu"><a>회원관리</a>
							<ul>
								<li><a href="AdUserList.ad">전체회원목록</a></li>
								<li><a href="AdUserReportList.ad">신고회원목록</a></li>
								<li><a href="AdOutList.ad">탈퇴회원목록</a></li>
							</ul></li>
						<li class="submenu"><a>게시글관리</a>
							<ul>
								<li><a href="AdSellList.ad">판매글목록</a></li>
								<li><a href="AdBuyList.ad">구매글목록</a></li>
							</ul></li>
						<%
               }
               }

		               %>
                               
						<!-- 고객센터에는 링크 걸지않기, 회사소개, QnA에만 걸기 -->
						<li class="submenu"><a href="#">고객센터</a>
							<ul>
								<li><a href="Introduce.buy">회사소개</a></li>
               <%
               if(!"admin".equals(M_id)){
                   //admin이면 안보이게 
               %>
								<li><a
									href="javascript:void(window.open('https://itwillbs-team1.channel.io/support-bots/59647', '챗봇'))">QnA</a></li>
				<%
                  }
               //로그인 한 회원
               if (M_id != null) {
                  // admin 인 경우 
                  if (M_id.equals("admin")) {
               %>
								<li><a
									href="javascript:void(window.open('https://desk.channel.io/#/channels/122669/team_chats/direct_chats/719627', '챗봇'))">QnA</a></li>
				<%
                  }
					%>
							</ul></li>
					</ul>
				<%
                  }
                  %>
					<!-- **** 로그인 안 한 회원 메뉴 끝 **** -->

					<!-- ***** 상단 바 메뉴 끝 ***** -->
				</nav>
			</div>
		</div>
	</div>
</header>

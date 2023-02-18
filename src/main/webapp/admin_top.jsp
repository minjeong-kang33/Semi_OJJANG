<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="assets/css/top.css" rel="stylesheet" type="text/css">
<header class="header-area header-sticky">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav class="main-nav">
					<!-- ***** 로고 시작 ***** -->
					<a href="AdMain.me" class="logo"> <img
						src="assets/images/otzang_logo_top.png" height="60px">
					</a>
					<!-- ***** 로고 끝 ***** -->
					
					<%
					String M_id=(String)session.getAttribute("M_id");
					
					%>	
						<ul class="nav23">
							<li>관리자 님  |
							<a href="MemberLogout.me" id="top_logout" style="color: #434242">로그아웃</a></li>	
						</ul>
					
					
					<!-- ***** 상단 바 메뉴 시작 ***** -->
					<ul class="nav">
						<li><a href="AdMain.me" class="active">홈</a></li>
						<li class="submenu"><a>회원관리</a>
							<ul>
								<li><a href="AdUserList.ad">일반회원목록</a></li>
								<li><a href="AdUserReportList.ad">신고회원목록</a></li>
								<li><a href="AdOutList.ad">탈퇴회원목록</a></li>
							</ul></li>
						<li class="submenu"><a>게시글관리</a>
							<ul>
								<li><a href="AdSellList.ad">판매글목록</a></li>
								<li><a href="AdBuyList.ad">구매글목록</a></li>
							</ul></li>
					</ul>
					<!-- ***** 상단 바 메뉴 끝 ***** -->
				</nav>
			</div>
		</div>
	</div>
</header>


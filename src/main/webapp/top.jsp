<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<link href="assets/css/logout.css" rel="stylesheet" type="text/css">
<header class="header-area header-sticky">
<!-- 로그인/회원가입 -->
  <%
String M_id=(String)session.getAttribute("M_id");
MemberDTO dto=new MemberDTO();
if(M_id != null){
			%>			
<div id="logout" class=logout><%=M_id%> 님 | 
                <a href="MemberLogout.me">로그아웃</a> </div>			
			<%
}else{
	%>
<div id="logout" class=logout><a href="MemberLoginForm.me">로그인</a> | 
                <a href="MemberJoinForm.me">회원가입</a></div>	
	<%		
}
%>

<!--    로그인/회원가입끝 -->
   <div class="container">
      <div class="row">
         <div class="col-12">
            <nav class="main-nav">
            
               <!-- ***** 로고 시작 ***** -->
               <a href="../home/main.jsp" class="logo"> 
               <img src="assets/images/otzang_logo_top.png" height="60px">
               </a>
               <!-- ***** 로고 끝 ***** -->
               
               
               <!-- ***** 상단 바 메뉴 시작 ***** -->
               <ul class="nav">
                  <li><a href="Main.me" class="active">홈</a></li>
                  <li><a href="Outer.sell">아우터</a></li>
                  <li><a href="Shirts.sell">상의</a></li>
                  <li><a href="Pants.sell">하의</a></li>
                  <li><a href="Dress.sell">원피스</a></li>
                  <li><a href="BuyList.buy">삽니다</a></li>
                  
                  
<!-- **** 로그인 한 경우에만 보이는 메뉴 시작 **** -->                  
				<%
								/* 로그인 한 경우 */
					if(M_id != null){
					
				%>
					<li class="submenu"><a>마이페이지</a>
                     <ul>
                        <li><a href="Profile.moi">프로필</a></li>
                        <li><a href="Likelist.moi">찜목록</a></li>
                        <li><a href="Sellhistory.moi">판매내역</a></li>
                        <li><a href="Buyhistory.moi">구매내역</a></li>
                        <li><a href="Writehistory.moi">작성글 내역</a></li>
                        <li><a href="#">거래후기</a></li>
                     </ul></li>
                     
                     <!-- 커뮤니티에는 링크 걸지않기 -->
                   <li class="submenu"><a href="#">커뮤니티</a>
                      <ul>
                      	 <li><a href="ReviewList.rev">리뷰보기</a></li>	
      					 <li><a href="javascript:void(window.open('find.ch', '판매자찾기','width=400, height=400'))">판매자찾기</a></li>
						 <li><a href="javascript:void(window.open('box.ch', '메세지함','width=400, height=400'))">메세지함</a></li>
                     </ul>
                   </li>   
                   	
                   	<!-- 고객센터에는 링크 걸지않기, 회사소개, QnA에만 걸기 -->
                  <li class="submenu"><a href="#">고객센터</a>
                     <ul>
                        <li><a href="#">회사소개</a></li>
                        <li><a href="#">QnA</a></li>
                     </ul>
                  </li>	
                  	


<!-- **** 로그인 안 한 경우에만 보이는 메뉴 시작 **** -->                     
				<%
					}else{
				%>
				<!-- 고객센터에는 링크 걸지않기, 회사소개, QnA에만 걸기 -->
				<li class="submenu"><a href="#">고객센터</a>
                     <ul>
                        <li><a href="#">회사소개</a></li>
                        <li><a href="#">QnA</a></li>
                        <li><a href="MemberLoginForm.me">임시로그인</a></li>
                     </ul>
                </li>
				<%		
				}
				%>
				</ul>
<!-- **** 로그인 안 한 경우에만 보이는 메뉴 끝 **** -->
         
               <!-- ***** 상단 바 메뉴 끝 ***** -->
            </nav>
         </div>
      </div>
   </div>
</header>

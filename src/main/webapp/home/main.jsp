<%@page import="com.itwillbs.admin.db.MypageDAO"%>
<%@page import="com.itwillbs.like.db.LikeDTO"%>
<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="com.itwillbs.sell.db.SellDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
   <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="assets/css/owl-carousel.css">
    <link rel="stylesheet" href="assets/css/lightbox.css"> 
    <link href="assets/css/main.css" rel="stylesheet" type="text/css">
    <link href="assets/css/main_searchbar.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
</head>
<body>
<%
String M_id = (String)session.getAttribute("M_id");
%>
    <!-- ***** 챗봇 ***** -->
	<script>
	(function (){var w=window;if(w.ChannelIO){return w.console.error("ChannelIO script included twice.")}var ch=function(){ch.c(arguments)};ch.q=[];ch.c=function(args){ch.q.push(args)};w.ChannelIO=ch;function l(){if(w.ChannelIOInitialized){return}w.ChannelIOInitialized=true;var s=document.createElement("script");s.type="text/javascript";s.async=true;s.src="https://cdn.channel.io/plugin/ch-plugin-web.js";var x=document.getElementsByTagName("script")[0];if(x.parentNode){x.parentNode.insertBefore(s,x)}}if(document.readyState==="complete"){l()}else{w.addEventListener("DOMContentLoaded",l);w.addEventListener("load",l)}})();
	ChannelIO('boot', {"pluginKey": "b1f192f2-a03b-4a57-befd-365e5a60d32f"});
	</script>
    <!-- ***** 챗봇 끝 ***** -->
    
    <!-- ***** 팝업창 시작 ***** -->
        <script>
function setCookie( name, value, expiredays ) {
	var todayDate = new Date();
	todayDate.setDate( todayDate.getDate() + expiredays );
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";"
}

function getCookie( name ) {
	var nameOfCookie = name + "=";
	var x = 0;
	while ( x <= document.cookie.length ) {
	var y = (x+nameOfCookie.length);
		if ( document.cookie.substring( x, y ) == nameOfCookie ) {
		if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
		endOfCookie = document.cookie.length;
			return unescape( document.cookie.substring( y, endOfCookie ) );
		}
	x = document.cookie.indexOf( " ", x ) + 1;
	if ( x == 0 )
	break;
	}
	return "";
}

if ( getCookie( "popup2" ) != "done" ) {
	noticeWindow =
	window.open('Popup2.ad','popup2','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=310,height=510,top=90,left=200');
	//경로 수정?
	noticeWindow.opener = self;
}


</script>
	<!-- ***** 팝업창 끝 ***** -->
    
    <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
   <!-- ***** 배너 시작 ***** -->
    <div class="page-heading about-page-heading" id="top">
        <div class="container">
             <div class="inner-content2">
                <img src="assets/images/banner_img.png" width="100%" >
             </div>
        </div>
    </div>
<!--     ***** 배너 끝 ***** -->

 <!-- ***** 검색창 시작 ***** -->
 <!-- assets/css/main_searchbar.css: 검색창용 css -->
 <form class="search-container" action="Main.me" method="post">
    <input type="text" id="search-bar" placeholder="찾으시는 상품이 있나요?" value="${param.search}" name="search">
    <input type="image" class="search-icon" src="http://www.endlessicons.com/wp-content/uploads/2012/12/search-icon.png" >
    </form>
 <!-- ***** 검색창 끝 ***** -->


<!-- ***** 최신 판매글 시작 ***** -->
<!-- 최신판매/검색글 -->
<%
request.setCharacterEncoding("UTF-8");
String search =request.getParameter("search");
if(search==null){
	%>
	<section class="section" id="men">
    	<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading" style="text-align: center;">
						<h2>최신 판매글</h2>
						<span>recent posts</span>
					</div>
				</div>
			</div>
		</div>
<%}else{ %>
		 <section class="section" id="men">
    	<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading" id="find" style="text-align: center;">
						<h2>검색결과</h2>
						<span>search result</span>
					</div>
				</div>
			</div>
		</div>
	<%
}
%> 	
        <div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="item">
						<div class="down-content">
<%	
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
ArrayList<SellDTO> sellList=(ArrayList<SellDTO>)request.getAttribute("sellList");

int currentPage=(Integer)request.getAttribute("currentPage");
int startPage=(Integer)request.getAttribute("startPage");
int pageBlock=(Integer)request.getAttribute("pageBlock");
int endPage=(Integer)request.getAttribute("endPage");
int pageCount=(Integer)request.getAttribute("pageCount");
	%>						
<table>
	<tr>
	<%
	for(int i=0; i<sellList.size();i++){
		SellDTO dto = sellList.get(i);
	%>
		<td>
			<table class="item-table">
				<tr>
					<td colspan="2" class="S_img"><a href="SellDetails.sell?S_num=<%=dto.getS_num()%>" >
						<img src="img/sell/<%=dto.getS_img() %>" width=300px height=300px class="goodsImg"></a></td>
				</tr>
				<tr>
					<td class="S_category" > <%=dto.getS_category()%></td> <td align="right" class="like_id"> 
						<% MypageDAO dao=new MypageDAO();
						   LikeDTO getLikeDto=dao.getLike(M_id, dto.getS_num());
						   if(getLikeDto==null){ %>
							<input type="image" name="button" class="heart" src="sell/heart.png" onclick="location.href='LikePro.like?S_num=<%=dto.getS_num() %>'">
							<%
						   } else {
						   %>
						   <input type="image" name="button" class="heart" src="sell/fullheart.png" onclick="location.href='LikePro.like?S_num=<%=dto.getS_num() %>'">
							<%
						   }
							%>
				</tr>
				<tr>
					<td class="S_title" ><a href="SellDetails.sell?S_num=<%=dto.getS_num()%>" > <b><%=dto.getS_title()%></b></a></td> <!-- 제목 -->
				</tr>
				<tr>
					<td class="price"><%=dto.getS_price()%>원</td>
				</tr>
				<tr>
					<td colspan="2" class="S_createdate" ><%= dateFormat.format(dto.getS_createdate())+" 작성"%></td> <!-- 게시글 생성일자 -->
				</tr>
				<tr>
					<td colspan="2" class="S_send"> <% if(dto.getS_send1()!=null&&dto.getS_send2()!=null){%> <%= "<b>택배거래</b>, <b>직거래</b>"%><%}
						else if(dto.getS_send1()!=null){%> <%= "<b>택배거래</b>"%><%}
						else if(dto.getS_send2()!=null){%> <%= "<b>직거래</b>"%><%}%> </td> <!-- 선호거래유형 -->
				</tr>
				<tr>
					<td colspan="2"> <% if(dto.getS_send2()!=null){%> <img src="sell/location_icon.png" class="location"><%= dto.getS_sido1()%><%} else { %>　<%}%> </td>
					<!-- else에 안보이는 공백문자있어요 지우지마세요 지우면 정렬깨짐 -->
				</tr>
			</table>
		</td>		
			<%
			if((i+1) %3 ==0){
			%>
				</tr>
				<tr>
				
			<%
			 }
			%>
	<%
	 }
	%>	
	
</tr>
</table>
      
<!-- 게시판 내용 여기 넘어가면 안됨.  -->							
					</div>
					</div>
				</div>
			</div>
		</div> 
	</section>
<!-- ***** 최신 판매글 끝 ***** -->
<!-- 페이징처리 -->
<div style="text-align : center;">
<%
if(search!=null){
%>
	 
<%	 
if(currentPage > 1){
%>
	<a href="Main.me?pageNum=<%=currentPage-1%>&search=<%=search%>">[1페이지 이전]</a> 
<%
}
%>
<%
for(int i=startPage;i<=endPage;i++){
%>
	<a href="Main.me?pageNum=<%=i%>&search=<%=search%>"><%=i %></a> 
<%
}
%>

<%
if(currentPage < pageCount){
	%>
<a href="Main.me?pageNum=<%=currentPage+1%>&search=<%=search%>">[1페이지 다음]</a>
<%
}
%>
<%
}
%>
</div>

<!-- 페이징처리 끝 -->
    <!-- ***** 푸터 시작 ***** -->
   <jsp:include page="../bottom.jsp" />
    <!-- ***** 푸터 끝 ***** -->

 <!-- jQuery -->
    <script src="assets/js/jquery-2.1.0.min.js"></script>

 <!--  Bootstrap -->
    <script src="assets/js/popper.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

 <!-- Plugins -->
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/accordions.js"></script>
    <script src="assets/js/datepicker.js"></script>
    <script src="assets/js/scrollreveal.min.js"></script>
    <script src="assets/js/waypoints.min.js"></script>
    <script src="assets/js/jquery.counterup.min.js"></script>
    <script src="assets/js/imgfix.min.js"></script> 
    <script src="assets/js/slick.js"></script> 
    <script src="assets/js/lightbox.js"></script> 
    <script src="assets/js/isotope.js"></script> 
    
<!-- Global Init -->
    <script src="assets/js/custom.js"></script>

    <script>

        $(function() {
            var selectedClass = "";
            $("p").click(function(){
            selectedClass = $(this).attr("data-rel");
            $("#portfolio").fadeTo(50, 0.1);
                $("#portfolio div").not("."+selectedClass).fadeOut();
            setTimeout(function() {
              $("."+selectedClass).fadeIn();
              $("#portfolio").fadeTo(50, 1);
            }, 500);
                
            });
        });

    </script> 

  </body>
</html>
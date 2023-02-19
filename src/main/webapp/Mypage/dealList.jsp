

<%@page import="com.itwillbs.deal.db.DealDAO"%>
<%@page import="com.itwillbs.admin.db.MypageDAO"%>
<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="com.itwillbs.deal.db.DealDTO"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
    
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>중고의류거래: 옺장</title>
   <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="assets/css/owl-carousel.css">
    <link rel="stylesheet" href="assets/css/lightbox.css"> 
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>
</head>
<body>
    <body>
     <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
    <div class="page-heading about-page-heading" id="top">
        <div class="container">
             <div class="inner-content2">
            
 <!-- ***** 거래내역 시작***** -->
    

<!-- ***** 구매내역 시작***** -->
    
    <h3>구매내역조회</h3>
    
    
<%
String M_id=(String)session.getAttribute("M_id");
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");

// DealDTO dto=new DealDTO();
// SellDTO sdto=new SellDTO();
// DealDAO ddao=new DealDAO();
// MypageDAO dao=new MypageDAO();
// ArrayList<DealDTO> dealListB=ddao.dealListB(M_id);
// ArrayList<SellDTO> dealListS=dao.dealListS(M_id);

int currentPage=(Integer)request.getAttribute("currentPage");
int startPage=(Integer)request.getAttribute("startPage");
int pageBlock=(Integer)request.getAttribute("pageBlock");
int endPage=(Integer)request.getAttribute("endPage");
int pageCount=(Integer)request.getAttribute("pageCount");


ArrayList<SellDTO> dealListS1=(ArrayList<SellDTO>)request.getAttribute("dealListS1");
ArrayList<DealDTO> dealListB1=(ArrayList<DealDTO>)request.getAttribute("dealListB1");


%>	

<section>
<table border="1">
<tr><td>판매자</td><td>판매글제목</td><td>구매가격</td><td>카테고리</td><td>구매자</td><td>거래날짜</td></tr>


<%
for(int i=0;i<dealListB1.size();i++){
 	SellDTO sdto=dealListS1.get(i);
	DealDTO dto=dealListB1.get(i);
%>
	<tr>
		<td><%=sdto.getM_id() %></td>
		<td><a href="SellDetails.sell?S_num=<%=sdto.getS_num() %>">
		<%=sdto.getS_title() %></a></td>
		<td><%=sdto.getS_price() %></td>
		<td><%=sdto.getS_category() %></td>
		<td><%=dto.getD_buy() %></td>
		<td><%=dateFormat.format(dto.getD_date()) %></td>				
	</tr>
	
<%
}
%>
</table>
	<!-- ***** 구매내역 끝 ***** -->
	
	
<!-- ***** 구매내역 페이징 시작 ***** -->	
<%
if(currentPage > 1){
	%>
	<a href="Deallist.moi?pageNum=<%=currentPage-1%>">[1페이지 이전]</a>
	<%
}

for(int i=startPage;i<=endPage;i++){
	%>
	<a href="Deallist.moi?pageNum=<%=i%>"><%=i %></a> 
	<%
}
if(currentPage < pageCount){
	%>
	<a href="Deallist.moi?pageNum=<%=currentPage+1%>">[1페이지 다음]</a>
	<%
}

%>
</section>
<!-- ***** 구매내역 페이징 끝 ***** -->	


 <!-- ***** 판매내역조회 시작***** -->
    
    <h3>판매내역조회</h3>
<%

// DealDTO dto=new DealDTO();
// SellDTO sdto=new SellDTO();
// MypageDAO dao=new MypageDAO();
// ArrayList<DealDTO> dealHistory=dao.dealHistory(M_id);
// ArrayList<SellDTO> sellHistory=dao.sellHistory(M_id);

int currentPage1=(Integer)request.getAttribute("currentPage1");
int startPage1=(Integer)request.getAttribute("startPage1");
int pageBlock1=(Integer)request.getAttribute("pageBlock1");
int endPage1=(Integer)request.getAttribute("endPage1");
int pageCount1=(Integer)request.getAttribute("pageCount1");

ArrayList<SellDTO> sellHistory1=(ArrayList<SellDTO>)request.getAttribute("sellHistory1");
ArrayList<DealDTO> dealHistory1=(ArrayList<DealDTO>)request.getAttribute("dealHistory1");
%>	
<section>
<table border="1">
<tr><td>판매글제목</td><td>판매가격</td><td>카테고리</td><td>구매자</td><td>거래날짜</td></tr>

<%
// System.out.println(dealListS.size());
// System.out.println(dealListB.size());
for(int i=0;i<dealHistory1.size();i++){
 	DealDTO dto=dealHistory1.get(i);
	SellDTO sdto=sellHistory1.get(i);
	
%>

	<tr>
		<td><a href="SellDetails.sell?S_num=<%=sdto.getS_num() %>">
		<%=sdto.getS_title() %></a></td>
		<td><%=sdto.getS_price() %></td>
		<td><%=sdto.getS_category() %></td>
		<td><%=dto.getD_buy() %>
		<td><%=dateFormat.format(dto.getD_date()) %></td>
		
	</tr>

<%
}
%>
	</table>
	
	<!-- ***** 판매내역조회 끝 ***** -->
	
<!-- ***** 판매내역 페이징 시작 *****	 -->
	
	<%
if(currentPage1 > 1){
	%>
	<a href="Deallist.moi?pageNum1=<%=currentPage1-1%>">[1페이지 이전]</a>
	<%
}

for(int i=startPage1;i<=endPage1;i++){
	%>
	<a href="Deallist.moi?pageNum1=<%=i%>"><%=i %></a> 
	<%
}
if(currentPage1 < pageCount1){
	%>
	<a href="Deallist.moi?pageNum1=<%=currentPage1+1%>">[1페이지 다음]</a>
	<%
}

%>
</section>

<!-- ***** 판매내역 페이징 끝 ***** -->	


 <!-- ***** 거래내역 끝***** -->



	       
             </div>
        </div>
    </div>     <!-- ***** 푸터 시작 ***** -->
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
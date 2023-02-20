<%@page import="com.itwillbs.deal.db.DealDAO"%>
<%@page import="com.itwillbs.admin.db.MypageDAO"%>
<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="com.itwillbs.deal.db.DealDTO"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
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
    
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>
</head>
<body>
<%
String M_id=(String)session.getAttribute("M_id");
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");

int currentPage=(Integer)request.getAttribute("currentPage");
int startPage=(Integer)request.getAttribute("startPage");
int pageBlock=(Integer)request.getAttribute("pageBlock");
int endPage=(Integer)request.getAttribute("endPage");
int pageCount=(Integer)request.getAttribute("pageCount");

ArrayList<SellDTO> sellHistory1=(ArrayList<SellDTO>)request.getAttribute("sellHistory1");
ArrayList<DealDTO> dealHistory1=(ArrayList<DealDTO>)request.getAttribute("dealHistory1");
%>	
     <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
	<section class="section" id="products">
		<div class="container"> 
			<div class="row"> 
				<div class="col-lg-12"> 
					<div class="section-heading"> 
					<!--  게시판제목 -->
						<h2>리뷰 내역</h2>
						<span>review list</span>
					</div>
					
						<table>
							<%
							for(int i=0;i<dealHistory1.size();i++){
							 	DealDTO dto=dealHistory1.get(i);
								SellDTO sdto=sellHistory1.get(i);
								
							%>
							<tr>
								<td rowspan="4" ><img src="img/sell/<%=sdto.getS_img() %>" class="RE_img_st" width="150px" height="150px"></td>
								<td> 제목 : <%=sdto.getS_title() %> </td>
							</tr>
							<tr>
								<td colspan="2"> 구매자 : <%=dto.getD_buy() %> </td>
							</tr>
							<tr>	
								<td> 거래가격 : <%=sdto.getS_price() %></td>
							</tr>
							<tr>
							<td> 거래완료일 : <%=dateFormat.format(dto.getD_date())%></td>
							
							</tr>
							<tr><td colspan="3" class="line"></td> <tr>
							<%
							}
							%>
							
						</table>
						</div>
				</div>
				
				<!--  페이지 번호  -->
				<%
if(currentPage > 1){
	%>
	<a href="Sellhistory.moi?pageNum1=<%=currentPage-1%>">[1페이지 이전]</a>
	<%
}

for(int i=startPage;i<=endPage;i++){
	%>
	<a href="Sellhistory.moi?pageNum1=<%=i%>"><%=i %></a> 
	<%
}
if(currentPage < pageCount){
	%>
	<a href="Sellhistory.moi?pageNum1=<%=currentPage+1%>">[1페이지 다음]</a>
	<%
}

%>
		</div>
	</section>    
    
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
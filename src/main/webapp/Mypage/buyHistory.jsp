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
    <link rel="stylesheet" href="assets/css/sellhistory.css"> 
       <link href="assets/css/sell.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
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

ArrayList<DealDTO> buyHistory=(ArrayList<DealDTO>)request.getAttribute("buyHistory");
%>	
     <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
	<section class="section" id="products">
<form action="ReviewWriteForm.rev" method="post">
		<div class="container"> 
			<div class="row"> 
				<div class="col-lg-12"> 
					<div class="section-heading"> 
					<!--  게시판제목 -->
						<h2>구매 내역</h2>
						<span>Buy list</span>
					</div>
					
						<table>
							<%
							for(int i=0;i<buyHistory.size();i++){
							DealDTO sdto=buyHistory.get(i);

						 
								
							%>
							<tr>
								<td rowspan="4"><a href="SellDetails.sell?S_num=<%=sdto.getS_num() %>">
									<img src="img/sell/<%=sdto.getS_img() %>" class="S_img_st" width="180px" height="180px"></a></td>
							<td id="SH_title"><a href="SellDetails.sell?S_num=<%=sdto.getS_num()%>"> <%=sdto.getS_title() %> </a></td>
							</tr>
							<tr>
								<td id="SH_price"><%=sdto.getS_price() %>원</td>
							</tr>
							<tr>	
								<td colspan="2" id="SH_buyer"> 판매자 : <%=sdto.getM_id() %></td>
							</tr>
							<tr>
							<td id="SH_date"> 거래완료일 : <%=dateFormat.format(sdto.getD_date())%>
							<td><input type="submit" class="btn btn-dark" value="리뷰쓰기"> </td></td>
							
							</tr>
							<tr><td colspan="3" class="line"></td> <tr>

		</tr>
							<%
							}
							%>
							
						</table>
</form>
						<hr>
						</div>
				</div>
				
				<!--  페이지 번호  -->
				<%


for(int i=startPage;i<=endPage;i++){
	%>
	<a href="Buyhistory.moi?pageNum1=<%=i%>"><%=i %></a> 
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
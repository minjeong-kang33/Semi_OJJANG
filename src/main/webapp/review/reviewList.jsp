<%@page import="com.itwillbs.review.db.reviewDTO"%>
<%@page import="com.itwillbs.review.db.reviewDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
    <link rel="stylesheet" href="assets/css/owl-carousel.css">
    <link rel="stylesheet" href="assets/css/lightbox.css"> 
   <link href="assets/css/reviewWriteList.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>

   <script type="text/javascript">     

    </script>
    
</head>

   <body>
   
   
   <%
  
ArrayList<reviewDTO> reviewList = (ArrayList<reviewDTO>)request.getAttribute("reviewList");
int currentPage = (Integer)request.getAttribute("currentPage");
int startPage = (Integer)request.getAttribute("startPage");
int pageBlock = (Integer)request.getAttribute("pageBlock");
int endPage = (Integer)request.getAttribute("endPage");
int pageCount = (Integer)request.getAttribute("pageCount");

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

%>

    <!-- ***** 로딩 일단 지금은 비어있음***** -->
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>  
    .
    <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->

	<section class="section" id="products">


		<!-- 게시판 제목  -->
		<div class="container" style="padding:0 0;">
			<div class="row" style="margin-left:0;">
				<div class="col-lg-12" style="margin-left:0;">
					<div class="section-heading">
						<h2>리뷰</h2>
						<span>review</span>
					</div>
				</div>
			</div>
		</div>

		<div class="container" style="padding:0 0;">
			<div class="row" style=" padding:0 0;">
				<div class="col-lg-4" style="padding:0 0;">
					<div class="item" style="padding:0 0;" >
						<div class="down-content" style="width: 800px; padding:0 0;">


					<!--  리뷰작성 입력상자 시작 -->
						<table >
							<%
							
							for(int i=0; i<reviewList.size();i++){
								reviewDTO dto = reviewList.get(i);
								
							%>
							<tr>
								<td rowspan="4" ><img src="img/review/<%=dto.getRE_img1() %>" class="RE_img_st"></td><td> <b>제목</b> : <%=dto.getRE_title() %> </td>
								<td align="right"> <b>작성일</b> : <%=dateFormat.format(dto.getRE_createtime())%></td>
							</tr>
							<tr>
								<td colspan="2"> <b>글쓴이</b> : <%=dto.getRE_writer() %> </td>
							</tr>
							<tr>	
								<td colspan="2"> <b>내용</b> : <%=dto.getRE_text() %> </td>
							</tr>
							<tr>
								<td colspan="2" ">
									
									<span class="tag1" style="font-size: 15px; color: white; float:left; margin-right: 3px;"> <% if(dto.getRE_delivery()!=null){%> <%=dto.getRE_delivery()%> <%}%> </span>
									<span class="tag1" style="font-size: 15px; color: white; float:right; margin-right: 100px;"> <% if(dto.getRE_manner()!=null){%> <%=dto.getRE_manner()%> <%}%> </span>
									<span class="tag1" style="font-size: 15px; color: white; float:left;"> <% if(dto.getRE_ProductStatus()!=null){%> <%=dto.getRE_ProductStatus()%> <%}%></span>
									<span class="tag1" style="font-size: 15px; color: white; float:right; margin-right: 100px;"> <% if(dto.getRE_fast()!=null){%> <%=dto.getRE_fast()%> <%}%> </span>
									<span class="tag1" style="font-size: 15px; color: white; float:left;"> <% if(dto.getRE_time()!=null){%> <%=dto.getRE_time()%> <%}%> </span>
								
								</td> 
							</tr>
							<tr>
							</tr>
							<tr><td colspan="3" class="line"></td> <tr>
							<%
							}
							%>
							
						</table>
			<div style="width: 1000px; margin-top: 20px;">					
				<!--  페이지 번호  -->
				<%
				
				
				for(int i=startPage;i<=endPage;i++){
					%>
					<a href="ReviewList.rev?pageNum=<%=i%>"><%=i%></a>
					<%
				}
				
				%>
			</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

	<!-- ***** 푸터 시작 ***** -->
<jsp:include page="../bottom.jsp" />
    <!-- ***** 푸터 끝 ***** -->

 <!-- jQuery -->
    <script src="assets/js/jquery-2.1.0.min.js">
    </script>

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
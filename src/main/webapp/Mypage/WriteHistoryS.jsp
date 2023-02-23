<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="com.itwillbs.admin.db.MypageDAO"%>
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
    <link href="assets/css/buy.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
</head>
<body>
     <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    

            
 <!-- ***** 작성글 조회(판매) 시작 ***** -->
    
<%
String M_id=(String)session.getAttribute("M_id");
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
int currentPage=(Integer)request.getAttribute("currentPage");
int startPage=(Integer)request.getAttribute("startPage");
int pageBlock=(Integer)request.getAttribute("pageBlock");
int endPage=(Integer)request.getAttribute("endPage");
int pageCount=(Integer)request.getAttribute("pageCount");
ArrayList<SellDTO> sellList=(ArrayList<SellDTO>)request.getAttribute("sellList");
%>	
<section class="section" id="products" style="width: 2000px;">
		<!-- 게시판 제목  -->
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section-heading">
						<h2 style="margin-top: 180px;">나의 판매글</h2>
						<span>sell</span>
					</div>
				</div>
			</div>
		</div>

		<div class="container" style=" width:100%; padding: 0;">
			<div class="row">
				<div class="col-lg-4">
					<div class="item" style="padding:0;">

						<!-- board list area -->
						<div id="board-list" style="width: 1200px;float: left; padding:0; margin-right: 40px;">
							<table class="board-table" style="float: left; margin-bottom: 30px;">
								<thead>
									<tr>
										<th scope="col" class="th-titles">제목</th>
										<th scope="col" class="th-prices">가격</th>
										<th scope="col" class="th-categorys">카테고리</th>
										<th scope="col" class="th-likes">좋아요</th>
										<th scope="col" class="th-titles">조회수</th>
										<th scope="col" class="th-dates">등록일</th>
										<th scope="col" class="th-want">구매희망자 확인 / 거래완료</th>
									</tr>
								</thead>
								<tbody>
									<%
								for(int i=0;i<sellList.size();i++){
	SellDTO dto=sellList.get(i);
									%>
									<tr>
										<td><a href="SellDetails.sell?S_num=<%=dto.getS_num() %>">
		<%=dto.getS_title() %></a></td>
										<td><%=dto.getS_price() %></td>
										<td><%=dto.getS_category() %></td>
										<td><%=dto.getS_like() %></td>
	<td><%=dto.getS_view() %></td>
	<td><%=dateFormat.format(dto.getS_createdate()) %></td>
	<td><a href="javascript:void(window.open('DealWantList.deal?S_num=<%=dto.getS_num()%>', '희망자리스트', 'width=500, height=400,left=500, top=200' ))">
		<input type="button" value="확인하기" style="background-color:#704A00; color:white; border:none; border-radius: 7px; padding: 3px 7px" ></a>	</td>						
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
	
	<!-- ***** 작성글 조회(구매) 끝 ***** -->
	<div style="margin-top: 30px;">
<!-- 	페이징 시작 -->
<%

for(int i=startPage;i<=endPage;i++){
	%>
	<a href="WritehistoryS.moi?pageNum=<%=i%>"><%=i %></a> 
	<%
}

%>

 						</div>
					</div>
             </div>
        </div>
    </div>
<!-- 페이징 끝 -->
</section>
	<!-- ***** 작성글 조회(판매)페이징 끝 ***** -->


	       
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
    <script src="../assets/js/custom.js"></script>

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
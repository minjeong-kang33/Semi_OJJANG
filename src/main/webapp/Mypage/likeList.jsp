
<%@page import="com.itwillbs.sell.db.SellDTO"%>
<%@page import="com.itwillbs.admin.db.MypageDAO"%>
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
<title>중고 의류거래: 옺장 - 리뷰작성</title>

   <script type="text/javascript">     

    </script>
    
</head>

   <body>
   
   
<%
String M_id=(String)session.getAttribute("M_id");
// LikeDTO dto=new LikeDTO();
MypageDAO dao=new MypageDAO();
SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");

int currentPage=(Integer)request.getAttribute("currentPage");
int startPage=(Integer)request.getAttribute("startPage");
int pageBlock=(Integer)request.getAttribute("pageBlock");
int endPage=(Integer)request.getAttribute("endPage");
int pageCount=(Integer)request.getAttribute("pageCount");

ArrayList<SellDTO> likeList=(ArrayList<SellDTO>)request.getAttribute("likeList");
// SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd");
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
		<div class="container"> <!--  댓글부분  -->
			<div class="row"> <!--  글쓰기 버튼  -->
				<div class="col-lg-12"> <!--  테이블부분 -->
					<div class="section-heading"> <!--  테이블 제목부분 -->
					<!--  게시판제목 -->
						<h2>찜내역</h2>
						<span>like list</span>
					</div>
					
					<!--  찜리스트 시작 -->
						<table>
							<%
							
							for(int i=0;i<likeList.size();i++){
							 	SellDTO dto=likeList.get(i);
								
							%>
							<tr>
								<td rowspan="4" ><img src="img/sell/<%=dto.getS_img() %>" class="Like_img_st"></td>
															<tr>	
								<td colspan="2"> 제목 : <a href="SellDetails.sell?S_num=<%=dto.getS_num() %>">
														<%=dto.getS_title() %></a> </td>
							</tr>
								<td align="right"> 판매자 : <%=dto.getM_id() %></td>
							</tr>
							<tr>
								<td colspan="2"> 카테고리 : <%=dto.getS_category() %> </td>
							</tr>

							<tr>	
								<td colspan="2"> 내용 : <%=dto.getS_text() %> </td>
							</tr>
							<tr>
								<td colspan="2"> 가격: <%=dto.getS_price() %> </td>
							</tr>
							<tr>
							</tr>
							<tr><td colspan="3" class="line"></td> <tr>
							<%
							}
							%>
							
						</table>
				</div>
				
				<!-- 찜 리스트 끝 -->
				
				<!--  페이지 번호  -->
				<%
				
				
				for(int i=startPage;i<=endPage;i++){
					%>
					<a href="LikePro.like?pageNum=<%=i%>"><%=i%></a>
					<%
				}
				
				%>
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
<%@page import="com.itwillbs.comment.db.CommentDTO"%>
<%@page import="com.itwillbs.comment.db.CommentDAO"%>
<%@page import="com.itwillbs.buy.db.BuyDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
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
   <link href="assets/css/buyDetails.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>

<script type="text/javascript">

function fun1(M_id, B_num, R_category, B_title) {
	var _width = '460';
	var _height = '340';
	var _left = Math.ceil((window.screen.width - _width) / 2);
	var _top = Math.ceil((window.screen.height - _height) / 2);
    window.open("ReportForm.rpt?R_id=" + M_id + "&R_writeNum="
          + B_num + "&R_category=" + "buy" + "&R_title=" + B_title,
          "pop",'width='+ _width+ ', height='+ _height+ ', left='+ _left+ ', top='+ _top);
 }
 
</script>
</head>
    <body>
    <!-- ***** 로딩 일단 지금은 비어있음***** -->
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>  
    
    <!-- ***** 헤더 ***** -->
  <jsp:include page="../top.jsp" />
    <!-- ***** 헤더 끝 ***** -->
    
<%

int B_num = Integer.parseInt(request.getParameter("B_num"));
String M_id = (String)session.getAttribute("M_id");
BuyDTO dto = (BuyDTO)request.getAttribute("dto");
CommentDAO comment=new CommentDAO();
CommentDAO commentdto=new CommentDAO();
int pageNumber = (Integer)request.getAttribute("pageNumber");
ArrayList<CommentDTO>List=comment.getList(B_num, pageNumber);

SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
%>


	<section class="section" id="products">
		<!-- 게시판 제목  -->
		<div class="container" style="height: 1500px; ">
			<div class="row">
				<div class="col-lg-12">
					<div class="aa"></div>
					<div class="section-heading">
						<h2 style="margin-top: 180px">삽니다</h2>
						<span>buy</span>
					</div>
				 <!--  폼 추가했어요!!~!~!~!~!~!~! 데이터 넘기기 편하시라고.... -->
					
					
					<div class="item-box1">
					
					<!-- 상품이미지 -->
					<div class="item-img">
						<% if (dto.getB_img() == null) {%>
						<img src="img/buy/ozzangbuy.png" class="goodsImg">
						<%} else {%>
						<img src="img/buy/<%=dto.getB_img()%>" class="goodsImg">
						<%}%>
					</div>
					
					
					<!-- 상품정보 -->
					<div class="item-info"> 
					   <div class="item-info2">
					   		<!--  카테고리 -->
							<span class="info-category"> <%=dto.getB_category()%> 
							
							<!--  좋아요, 찜하기 -->
							<span class="info-like">  
							</span></span><br> 
							<span class="info-title"><%=dto.getB_title()%></span> <br> <!-- 글제목 -->
							<span class="info-price"></span> <!-- 가격 -->
							
							<hr><!-- 가로줄 -->
							
							
							<!-- 거래방식  -->
							<span class="info-send"> 
								<% if(dto.getB_send1()!=null&&dto.getB_send2()!=null){%> <%= "<b>택배거래</b>, <b>직거래</b>"%><%}
														 else if(dto.getB_send1()!=null){%> <%= "<b>택배거래</b>"%><%}
														 else if(dto.getB_send2()!=null){%> <%= "<b>직거래</b>"%><%}%>
							</span> 
							
							<!-- 조회수 -->
							<span class="info-eye"><img src="assets/images/eye.png" class="eye"><%=dto.getB_view() %></span>
						<div>
						
						<div>
							<!-- 판매자~거래일자 구분항목(왼쪽) -->
							<div class="item-info3"> 
								<div style="margin: auto 0;">
								<br>
								<span > 판매자 </span> <br><br>
								<span> 작성일자 </span> <br><br>
								<span> <% if(dto.getB_send2()!=null){%> <span> 거래 선호 지역 <%} else { %>　<%}%></span> <br><br>
								</div>
							</div>
							
							<!-- 판매자~거래일자 data(오른쪽) -->
							<div class="item-info4">
								<div style="margin: auto 0;">
									<br>
									<!-- 판매자 ID -->
									<span><%=dto.getM_id()%></span> <br><br>
									<!-- 작성일자 -->
									<span><%=dateFormat.format(dto.getB_time())%></span> <br><br>
									<!-- 거래지역 -->
									<% if(dto.getB_send2()!=null){%>
									<span class="info-location">
										<img src="sell/location_icon.png" class="location"><%= dto.getB_sido1()%> <%= dto.getB_gugun1()%><%} else { %>　<%}%></span> <br><br>
								</div>
							</div>
						</div>
							<div class="requestBox">
							
							</div>
						 </div>	 
						</div>
					</div>
					
		
					
					<!-- 판매 상세글 -->
					<div class="item-detail" >
						<div style="margin-left: 50px; float: left; width: 950px;">
							<hr> <!-- 가로줄 -->
							  <div class="item-detail-text"> 제품 상세 정보 </div> <br>
						  	<div class="textBox"><%=dto.getB_text()%></div> 
						</div>
			<div class="btn-naran">
		
				<%if (M_id != null) {
				// 세션값=id와 글쓴이가 일치해야만 글수정, 글삭제 표시
					if (M_id.equals(dto.getM_id())) {
				%>
					<input type="button" class="btn btn-dark" value="글수정"onclick="location.href='BuyEditForm.buy?B_num=<%=dto.getB_num()%>'">
					<input type="button" class="btn btn-dark" value="글삭제"onclick="location.href='BuyDelete.buy?B_num=<%=dto.getB_num() %>'">
				<%		
					}
				}
				%>
				<%
				if (M_id != null) {
					// 세션값=id와 글쓴이가 일치해야만 글수정, 글삭제 표시
					if (M_id.equals("admin")) {
				%>
					<input type="button" class="btn btn-dark" value="글삭제"onclick="location.href='AdBuyDelete2.ad?B_num=<%=dto.getB_num() %>'">
				<button type="button" class="btn btn-dark"onclick="history.back()">글목록</button>
            <%
               }
            }
                  
            if (!"admin".equals(M_id)) {
				%>
				<button type="button" class="btn btn-dark"onclick="location.href='BuyList.buy'">글목록</button>
				<%
					}
					if(M_id != null){
						//본인에게는 신고하기 안보임
						if(!M_id.equals(dto.getM_id())){
					%>

			<button type="button" class="btn btn-dark"onclick="fun1('<%=dto.getM_id()%>','<%=dto.getB_num()%>','buy','<%=dto.getB_title()%>')"style="float: right; margin-left: 5px;">신고하기</button>
				<%
					}
				}
				 %>
					<button type="button" class="btn btn-dark"onclick="location.href='BuyList.buy'">글목록</button>
				 		<hr style="width: 940px; margin-left: 55px;">
				</div>
		<br><br>		
				
<!-- 댓글시작 -->
<div id="comment" style="text-align: center; width: 900px; margin: 0 auto;">
	<form method="post" action="CommentAction.buy?B_num=<%=B_num%>">
		<table style="width: 900px;">
			<tr><th colspan="3"><p style="font-size: 20px;margin-bottom:5px;">댓글<p></th></tr>
			
			<%
				for (int i = List.size() - 1; i >= 0; i--) {
			%>
			<!--  댓글  -->
			<tr><td width="15%" height="50" style="text-align: left;"><%=List.get(i).getM_id()%></td>
				<td width="200" height="50" style="text-align: left;"><%=List.get(i).getCo_text()%></td>
				<%
					if (M_id != null) {
						if (M_id.equals(List.get(i).getM_id())) {
				%>

				<td width="10" style="text-align: right;"><a href=# onclick="return coupdate();" class="btn">수정</a> 
					<script text="text/javascript">
						function coupdate(Co_num) {
						//	수정팝업창 크기 조절과 팝업 위치 조절
							var _width = '700';
							var _height = '320';
							var _left = Math.ceil((window.screen.width - _width) / 2);
							var _top = Math.ceil((window.screen.height - _height) / 2);
							window.name = "buydetails";
							window.open(
							"CommentUpdateForm.buy?Co_num="+<%=List.get(i).getCo_num()%>,
							"updateForm",'width='+ _width+ ', height='+ _height+ ', left='+ _left+ ', top='+ _top);}
					</script></td>
				<td width="10"><a href="CommentDelete.buy?B_num=<%=B_num%>&Co_num=<%=List.get(i).getCo_num()%>"onclick="return delchk();" class="btn">삭제</a> 
					<script text="text/javascript">
						function delchk() {
							return confirm("삭제하시겠습니까?");}
					</script></td>
						<%
							}
						}
						%>
				</tr>

			<%
				}
			%>
		<tr>
		
		<td colspan="3">	
					<textarea type="text" class="form-control"placeholder="댓글을 입력하세요." name="Co_text" maxlength="2048"style="width: 800px; height: 100px; font-size: 15px;	display: flex;
	resize: none;"></textarea>
			</td>
			<td valign="bottom"><input type="submit" class="btn btn-dark" value="댓글입력" style="margin-bottom: 30px; margin-left: 30px;">
			</td>
	</table>
</form>
</div>
</div>
<!-- 댓글끝 -->
				
			</div>
		</div>
</div>
</div>
</section>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
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
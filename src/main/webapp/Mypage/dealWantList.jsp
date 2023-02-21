

<%@page import="com.itwillbs.deal.db.DealDAO"%>
<%@page import="com.itwillbs.deal.db.DealDTO"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
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
<!-- ***** 로고 시작 ***** -->
<img src="assets/images/otzang_logo_top.png" height="60px" style="display: flex !important">
<!-- ***** 로고 끝 ***** -->

            
<!--  ***** 구매 요청자 조회 시작 ***** -->
<%
int S_num=Integer.parseInt(request.getParameter("S_num"));
String M_id=request.getParameter("M_id");
// MemberDTO dto=new MemberDTO();

DealDTO dto=new DealDTO();
DealDAO dao=new DealDAO();

ArrayList<DealDTO> DealWantList=dao.DealWantList(S_num);

// ArrayList<DealDTO> DealWantList=(ArrayList<DealDTO>)request.getAttribute("DealWantList");

%>	
<!-- <section class="section" id="products" style="width: 200px;"> -->
<!-- 게시판 제목  -->
		<div class="container">
			<div style="width: 30px;">
				<div  style="width: 30px;">
					<div class="section-heading" style="width:200px; margin:30px 140px; text-align: center";>
						<h2 style="width: 200px">거래</h2>
						<span>sell</span>
					</div>
				</div>
			</div>
		</div>
		<div class="container" style=" width:100%; padding: 0;">
			<div style="height: 20;">
				<div class="col-lg-4">
					<div class="item" style="padding:0;">
					<!-- board list area -->
						<div id="board-list" style="width: 500px;float: left; padding:0; margin-right: auto;">
<!-- 							<table class="board-table" style="float: left; margin-bottom: 30px;"> -->
							<table class="board-table" style="float: left; margin: 0 auto;">
								<thead>
									<tr>					
										<th scope="col" class="th-want">구매희망자</th>
										<th scope="col" class="th-deal">거래완료</th>
									</tr>
								</thead>
								<tbody>

<%

for(int i=0;i<DealWantList.size();i++){
	dto=DealWantList.get(i);	
%>

	<tr>
		<td><%=dto.getD_buy() %></td>
		<td><button type="button" onclick="location.href='EndDealPro.deal?S_num=<%=dto.getS_num()%>&D_buy=<%=dto.getD_buy()%>'"
					style="background-color:#704A00; color:white; border:none; border-radius: 7px; padding: 3px 7px" >거래완료</button>
		</td>		
	</tr>

<%
}
%>
		</tbody>
	</table>
<!-- 희망자조회끝 -->
	<div style="margin-top: 10px;">
							</div>
 						</div>
					</div>
             </div>
        </div>
    </div>
<!-- </section> -->
	<!-- ***** 작성글 조회(판매)페이징 끝 ***** -->


<!--  ***** 구매 요청자 조회 끝***** -->
	       


  </body>
</html>
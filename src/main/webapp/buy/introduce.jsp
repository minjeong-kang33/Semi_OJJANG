<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>중고의류거래: 옺장</title>
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="assets/css/font-awesome.css">
<link rel="stylesheet" href="assets/css/templatemo-hexashop.css">
<link rel="stylesheet" href="assets/css/owl-carousel.css">
<link rel="stylesheet" href="assets/css/lightbox.css">
<meta charset="UTF-8">
<title>중고 의류거래: 옺장</title>

<script type="text/javascript">
	function fun1(M_id, B_num, R_category, B_title) {

		window.open("ReportForm.rpt?R_id=" + M_id + "&R_writeNum=" + B_num
				+ "&R_category=" + "buy" + "&R_title=" + B_title, "pop",
				"width=520,height=340");
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
<body>
<div style="margin: 180px auto 0 auto;">
	<img src="img/buy/company.png" style="width: 480px; height: 400px;display: block;margin: 0px  auto 0px auto;">
	</div>


<!-- 오시는 길<br> -->
<!-- <img src="img/buy/운영시간 아이콘.png" style="width: 5px; height: 5px; margin: auto;display: block;"> -->


  <hr style="border: solid 4px rgba(42,42,42,80%);">
<table style="margin: auto;display: block;undefined;table-layout: fixed; width: 879px;">
<colgroup>
<col style="width: 512px">
<col style="width: 367px">
</colgroup>
<thead>
  <tr>
    <th colspan="2" style="text-align: center;">
    <img src="img/buy/오시는 길.png" style="width: 120px; height: 60px; margin: auto;display: block;">
    </th>
  </tr>
</thead>
<tbody>
  <tr>
    <td><div id="map" style="width: 500px; height: 400px;margin:0 auto; "></div></td>
    <td><h5><img src="img/buy/지도 아이콘.png" style="width: 29px; height: 29px; ">주소 <br></h5>
    부산광역시 부산진구 부전동 112-3번지 삼한골든게이트 7층 (도로명주소 : 부산광역시 부산진구 동천로 109 삼한골든게이트 7층)
    [우편번호 : 47246]<br>
     <br>
   <h5> <img src="img/buy/전화기아이콘.png" style="width: 29px; height: 29px;">연락처<br></h5>
    대표전화 : 051-803-0909
   시험문의 : 051-803-0918
   팩스 : 051-803-0979<br>
   <br>
    <h5><img src="img/buy/운영시간 아이콘.png" style="width: 29px; height: 29px;">운영시간<br></h5>
    매일 08:00-21:00
    </td>
  </tr>
</tbody>
</table>
	
	
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5c1107946ba8c924cec95b574bb82051"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(35.158495, 129.062091),
			level : 1
		};

		var map = new kakao.maps.Map(container, options);

		var marker = new kakao.maps.Marker({
			map : map,
			position : new kakao.maps.LatLng(35.158495, 129.062091)
		});

		var clusterer = new kakao.maps.MarkerClusterer({
			map : map,
			markers : markers,
			gridSize : 35,
			averageCenter : true,
			minLevel : 6,
			disableClickZoom : true,
			styles : [ {
				width : '53px',
				height : '52px',
				background : 'url(cluster.png) no-repeat',
				color : '#fff',
				textAlign : 'center',
				lineHeight : '54px'
			} ]
		});
	</script>
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
			$("p").click(function() {
				selectedClass = $(this).attr("data-rel");
				$("#portfolio").fadeTo(50, 0.1);
				$("#portfolio div").not("." + selectedClass).fadeOut();
				setTimeout(function() {
					$("." + selectedClass).fadeIn();
					$("#portfolio").fadeTo(50, 1);
				}, 500);

			});
		});
	</script>


</body>
</html>
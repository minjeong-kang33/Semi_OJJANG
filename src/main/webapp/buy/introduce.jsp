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
	<img src="img/buy/otzang_logo_top.png" style="margin:180px auto;">
	<div id="map" style="width: 500px; height: 400px;margin:180px auto; "></div>
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
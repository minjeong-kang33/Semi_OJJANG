<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<head>
<meta charset="UTF-8">
<title>네이버 로그인</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link href="assets/css/loginForm.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="select"></div>
	<br>
	<br>

	<form action="MemberLoginPro.me" method="post">
		<div class="form-group">
			<input type="text" class="form-control" name="M_id" id="M_id"
				aria-describedby="emailHelp" placeholder="아이디">
		</div>

		<div class="form-group">
			<input type="password" class="form-control" name="M_pw" id="M_pw"
				placeholder="비밀번호">
		</div>

		<div class="login-button">
			<div>
				<button type="submit" class="btn btn-primary">로그인</button>
			</div>
		</div>
		<div class="form-check">
			<div>
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">로그인 상태
					유지</label>
			</div>
		</div>

	</form>

	<hr width="350px" align="center">


	<br>

	<div class="button-group">
		<div>
			<!-- 카카오 로그인 -->
			<a onclick="kakaoLogin();"> <img
				src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
				width="222" />
			</a>
		</div>
	</div>
	<br>
	<br>
	<footer class="footer">
		<div class="footer-info">
			<a href="" onclick="find()">아이디/비밀번호찾기 |</a> <a href="join/joinForm.jsp">회원가입</a>
<script type="text/javascript">
				function find() {
					window.open("findID.jsp", "nickwin",
							"width=400, height=350");
				}
			</script>
		</div>
	</footer>
</body>
</html>
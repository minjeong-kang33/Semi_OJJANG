<%@page import="com.itwillbs.comment.db.CommentDTO"%>
<%@page import="com.itwillbs.comment.db.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="assets/css/commentUpdateForm.css" rel="stylesheet" type="text/css">
<title>댓글 수정폼</title>
</head>
<body>
<div id="wrap">
	
	<div class="commentUpdateForm">
		<div class="commentUpdateBox">
			<span style="font-size: 23px; font-weight: 600;"> 댓글 수정 </span>
		</div> <!-- commentUpdateBox 끝 -->
		
			<%
			int Co_num = Integer.parseInt(request.getParameter("Co_num"));
			CommentDAO commentDAO=new CommentDAO();	
			CommentDTO comment = commentDAO.getComment(Co_num);
			%>
			
		<div>
			<form method="post" action="CommentUpdateAction.buy?Co_num=<%=Co_num%>" name="updateForm">
				<textarea rows="7" cols="93" name="Co_text" style="margin-bottom: 30px; margin-left: 1px;"><%=comment.getCo_text() %></textarea>
			<div class = "buttonBox">
				<input type="submit" class="btn" value="등록" style="font-size: 15px">
				<input type="button" value="취소" class="btn2" onclick="window.close()" style="font-size: 15px">
			</div>	
			</form>
		</div>
	
	</div> <!-- commentUpdateForm 끝 -->
</body>
</html>
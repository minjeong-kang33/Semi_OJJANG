<%@page import="com.itwillbs.comment.db.CommentDTO"%>
<%@page import="com.itwillbs.comment.db.CommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글 수정폼</title>
</head>
<body>
<div id="wrap">
	<br>
	<b><font size="5" color="gray">댓글 수정</font></b>
	<hr size="1" width="550">
	<br>
	<%
	

	int Co_num=(Integer)request.getAttribute("Co_num");
	CommentDAO commentDAO=new CommentDAO();	
	CommentDTO comment = commentDAO.getComment(Co_num);
	

	%>
	<div id = "commentupdateForm">
		<form method="post" action="commentupdateAction.jsp?Co_num=<%=Co_num%>" name="updateForm">
				<textarea rows="7" cols="70" name="Co_text"><%=comment.getCo_text() %></textarea>
				<br><br>
		<input type="submit" class="btn" value="등록">
		<input type="button" value="취소" onclick="window.close()">
				</form>
	</div>
</div>
</body>
</html>
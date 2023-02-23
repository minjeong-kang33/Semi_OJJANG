<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
       String M_id = null;
       if(session.getAttribute("M_id") != null) {
    	   M_id = (String) session.getAttribute("M_id");
       }
       if(M_id == null){
    	   session.setAttribute("messageType", "오류 메시지");
    	   session.setAttribute("messageContent", "현재 로그인이 되어있지 않습니다.");
    	   response.sendRedirect("../login/loginForm.jsp");
    	   return;
       }
    %>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="chat/cs/bootstrap.css">
	<link rel="stylesheet" href="chat/cs/custom.css">
	<title>옷장 톡</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="chat/js/bootstrap.js"></script>
	<script type="text/javascript">
	    function findFunction() {
	    	var M_id = $('#findID').val();
	    	$.ajax({
	    		type: "POST",
	    		url: './MemberFindServlet',
	    		data: {M_id: M_id},
	    		success: function(result) {
	    			if(result == -1) {
	    				$('#checkMessage').html('판매자를 찾을 수 없습니다.');
	    				$('#checkType').attr('class', 'modal-content panel-warning');
	                    failFriend();
	    			}
	    			else {
	    				$('#checkMessage').html('판매자찾기에 성공했습니다.');
	    				$('#checkType').attr('class', 'modal-content panel-success');
	    				var data = JSON.parse(result);
	    				var profile = data.userProfile; 
	                    getFriend(M_id, profile);    				
	    			} 
	    			$('#checkModal').modal("show");
	    		}
	    	});
	    }
	    function getFriend(findID, userProfile) {
	    	$('#friendResult').html('<thead>' + 
	    			'<tr>' +
	    			'<th><h4>검색 결과</h4></th>' +
	    			'</tr>' +
	    			'</thead>' +
	    			'<tbody>' +
	    			'<tr>' +
	    			'<td style="text-align: center;">' +
	    			'<img class="media-object img-circle" style="max-width:300px; margin : 0 auto;" src="'+userProfile +'">' +
	    			'<h3>' + findID + '</h3><a href="chat.jsp?toID=' + encodeURIComponent(findID) + '" class="btn btn-primary pull-right">' + '메시지 보내기</a></td>' +                      
	    			'</tr>' +
                    '</tbody>');	    			
	    }
	    function failFriend() {
	    	$('#friendResult').html('');
	    }
	    function getUnread() {
	    	$.ajax({
	    		type: "POST",
	    		url: "./chatUnread",
	    		data: {
	    			M_id: encodeURIComponent('<%= M_id %>'),
	    		},
	    		success: function(result) {
	    			if(result >= 1) {
	    				showUnread(result);
	    			} else {
	    				showUnread('');
	    			}
	    		}
	    	});
	    }
	    function getInfiniteUnread() {
	    	setInterval(function() {
	    		getUnread();
	    	}, 4000);
	    }
	    function showUnread(result) {
	    	$('#unread').html(result);
	    }
	</script>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
           <button type="button" class="navbar-toggle collapsed"
               data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
               aria-expanded="false">
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
           </button>
           <a class="navbar-brand" href="find.ch">옷장 톡</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
               <li><a href="box.jsp">메시지함<span id="unread" class="label label-info"></span></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle"
                        data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false">회원관리<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="profileUpdate.jsp">프로필 수정</a></li>
                        <li><a href="" onClick="window.close()">로그아웃</a></li>
                    </ul>  
                </li> 
            </ul>
        </div>
    </nav>
    <div class="container">
        <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
                <tr>
                    <th colspan="2"><h4>검색으로 찾기</h4></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="width: 110px;"><h5>찾을 아이디</h5></td>
                    <td><input class="form-control" type="text" id="findID" maxlength="20" placeholder="찾을 아이디를 입력하세요."></td>
                </tr>
                <tr>
                    <td colspan="2"><button class="btn btn-primary pull-right" onclick="findFunction();">검색</button></td>
                    
                </tr>
            </tbody>
        </table>
    </div>
    <div class="container">
        <table id="friendResult" class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd;">
        </table>
    </div>
    <%
        String messageContent = null;
        if (session.getAttribute("messageContent") != null) {
        	messageContent = (String) session.getAttribute("messageContent");
        }
        String messageType = null;
        if (session.getAttribute("messageType") != null) {
        	messageType = (String) session.getAttribute("messageType");
        }
        if (messageContent != null) {
    %>
    <div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="vertical-alignment-helper">
            <div class="modal-dialog vertical-align-center">
                <div class="modal-content <% if(messageType.equals("오류 메시지")) out.println("panel-warning"); else out.println("panel-success"); %>">
                    <div class="modal-header panel-heading">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title">
                            <%= messageType %>
                        </h4>
                    </div>
                    <div class="modal-body">
                        <%= messageContent %>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $('#messageModal').modal("show");
    </script>
    <%     	
        session.removeAttribute("messageContent");
        session.removeAttribute("messageType");
        }
    %>
    <div class="modal fade" id="checkModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="vertical-alignment-helper">
            <div class="modal-dialog vertical-align-center">
                <div id="checkType" class="modal-content panel-info">
                    <div class="modal-header panel-heading">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title">
                                                               확인 메시지 
                        </h4>
                    </div>
                    <div id="checkMessage" class="modal-body">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">확인</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%
        if(M_id != null) {
    %>
        <script type="text/javascript">
            $(document).ready(function() {
            	getUnread();
            	getInfiniteUnread();
            });
        </script>
    <%
        }   
    %>
</body>
</html>
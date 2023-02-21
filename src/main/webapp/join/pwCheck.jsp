<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
        function check_pw(){
            var M_pw = document.getElementById('M_pw').value;
            var check_SC = 0;
       	    if(document.getElementById('M_pw').value !='' && document.getElementById('M_pw2').value!=''){
                if(document.getElementById('M_pw').value==document.getElementById('M_pw2').value){
                    document.getElementById('check').innerHTML='비밀번호가 일치합니다'
                    document.getElementById('check').style.color='#4E89AE';
                }
                else{
                    document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다';
                    document.getElementById('check').style.color='#EC4646';
                }
            }
        }
    </script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>로그인</p>
<form id="signinForm">
    <label for="id">아이디</label>
    <input type="text" id="id" name="id">
    <label for="pwd">비밀번호</label>
    <input type="password" id="pwd" name="pwd">
    <input type="button" id="signInBtn" value="로그인">
    <input type="button" id="cancelBtn" value="취소">
</form>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>

    $("#cancelBtn").click(function(){
        location.href="${pageContext.request.contextPath}/";
    });

    //ajax 로그인
    $("#signInBtn").click(function () {
        $.ajax({
            url:"signinresult",
            method:"POST",
            data: $("#signinForm").serialize(),
            success: function(data){
                console.log(data);
                if(data.result != false){
                    alert(data.id +"님 환영합니다.");
                    location.href="${pageContext.request.contextPath}/";
                }else{
                    alert("아이디 및 비밀번호를 확인해주세요.");
                    $("#signinForm").each(function(){this.reset();});
                    $("#id").focus();
                }
            },
            error:function(request, status, error){
                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    })
    
</script>
</body>
</html>
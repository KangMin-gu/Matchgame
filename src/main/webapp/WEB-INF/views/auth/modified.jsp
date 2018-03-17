<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 18.
  Time: 오전 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form id="modifiedForm">
    <input type="hidden" name="id" value="${dto.id}">
    <label for="id">아이디</label>
    <input type="text" id="id" name="id" value="${dto.id}" disabled><br/>
    <label for="pwd">비밀번호</label>
    <input type="password" id="pwd" name="pwd"><br/>
    <label for="pwdCheck">비밀번호 확인</label>
    <input type="password" id="pwdCheck" name="pwdCheck"><br/>
    <label for="name">이름</label>
    <input type="hidden" name="name" value="${dto.email}">
    <input type="text" id="name" name="name" value="${dto.name}" disabled><br/>
    <label for="email">이메일</label>
    <input type="text" id="email" name="email" value="${dto.email}"><br/>
    <label for="post">우편번호</label>
    <input type="text" id="post" name="post" value="${dto.post}"><br/>
    <label for="addr">주소</label>
    <input type="text" id="addr" name="addr" value="${dto.addr}"><br/>
    <label for="detailaddr">상세주소</label>
    <input type="text" id="detailaddr" name="detailaddr" value="${dto.detailaddr}"><br/>
    <label for="phone">전화번호</label>
    <input type="text" id="phone" name="phone" value="${dto.phone}"><br/>
    <input type="button" id="modifiedBtn" value="수정하기">
    <input type="button" id="cancelBtn" value="취소">
</form>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>

    $("#cancelBtn").click(function(){
        location.href="${pageContext.request.contextPath}/auth/info/${id}";
    });

    $("#modifiedBtn").click(function(){
        var id = $("#id").val();
        var pwd = $("#pwd").val();
        var pwdCheck = $("#pwdCheck").val();
        var email = $("#email").val();
        var post = $("#post").val();
        var addr = $("#addr").val();
        var detailaddr = $("#detailaddr").val();
        var phone = $("#phone").val();
        if(pwd == pwdCheck){
            $.ajax({
                url:"editauth",
                method:"PUT",
                data: JSON.stringify({id:id, pwd: pwd, email:email, post:post, addr:addr, detailaddr:detailaddr, phone:phone}),
                contentType: 'application/json', //내가보내려는 데이터타입 즉 서버에서 받아들이는 데이터타입을 정한다.
                //stringify 처리할때 content-type 을 'application/json' 로 꼭 정해줘야한다. 안하면 query형태로 인식하여 400에러를 리턴한다.
                //결국 서버에서 어떤 contenttype으로 받아들이도록 구현했는지에 따라 정해진다.
                success:function(){
                    alert("${dto.id}님 수정완료 되었습니다.");
                    location.reload();
                },
                error:function(request, status, error) {
                    console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                }
            });
        }else{
            alert("비밀번호 와 비밀번호 확인 입력값이 다릅니다.");
            $("#pwd").val("");
            $("#pwd").focus();
        }
    });

</script>

</body>
</html>


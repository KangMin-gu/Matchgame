<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 17.
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<p>회원정보 및 수정하기</p>

    <form:form action="/auth/${dto.id}" method="put" accept-charset="UTF-8">
        <label for="id">아이디</label>
        <input type="hidden" name="id" value="${dto.id}">
        <input type="text" id="id" name="id" value="${dto.id}" disabled><br/>

        <label for="lolid">롤 아이디</label>
        <input type="text" id="lolid" name="lolid" value="${dto.lolid}"><br/>

        <label for="pwd">비밀번호</label>
        <input type="password" id="pwd" name="pwd"><br/>

        <label for="pwdCheck">비밀번호 확인</label>
        <input type="password" oninput="checkPwd()" id="pwdCheck" name="pwdCheck"><br/>

        <label for="name">이름</label>
        <input type="hidden" name="name" value="${dto.name}">
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

        <label for="regdate">가입날짜</label>
        <input type="text" id="regdate" name="regdate" value="${dto.regdate}" disabled>
        <button id="modifiedBtn" type="submit" disabled="disabled">회원 정보 수정</button>
    </form:form>

<form:form action="/auth/${dto.id}" method="delete">
    <button type="sumbit">회원 탈퇴</button>
</form:form>

<a href="${pageContext.request.contextPath}/">홈으로</a>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>

function checkPwd(){
    var pwd = $("#pwd").val();
    var pwdCheck = $("#pwdCheck").val();

    if(pwd != pwdCheck){
        $("#modifiedBtn").attr('disabled', true);
        $("#modifiedBtn").remove('disabled', false);
        return;
    }else{
        $("#modifiedBtn").attr('disabled', false);
        $("#modifiedBtn").remove('disabled', true);
        return;
    }
}


</script>
</body>
</html>


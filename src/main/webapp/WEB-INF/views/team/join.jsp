<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 19.
  Time: 오전 5:43
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
팀신청서
<form action="/team/jonin/apply" method="post" id="joinForm">
    <input type="hidden" name="num" id="num" value="${dto.num}">
    <input type="hidden" name="main" id="main" value="${dto.main}">
    <label for="teamname">팀 이름</label>
    <input type="hidden" name="teamname" value="${dto.teamname}">
    <input type="text" id="teamname" name="teamname" value="${dto.teamname}" disabled><br/>

    <p>자신의 포지션을 선택해주세요.</p>

    <label for="top">탑: ${dto.top}</label>
    <input class="Confirm" type="radio" id="top" name="top" value="${lolid}">
    <label for="mid">미드: ${dto.mid}</label>
    <input class="Confirm" type="radio" id="mid" name="mid" value="${lolid}">
    <label for="jungle">정글: ${dto.jungle}</label>
    <input class="Confirm" type="radio" id="jungle" name="jungle" value="${lolid}">
    <label for="bottom">원딜: ${dto.bottom}</label>
    <input class="Confirm" type="radio" id="bottom" name="bottom" value="${lolid}">
    <label for="support">서폿: ${dto.support}</label>
    <input class="Confirm" type="radio" id="support" name="support" value="${lolid}"><br/>

    <p>신청서를 보내고 주장(${dto.main})님이 수락을 하면 팀에 참가하게 됩니다.</p>
    <button type="submit" id="submit" name="submit">신청서 발송</button>
    <a href="/team/list">팀전체리스트</a>
</form>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>
    //체크박스 하나만 가능하게
    $("#top").click(function(){
        $("#mid").prop('checked', false);
        $("#jungle").prop('checked', false);
        $("#bottom").prop('checked', false);
        $("#support").prop('checked', false);
    });
    $("#mid").click(function(){
        $("#top").prop('checked', false);
        $("#jungle").prop('checked', false);
        $("#bottom").prop('checked', false);
        $("#support").prop('checked', false);
    });
    $("#jungle").click(function(){
        $("#top").prop('checked', false);
        $("#mid").prop('checked', false);
        $("#bottom").prop('checked', false);
        $("#support").prop('checked', false);
    });
    $("#bottom").click(function(){
        $("#top").prop('checked', false);
        $("#jungle").prop('checked', false);
        $("#mid").prop('checked', false);
        $("#support").prop('checked', false);
    });
    $("#support").click(function(){
        $("#mid").prop('checked', false);
        $("#jungle").prop('checked', false);
        $("#bottom").prop('checked', false);
        $("#top").prop('checked', false);
    });

    $("#applyBtn").click(function(){
        $.ajax({
            url:"apply",
            method:'POST',
            data: $("#joinForm").serialize(),
            success:function(){
                alert("팀 가입 신청되었습니다.");
                location.href="${pageContext.request.contextPath}/team/list";
            },
            error:function(request, status, error) {
                console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    });

    $("#cancelBtn").click(function(){
        location.href="${pageContext.request.contextPath}/team/list";
    });

</script>
</body>
</html>


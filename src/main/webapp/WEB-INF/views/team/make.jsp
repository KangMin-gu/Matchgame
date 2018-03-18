<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 18.
  Time: 오전 3:50
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
팀만들기
<form id="teamMakeForm">
    <label for="teamname">팀 이름</label>
    <input type="text" id="teamname" name="teamname"><br/>
    <label for="main">주장</label>
    <input type="hidden" name="main" value="${dto.lolid}">
    <input type="text" id="main" name="main" value="${dto. lolid}" disabled><br/>
    <p>자신의 포지션을 선택해주세요.</p>

    <label for="top">탑</label>
    <input class="Confirm" type="radio" id="top" name="top" value="${dto.lolid}">
    <label for="mid">미드</label>
    <input class="Confirm" type="radio" id="mid" name="mid" value="${dto.lolid}">
    <label for="jungle">정글</label>
    <input class="Confirm" type="radio" id="jungle" name="jungle" value="${dto.lolid}">
    <label for="bottom">원딜</label>
    <input class="Confirm" type="radio" id="bottom" name="bottom" value="${dto.lolid}">
    <label for="support">서폿</label>
    <input class="Confirm" type="radio" id="support" name="support" value="${dto.lolid}"><br/>

    <input type="button" id="makeTeamBtn" value="팀 생성">
    <input type="button" id="cancelBtn" value="취소">
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


//팀만들기 ajax  요청

    $("#makeTeamBtn").click(function(){

        console.log( $("input:radio[name=jungle]").is(':checked'));

        $.ajax({
            url:"make/maketeam",
            method: "POST",
            data: $("#teamMakeForm").serialize(),
            success:function(){
                alert("${dto.id}님 팀이 생성되었습니다. 팀원을 초대하세요.");
                location.href="${pageContext.request.contextPath}/team/teaminfo";
            },
            error:function(request, status, error){
                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    });

    $("#cancelBtn").click(function(){
        location.href="${pageContext.request.contextPath}/team/teaminfo";
    });
</script>
</body>
</html>


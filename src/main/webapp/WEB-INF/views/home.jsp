<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <head>
        <title>Home</title>
    </head>
<body>
<h1>
    Hello world!
</h1>
<P>  The time on the server is ${serverTime}. </P>
<c:choose>
    <c:when test="${not empty id}">
        <ul>
            <li><a href="auth/info/${id}">회원정보</a></li>
            <li><a href="javascript:logout()">로그아웃</a></li>
        </ul>
    </c:when>
    <c:otherwise>
        <ul>
            <li><a href="auth/signup">회원가입</a></li>
            <li><a href="auth/signin">로그인</a></li>
        </ul>
    </c:otherwise>
</c:choose>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>
    <%@include file="include/logoutscript.jsp"%>
</script>
</body>
</html>

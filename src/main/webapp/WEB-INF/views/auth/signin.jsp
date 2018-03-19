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
<form action="/auth/signin" method="post" id="signinForm">
    <label for="id">아이디</label>
    <input type="text" id="id" name="id">
    <label for="pwd">비밀번호</label>
    <input type="password" id="pwd" name="pwd">
    <button type="submit" id="submit" name="submit">로그인</button>
    <input type="button" id="findBtn" value="아이디 또는 비밀번호 찾기">
</form>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>

</script>
</body>
</html>
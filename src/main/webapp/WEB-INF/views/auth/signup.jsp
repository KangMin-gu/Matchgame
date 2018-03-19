<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>회원가입</p>
<form action="/auth" method="post" id="signupForm" accept-charset="UTF-8">
	<label for="id">아이디</label>
	<input type="text" id="id" name="id" /><br/>
	<label for="pwd">비밀번호</label>
	<input type="text" id="pwd" name="pwd"/><br/>
	<label for="pwdcheck">비밀번호 확인</label>
	<input type="text" id="pwdcheck" name="pwdcheck" /><br/>
	<label for="lolid">롤 아이디</label>
	<input type="text" id="lolid" name="lolid"><br/>
	<label for="name">이름</label>
	<input type="text" id="name" name="name" /><br/>
	<label for="email">이메일</label>
	<input type="text" id="email" name="email" /><br/>
	<label for="phone">전화번호</label>
	<input type="text" id="phone" name="phone" /><br/>
	<label for="post">우편번호</label>
	<input type="text" id="post" name="post" /><br/>
	<label for="addr">주소</label>
	<input type="text" id="addr" name="addr"/><br/>
	<label for="detailaddr">상세주소</label>
	<input type="text" id="detailaddr" name="detailaddr" /><br/>
	<button type="submit" id="submit" name="submit">가입하기</button>
</form>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
</body>
<script>

</script>
</html>
<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 17.
  Time: 오후 2:51
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

<p>나의 정보</p>
${dto.id}<br/>
${dto.name}<br/>
${dto.phone}<br/>
${dto.email}<br/>
${dto.addr}<br/>
${dto.detailaddr}<br/>
${dto.regdate}<br/>

<a href="">정보수정</a>
<a href="">회원탈퇴</a>
<a href="">홈으로</a>

</body>
</html>


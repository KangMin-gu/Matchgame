<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 18.
  Time: 오전 3:28
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
팀화면 (팀 테이블에서 내가 팀에 속해있지 않으면 팀찾기 속해있으면 팀정보화면보여주기  )
<ul>
    <li><a href="${pageContext.request.contextPath}/team/myteam/${id}">나의 팀 정보</a></li>
    <li><a href="${pageContext.request.contextPath}/team/teamlist">팀 찾기</a></li>
    <li><a href="${pageContext.request.contextPath}/team/make">팀 만들기</a></li>
    <li><a href="${pageContext.request.contextPath}/">홈</a></li>
</ul>



</body>
</html>


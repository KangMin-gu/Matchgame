<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 18.
  Time: 오전 3:53
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
<style>
    table, th, td {
        border: 1px solid;
    }
</style>
<body>
팀 전체리스트
<table>
    <thead>
    <tr>
        <th>팀이름</th>
        <th>승리</th>
        <th>패배</th>
        <th>주장</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allList}" var="tmp">
        <tr>
            <td><a href="contents/${tmp.num}">${tmp.teamname}</a></td>
            <td>${tmp.win}</td>
            <td>${tmp.lose}</td>
            <td>${tmp.main}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<ul>
    <li><a href="${pageContext.request.contextPath}/team/${id}">나의 팀 목록</a></li>
    <li><a href="${pageContext.request.contextPath}/">홈</a></li>
</ul>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 19.
  Time: 오전 1:41
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
쪽지함
<table>
    <thead>
        <tr>
            <th>글번호</th>
            <th>보낸이</th>
            <th>제목</th>
            <th>읽음</th>
            <th>발송일</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${facinglist}" var="tmp">
        <tr>
            <td>${tmp.num}</td>
            <td>${tmp.writer}</td>
            <td><a href="${pageContext.request.contextPath}/facing/contents/${tmp.num}">${tmp.title}</a></td>
            <td>${tmp.viewer}</td>
            <td>${tmp.regdate}</td>
        </tr>
    </c:forEach>
    </tbody>
    <a href="${pageContext.request.contextPath}/">메인가기</a>
</table>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>

</script>
</body>
</html>


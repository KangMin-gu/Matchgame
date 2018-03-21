<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 19.
  Time: 오전 7:51
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
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>
    alert("수락 되었습니다. ${lolid}님이 이제부터 팀에 합류합니다.");
    location.href="${pageContext.request.contextPath}/facing";
</script>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 20.
  Time: 오후 11:27
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
<script>
    alert("신청 완료 되었습니다.");
    location.href="${pageContext.request.contextPath}/team/list";
</script>
</body>
</html>


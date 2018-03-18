<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 19.
  Time: 오전 4:27
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
글번호: ${dto.num}<br/>
받는이:${dto.who}<br/>
보내는이:${dto.writer}<br/>
제목:${dto.title}<br/>
<div>
  내용:  ${dto.content}
</div><br/>
보낸날짜:${dto.regdate}<br/>
<a href="${pageContext.request.contextPath}/facing/list">목록가기</a>
</body>
</html>


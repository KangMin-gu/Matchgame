<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 19.
  Time: 오전 12:48
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
본문
팀이름:${dto.teamname}
팀주장:${dto.main}
탑:${dto.top}
미드:${dto.mid}
원딜:${dto.bottom}
서폿:${dto.support}
정글:${dto.jungle}
승:${dto.win}
패:${dto.lose}

<a href="${pageContext.request.contextPath}/team/teamlist">리스트가기</a>
<a href="javascript:facingApply()">가입신청</a>
<a href="">대전신청</a>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>
    function facingApply(){
        $.ajax({
            url:"apply/${dto.num}",
            method:'POST',
            success:function(){
              alert("팀 가입 신청되었습니다.");
            }
        });
    }
</script>
</body>
</html>


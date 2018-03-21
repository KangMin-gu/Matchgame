<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 21.
  Time: 오후 12:10
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
<p>Home Team</p>
팀 이름: ${homeTeam.teamname} </br>
팀 주장: ${homeTeam.main} </br>
</br></br>
탑 : ${homeTeam.top} </br>
미드: ${homeTeam.mid} </br>
원딜: ${homeTeam.bottom} </br>
서폿: ${homeTeam.support} </br>
정글: ${homeTeam.jungle} </br>

<p>AwayTeam</p>
<select name="awayselect" id="awayselect">
    <option value="">AwayTeam 목록</option>
<c:forEach items="${awayList}" var="tmp">
    <option value="${tmp.teamname}">${tmp.teamname}</option>
</c:forEach>
</select>
<input type="hidden" id="awayteam" name="awayteam">

</body>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>
$('#awayselect').change(function(){
    var teamname = $("#awayselect").val();
    console.log(teamname);
    $.ajax({
        url: "info/"+teamname,
        method:"get",
        data:{'teamname':teamname},
        success:function(data){
            console.log(data);
        }
    });
});
</script>
</html>


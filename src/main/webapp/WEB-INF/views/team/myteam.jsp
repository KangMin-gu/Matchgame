<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 18.
  Time: 오후 6:30
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
팀정보입니다.
    <table>
        <thead>
        <tr>
            <th>팀이름</th>
            <th>주장</th>
            <th>탑</th>
            <th>미드</th>
            <th>원딜</th>
            <th>서포터</th>
            <th>정글</th>
            <th>승리</th>
            <th>패배</th>
            <th>팀탈퇴</th>
            <th>팀해체</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach items="${list}" var="tmp">
        <tr>
            <td>${tmp.teamname}</td>
            <td>${tmp.main}</td>
            <td>${tmp.top}</td>
            <td>${tmp.mid}</td>
            <td>${tmp.bottom}</td>
            <td>${tmp.support}</td>
            <td>${tmp.jungle}</td>
            <td>${tmp.win}</td>
            <td>${tmp.lose}</td>
            <td><a href="javascript:teamSecession('${tmp.num}', '${tmp.top}', '${tmp.mid}', '${tmp.bottom}', '${tmp.support}', '${tmp.jungle}' )">팀 탈퇴</a></td>
            <c:if test="${dto.lolid eq tmp.main}">
            <td><a href="javascript:teamDismantling('${tmp.num}')">팀 해체</a></td>
            </c:if>
        </tr>
    </c:forEach>
        </tbody>
    </table>
<a href="${pageContext.request.contextPath}/team/teaminfo">팀메인</a>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>
    //팀탈퇴
    function teamSecession(num, top, mid, bottom, support, jungle){
          $.ajax({
              url:"secession",
              method:"PUT",
              data: JSON.stringify({'num':num, 'top':top, 'mid':mid, 'bottom':bottom, 'support':support, 'jungle':jungle}),
              contentType: 'application/json',
              success:function(){
                  alert("해당 팀에서 탈퇴 완료 되었습니다.");
                  location.reload();
              },
              error:function(request, status, error) {
                  console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
              }
          });
    }
    //팀해체
    function teamDismantling(num){
        $.ajax({
            url: num,
            method:"DELETE",
            success:function(){
                alert("팀 해체 되었습니다.");
                location.reload();
            },
            error:function(request, status, error) {
                console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
            }
        });
    }
</script>
</body>
</html>


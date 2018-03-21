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
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>
    function join(num, top, mid, bottom, support, jungle){
       alert(num);
        console.log(top);
        $.ajax({
            url:"team/accept",
            method:"PUT",
            data: JSON.stringify({'num':num, 'top':top, 'mid':mid, 'bottom':bottom, 'support':support, 'jungle':jungle}),
            contentType: 'application/json',
            success:function(){
                alert("수락 되었습니다. ${dto.writer}님이 이제부터 팀에 합류합니다.");
            },
            error:function(request, status, error){
                console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
        });
    }
</script>
</body>
</html>


<%--
  Created by IntelliJ IDEA.
  User: manggo
  Date: 2018. 3. 17.
  Time: 오후 2:51
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
<p>나의 정보</p>
${dto.id}<br/>
${dto.name}<br/>
${dto.lolid}<br/>
${dto.phone}<br/>
${dto.email}<br/>
${dto.addr}<br/>
${dto.detailaddr}<br/>
${dto.regdate}<br/>
<a href="${pageContext.request.contextPath}/auth/modified/${dto.id}">회원정보수정</a>
<a href="javascript:reallyDelete()">회원탈퇴</a>
<a href="${pageContext.request.contextPath}/">홈으로</a>

<script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js "></script>
<script>


    function reallyDelete(){
       var result = confirm("탈퇴 하시겠습니까?");
        if(result){
             $.ajax({
                url:"${dto.id}",
                method: "DELETE",
                dataType:'json',
                success:function(data){
                    console.log(data.result);
                    if(data.result != false ){
                        alert("모든 정보가 삭제 되었습니다.");
                        location.href="${pageContext.request.contextPath}/";
                    }
                },
                 error:function(request, status, error) {
                     console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                 }
             });

        }
    }
</script>
</body>
</html>


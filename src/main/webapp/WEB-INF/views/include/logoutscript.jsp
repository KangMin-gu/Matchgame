
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

function logout(){

    $.ajax({
        url: "signout",
        method: "GET",
        success: function () {
            alert("이용해주셔서 감사합니다.");
            location.href="${pageContext.request.contextPath}/";
        }
    });
}








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

$(document).ready(function(){
    var check = '${id}';
    if(check != ""){
        $.ajax({
            url:"facing/${id}",
            method:"GET",
            dataType:'json',
            success:function(data) {
            console.log(data);
            if (data.facingNo != 0) {
                    $("#facingNo").text("쪽지함" + "(" + data.facingNo + ")");
                }else{
                    $("#facingNo").text("쪽지함");
                }
            }
        });
    }
});







<%@ page contentType="text/html;charset=UTF-8" %>

<c:if test="${!empty sessionScope.user}">
    <p>Xin chào, ${sessionScope.user.fullname}!</p>
</c:if>

<h1>Trang chủ</h1>

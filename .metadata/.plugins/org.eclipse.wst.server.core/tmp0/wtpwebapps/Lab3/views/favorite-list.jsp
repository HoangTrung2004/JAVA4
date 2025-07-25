<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>Danh sách video đã được yêu thích</h2>

<table border="1" cellpadding="10" cellspacing="0">
    <thead>
        <tr>
            <th>Video Title</th>
            <th>Người thích</th>
            <th>Ngày thích</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="f" items="${favorites}">
            <tr>
                <td>${f.video.title}</td>
                <td>${f.user.fullname}</td>
                <td><fmt:formatDate value="${f.likeDate}" pattern="dd/MM/yyyy"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

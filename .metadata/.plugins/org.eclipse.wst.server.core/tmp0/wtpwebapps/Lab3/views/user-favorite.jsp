<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>${user.fullname}</h2>
<h3>Các video đã yêu thích:</h3>

<c:choose>
  <c:when test="${empty favorites}">
    <p>Không có video yêu thích nào.</p>
  </c:when>
  <c:otherwise>
    <ul>
      <c:forEach var="favorite" items="${favorites}">
        <li>${favorite.video.title}</li>
      </c:forEach>
    </ul>
  </c:otherwise>
</c:choose>

 

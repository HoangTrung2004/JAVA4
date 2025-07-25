<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết video</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="../layout/header_user.jsp" %>

<div class="container mt-4">
    <div class="row">
        <!-- Video chính -->
        <div class="col-md-8">
            <div class="card">
                <div class="card-header fw-bold bg-success-subtle text-success">
                    ${video.title}
                </div>
                <div class="card-body">
                    <!-- Giả lập video bằng poster -->
                    <img src="${pageContext.request.contextPath}/assets/img/${video.poster}" class="w-100 mb-3" alt="${video.title}">
                    <p><strong>Mô tả:</strong> ${video.description}</p>

                    <c:if test="${not empty sessionScope.user}">
                        <a href="favorite?id=${video.id}" class="btn btn-success">Like</a>
                        <a href="share?id=${video.id}" class="btn btn-warning">Share</a>
                    </c:if>
                </div>
            </div>
        </div>

        <!-- Danh sách đã xem -->
        <div class="col-md-4">
            <h5 class="text-primary">Đã xem gần đây</h5>
            <c:forEach var="v" items="${watched}">
                <div class="d-flex align-items-center mb-2 border-bottom pb-2">
                    <img src="${pageContext.request.contextPath}/assets/img/${v.poster}" width="60" height="40" style="object-fit: cover; margin-right: 10px;">
                    <a href="detail?id=${v.id}" class="text-decoration-none fw-bold">${v.title}</a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>

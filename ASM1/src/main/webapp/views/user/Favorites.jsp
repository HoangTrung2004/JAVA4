<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Video yêu thích</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="../layout/header_user.jsp" %>

<div class="container mt-4">
    <h3 class="text-center text-success mb-4">VIDEO YÊU THÍCH</h3>

    <div class="row g-4">
        <c:forEach var="v" items="${videos}">
            <div class="col-md-4">
                <div class="card h-100 border border-warning border-2 shadow-sm">
                    <a href="detail?id=${v.id}">
                        <img src="${pageContext.request.contextPath}/assets/img/${v.poster}"
                             class="card-img-top"
                             style="height: 200px; object-fit: cover;"
                             alt="${v.title}">
                    </a>

                    <div class="card-body text-center bg-light">
                        <h5 class="card-title">${v.title}</h5>

                        <form action="unlike" method="get" class="d-inline">
                            <input type="hidden" name="id" value="${v.id}">
                            <button class="btn btn-danger">Unlike</button>
                        </form>

                        <form action="share" method="get" class="d-inline">
                            <input type="hidden" name="id" value="${v.id}">
                            <button class="btn btn-warning">Share</button>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>
</body>
</html>

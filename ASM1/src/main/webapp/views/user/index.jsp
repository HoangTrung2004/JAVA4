<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
 <style>
        .video-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .video-card {
            flex-basis: calc(33.33% - 20px);
            border: 1px solid #e67e22;
            box-shadow: 0 0 4px #ccc;
            font-family: Arial, sans-serif;
            background-color: white;
        }

        .poster {
            height: 150px;
            background-color: #fff;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .poster img {
            max-height: 100%;
            max-width: 100%;
        }

        .title {
            background-color: #e0f0d0;
            padding: 10px;
            font-weight: bold;
            font-size: 14px;
            text-align: center;
        }

        .actions {
            padding: 10px;
            display: flex;
            justify-content: center;
            gap: 10px;
            background-color: #f9f9f9;
        }

        .btn {
            padding: 6px 14px;
            font-size: 14px;
            border: none;
            border-radius: 6px;
            color: white;
            cursor: pointer;
            box-shadow: 2px 2px 4px gray;
            text-decoration: none;
        }

        .btn-like {
            background-color: #4CAF50;
        }

        .btn-share {
            background-color: #f77f2f;
        }

        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            gap: 5px;
        }

        .pagination a {
            display: inline-block;
            background-color: #999;
            color: white;
            text-decoration: none;
            padding: 10px 14px;
            font-size: 16px;
            border-radius: 5px;
            box-shadow: 2px 2px 4px #888;
        }

        .pagination a:hover {
            background-color: #777;
        }

        .pagination .disabled {
            opacity: 0.5;
            pointer-events: none;
        }
    </style>
<body>

<%@ include file="../layout/header_user.jsp" %>

<div class="container mt-4">

    <div class="video-grid">
    <c:forEach var="v" items="${videos}">
        <div class="video-card">
            <a href="detail?id=${v.id}">
                <div class="poster">
                    <img src="${pageContext.request.contextPath}/assets/img/${v.poster}" alt="${v.title}" />
                </div>
            </a>
            <div class="title">${v.title}</div>
            <div class="actions">
                <form action="${pageContext.request.contextPath}/favorite" method="post" class="d-inline">
    				<input type="hidden" name="id" value="${v.id}">
    				<button class="btn btn-success">Like</button>
				</form>

                <a href="share?id=${v.id}" class="btn btn-share">Share</a>
            </div>
        </div>
    </c:forEach>
</div>


</div>


    <!-- PHÂN TRANG -->
    <div class="d-flex justify-content-center my-4">
        <nav>
            <ul class="pagination mb-0">
                <li class="page-item"><a class="page-link" href="?page=1">|&lt;</a></li>
                <li class="page-item"><a class="page-link" href="?page=${page - 1}">&lt;&lt;</a></li>
                <li class="page-item disabled"><a class="page-link" href="#">Trang ${page}</a></li>
                <li class="page-item"><a class="page-link" href="?page=${page + 1}">&gt;&gt;</a></li>
                <li class="page-item"><a class="page-link" href="?page=${totalPage}">&gt;|</a></li>
            </ul>
        </nav>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.bundle.min.js"></script>
</body>
</html>

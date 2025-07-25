<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="../layout/header_user.jsp" %>

<div class="container mt-5" style="max-width: 500px;">
    <h3 class="text-center text-primary mb-4">QUÊN MẬT KHẨU</h3>

    <form method="post" class="border p-4 rounded bg-white shadow">
        <div class="mb-3">
            <label class="form-label">Username</label>
            <input type="text" class="form-control" name="username" placeholder="Nhập username của bạn" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" placeholder="Nhập email đã đăng ký" required>
        </div>

        <div class="d-grid">
            <button class="btn btn-success" type="submit">Gửi mật khẩu</button>
        </div>

        <c:if test="${not empty message}">
            <div class="alert alert-info mt-3">${message}</div>
        </c:if>
    </form>
</div>


</body>
<%@ include file="../layout/footer.jsp" %>
</html>

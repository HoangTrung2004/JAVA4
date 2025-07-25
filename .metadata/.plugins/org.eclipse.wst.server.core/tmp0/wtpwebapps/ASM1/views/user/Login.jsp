<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<%@ include file="../layout/header_user.jsp" %>

<div class="container mt-4" style="max-width: 500px;">
    <h3 class="text-center text-primary mb-4">ĐĂNG NHẬP</h3>

    <form method="post" class="border p-4 rounded shadow bg-white">
        <div class="mb-3">
            <label for="userId" class="form-label">Tài khoản</label>
            <input type="text" class="form-control" id="userId" name="userId"
                   value="${userId}" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" id="password" name="password"
                   value="${password}" required>
        </div>

        <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="remember" name="remember"
                   ${not empty password ? 'checked' : ''}>
            <label class="form-check-label" for="remember">Ghi nhớ đăng nhập</label>
        </div>

        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </div>

        <c:if test="${not empty message}">
            <div class="alert alert-danger mt-3">${message}</div>
        </c:if>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>

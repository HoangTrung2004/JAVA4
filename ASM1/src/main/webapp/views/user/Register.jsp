<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%@ include file="../layout/header_user.jsp" %>

<div class="container mt-4" style="max-width: 600px;">
    <h3 class="text-center text-primary mb-4">ĐĂNG KÝ TÀI KHOẢN</h3>

    <form method="post" class="border p-4 rounded shadow bg-white">
        <div class="mb-3">
            <label class="form-label">Tài khoản</label>
            <input type="text" class="form-control" name="id" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Họ và tên</label>
            <input type="text" class="form-control" name="fullname" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Mật khẩu</label>
            <input type="password" class="form-control" name="password" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" required>
        </div>

        <div class="d-grid">
            <button type="submit" class="btn btn-success">Đăng ký</button>
        </div>

        <c:if test="${not empty message}">
            <div class="alert alert-info mt-3">${message}</div>
        </c:if>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>
</body>
</html>
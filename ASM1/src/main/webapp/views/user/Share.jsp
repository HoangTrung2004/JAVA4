    <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Share Video</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">

</head>
<body>

<%@ include file="../layout/header_user.jsp" %>

<div class="container mt-5" style="max-width: 600px;">
    <h3 class="text-center text-primary mb-4">Chia sẻ video</h3>

    <form method="post" class="border p-4 rounded bg-white shadow">
        <input type="hidden" name="id" value="${video.id}"/>

        <div class="mb-3">
            <label class="form-label">Tiêu đề</label>
            <input type="text" class="form-control" value="${video.title}" readonly/>
        </div>

        <div class="mb-3">
            <label class="form-label">Gửi đến Email</label>
            <input type="text" class="form-control" name="emails"
                   placeholder="Nhập nhiều email phân cách bởi dấu chấm phẩy (;)" required/>
        </div>

        <div class="d-grid">
            <button class="btn btn-warning" type="submit">Gửi Email</button>
        </div>

        <c:if test="${not empty message}">
            <div class="alert alert-success mt-3">${message}</div>
        </c:if>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>
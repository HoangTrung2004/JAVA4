<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>Đăng nhập</title></head>
<body>
    <h2>Đăng nhập</h2>
    <form action="login" method="post">
        Username: <input type="text" name="username" /> <br/>
        Password: <input type="password" name="password" /> <br/>
        <button type="submit">Đăng nhập</button>
    </form>
    <p style="color: red">${error}</p>
</body>
</html>

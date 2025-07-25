<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab2</title>
</head>
<body>
<h1>List of Users</h1>
<c:url var="url" value="/user"></c:url>
<form action="" method="post">
	<table>
		<tr>
			<td>Id</td>
			<td><input type="text" name="id" placeholder="Id" value="${form.id}"/></td>
		</tr>
		<tr>
			<td>FullName</td>
			<td><input type="text" name="fullname" placeholder="Fullname" value="${form.fullname}"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" placeholder="Password" value="${form.password}"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" placeholder="Email" value="${form.email}"/></td>
		</tr>
		<tr>
			<td><input ${form.admin?'checked':''} type="radio" name="admin" value="true" /> Admin</td>
			<td> <input ${form.admin?'':'checked'} type="radio" name="admin" value="False" /> User</td>
		</tr>
		<tr>
		<td colspan="2"><button formaction="${url}/create">Create</button>
			<button formaction="${url}/update">Update</button>
			<button formaction="${url}/delete?id=${form.id}">Delete</button>
			<button formaction="${url}/reset">Reset</button></td>
		</tr>
	</table>
</form>
<table border="1">
	<tr>
		<th>Id </th>
		<th>FullName </th>
		<th>Password </th>
		<th>Email </th>
		<th>Admin </th>
		<th>Edit</th>

	</tr>
	<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.fullname}</td>
			<td>${item.password}</td>
			<td>${item.email}</td>
			<td>${item.admin}</td>
			<td><a href="${url}/edit?id=${item.id}">Edit</a></td>

		</tr>
	</c:forEach>
</table>
</body>
</html>
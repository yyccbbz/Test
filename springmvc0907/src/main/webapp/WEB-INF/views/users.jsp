<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JSTL Demo</title>
	</head>
	
	<body>
		<table>
			<thead>
			<tr>
				<th>ID</th>
				<th>UserName</th>
				<th>Birthday</th>
				<th>Sex</th>
				<th>Address</th>
			</tr>
			</thead>
			<tbody>
<%-- 				<c:if test="${users} != null && ${users}.length>0"> --%>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.id}</<td>
							<td>${user.username}</<td>
							<td>${user.birthday}</<td>
							<td>${user.sex}</<td>
							<td>${user.address}</<td>
						</tr>
					</c:forEach>
<%-- 				</c:if> --%>
			</tbody>
		</table>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Page</title>
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Add an User</h1>

	<c:url var="addAction" value="/add/user"></c:url>

	<form:form action="${addAction}" commandName="user">
		<table>
			<c:if test="${!empty user.username}">
				<tr>
					<td><form:label path="idUser">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="idUser" readonly="true" disabled="true" />
						<form:hidden path="idUser" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="username">
						<spring:message text="Username" />
					</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="fullname">
						<spring:message text="Fullname" />
					</form:label></td>
				<td><form:input path="fullname" /></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty user.username}">
						<input type="submit" value="<spring:message text="Edit User"/>" />
					</c:if> <c:if test="${empty user.username}">
						<input type="submit" value="<spring:message text="Add User"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>User List</h3>
	<c:if test="${!empty listUsers}">
		<table class="tg">
			<tr>
				<th width="80">User ID</th>
				<th width="120">User Name</th>
				<th width="120">Full Name</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listUsers}" var="user">
				<tr>
					<td>${user.idUser}</td>
					<td>${user.username}</td>
					<td>${user.fullname}</td>
					<td><a href="<c:url value='/edit/user/${user.idUser}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/user/${user.idUser}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<table>
		<tr>
			<td><a href="<c:url value='/users' />">Users</a></td>
			<td><a href="<c:url value='/questions' />">Questions</a></td>
			<td><a href="<c:url value='/answers' />">Answers</a></td>
		<tr>
	</table>
</body>
</html>
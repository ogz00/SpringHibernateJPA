<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Question Page</title>

</head>
<body>
	<h1>Add an Question</h1>

	<c:url var="addAction" value="/add/question"></c:url>

	<form:form action="${addAction}" commandName="question">
		<table>
			<c:if test="${!empty question.questionText}">
				<tr>
					<td><form:label path="idQuestion">
							<spring:message text="ID" />
						</form:label></td>

					<td><form:input path="idQuestion" readonly="true"
							disabled="true" /> <form:hidden path="idQuestion" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="questionText">
						<spring:message text="Question: " />
					</form:label></td>
				<td><form:input path="questionText" /></td>
			</tr>
			<tr>
				<td><form:label path="order">
						<spring:message text="Please select order" />
					</form:label></td>
				<td><form:select path="order">
						<form:options items="${listOrder}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty question.questionText}">
						<input type="submit"
							value="<spring:message text="Edit Question"/>" />
					</c:if> <c:if test="${empty user.username}">
						<input type="submit" value="<spring:message text="Add Question"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>


	<br>
	<h3>Questions List</h3>
	<c:if test="${!empty listQuestions}">
		<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Title</th>
				<th width="50">Order</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
				<th width="80">Go To</th>
			</tr>
			<c:forEach items="${listQuestions}" var="question">
				<tr>
					<td>${question.idQuestion}</td>
					<td>${question.questionText}</td>
					<td>${question.order}</td>
					<td><a
						href="<c:url value='/edit/question/${question.idQuestion}' />">Edit</a></td>
					<td><a
						href="<c:url value='/remove/question/${question.idQuestion}' />">Delete</a></td>
					<td><a
						href="<c:url value='/questions/getQuestionWithAnswers/${question.idQuestion}' />">GoTo</a></td>

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" type="text/css">
<title>Answer Page</title>
</head>
<body>

	<h1>Add an Answer</h1>

	<c:url var="addAction" value="/add/answer"></c:url>

	<form:form action="${addAction}" commandName="answer">
		<table>
			<c:if test="${!empty answer.answerText}">
				<tr>
					<td><form:label path="idAnswer">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="idAnswer" readonly="true"
							disabled="true" /> <form:hidden path="idAnswer" /></td>
				</tr>

			</c:if>
			<%--<tr>
				<td><form:label path="question">
						<spring:message text="Question ID" />
					</form:label></td>
				<td><form:input path="question" /></td>
			</tr> --%>
			<tr>
				<td><form:label path="sequenceNo">
						<spring:message text="Please select sequence number" />
					</form:label></td>
				<td><form:select path="sequenceNo">
						<form:options items="${listSeq}" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="answerText">
						<spring:message text="Answer Text" />
					</form:label></td>
				<td><form:input path="answerText" /></td>
			</tr>
			<tr>
				<td><form:label path="trueAnswer">
						<spring:message text="Is this true Answer?" />
					</form:label></td>
				<td><form:radiobutton path="trueAnswer" value='1' />Yes</td>

				<td><form:radiobutton path="trueAnswer" value='0' />No</td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty answer.answerText}">
						<input type="submit" value="<spring:message text="Edit Answer"/>" />
					</c:if> <c:if test="${empty answer.answerText}">
						<input type="submit" value="<spring:message text="Add Answer"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	<h3>Answers List</h3>
	<c:if test="${!empty listAnswers}">
		<table class="tg">
			<tr>
				<th width="50">ID</th>
				<th width="50">ID by Quest.</th>
				<th width="50">Seq. No</th>
				<th width="200">Answer Text</th>
				<th width="50">True Answer</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listAnswers}" var="answer">
				<tr>
					<td>${answer.idAnswer}</td>
					<td>${answer.question.getIdQuestion()}</td>
					<td>${answer.sequenceNo}</td>
					<td>${answer.answerText}</td>
					<td>${answer.trueAnswer}</td>
					<td><a
						href="<c:url value='/edit/answer/${answer.idAnswer}' />">Edit</a></td>
					<td><a
						href="<c:url value='/remove/answer/${answer.idAnswer}' />">Delete</a></td>
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
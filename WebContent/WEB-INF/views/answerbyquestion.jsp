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
<title>Answer By Question</title>
</head>
<body>
	<h2>Question ID: ${question.idQuestion}</h2>
	<br />

	<c:if test="${!empty question}">


		<table class="TableMe">

			<tr>
				<td>${question.questionText}</td>
			</tr>
			<c:forEach items="${listAnswerByQuestion}" var="ans">

				<tr>
					<td>${ans.answerText}</td>
				</tr>

			</c:forEach>
			<tr>
				<td><c:if test="${question.idQuestion ne 1 }">

						<a
							href="<c:url value='/questions/getQuestionWithAnswers/${question.idQuestion-1}' />">Back</a>
					</c:if> <c:if test="${question.idQuestion ne 3 }">
						<a
							href="<c:url value='/questions/getQuestionWithAnswers/${question.idQuestion+1}' />">Next</a>

					</c:if></td>

			</tr>

		</table>

	</c:if>
</body>
</html>
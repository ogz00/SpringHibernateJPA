<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/exam.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="App.Title"></spring:message></title>


</head>
<body style="font-family: Arial; font-size: smaller;">


	<center>
		<h2>Exam page Details</h2>
	</center>

	<br />

	<center>

		<table style="border-collapse: collapse;" border="1"
			bordercolor="#006699" width="500">
			<tr bgcolor="lightblue"></tr>
			<c:if test="${empty SEARCH_QUESTIONS_RESULT_KEY}">
				<tr>
					<td colspan="4">No Results found</td>
				</tr>
			</c:if>
			<c:if test="${! empty SEARCH_QUESTIONS_RESULT_KEY}">

				<c:forEach var="question" items="${SEARCH_QUESTIONS_RESULT_KEY}">
					<tr>
						<td><c:out value="${questions.questionText}"></c:out></td>
					</tr>
					<c:forEach var="answer"
						items="${SEARCH_ANSWERS_RESULT_KEY.getAnswers()}">
						<!-- Answer tarafına questiona yazılanın yanısını yaz -->

						<tr>
							<td><c:out value="${answer.answerText}"></c:out></td>
						</tr>


					</c:forEach>


				</c:forEach>
			</c:if>
		</table>
	</center>




</body>
</html>
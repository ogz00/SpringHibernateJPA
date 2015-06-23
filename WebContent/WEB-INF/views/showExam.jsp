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


	<center><h2>Exam page Details</h2></center>

<br />

	<center>

		<table style="border-collapse: collapse;" border="1"
			bordercolor="#006699" width="500">
			<tr bgcolor="lightblue">
				<th>Exam Id</th>
				<th>Exam Name</th>
				<th>Exam Start Date</th>
				<th>Exam End date</th>
				<th>Status</th>
				<th>Action</th>

				<th></th>
			</tr>
			<c:if test="${empty SEARCH_EXAM_RESULTS_KEY}">
				<tr>
					<td colspan="4">No Results found</td>
				</tr>
			</c:if>
			<c:if test="${! empty SEARCH_EXAM_RESULTS_KEY}">
				<c:forEach var="exam" items="${SEARCH_EXAM_RESULTS_KEY}">
					<tr>
						<td><c:out value="${exam.idExam}"></c:out></td>
						<td><c:out value="${exam.name}"></c:out></td>
						<td><fmt:formatDate value="${exam.startDate}"
								pattern="dd-MM-yyyy" /></td>
						<td><fmt:formatDate value="${exam.endDate}"
								pattern="dd-MM-yyyy" /></td>

						<td><c:out value="${exam.status}"></c:out></td>

						<td>&nbsp;<a href="updateExam.do?idExam=${exam.idExam}">Edit</a>
							&nbsp;&nbsp; <a href="viewExam.do?idExam=${exam.idExam}">View</a>
						</td>

						<td><a href="viewQuestions.do?idExam=${exam.idExam}">Questions</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</center>

	<br />
	<center>

		<input type="button" value="add new exam"
			onclick="javascript:go('saveExam.do');" /> &nbsp;&nbsp; <input
			type="button" value="Back" onclick="javascript:go('viewAllExam.do');">
	</center>
</body>
</html>

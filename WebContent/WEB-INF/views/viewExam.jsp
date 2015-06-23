<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/exam.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="App.Title"></spring:message></title>
</head>
<body style="font-family: Arial; font-size: smaller;">

	<table bgcolor="lightblue" width="750" height="500" align="center"
		style="border-collapse: collapse;" border="1" bordercolor="#006699">
		<tr>
			<td align="center"><h3>Exam Detail</h3></td>
		</tr>
		<tr valign="top" align="center">
			<td align="center"><form:form action="viewExam.do" method="post"
					commandName="viewExam">
					<table width="500" style="border-collapse: collapse;" border="0"
						bordercolor="#006699" cellspacing="2" cellpadding="2">
						<tr>
							<td width="100" align="right">Exam ID</td>
							<td width="150"><form:input path="idExam" readonly="true" /></td>
							<td align="left"><form:errors path="idExam"
									cssStyle="color:red"></form:errors></td>
						</tr>
						<tr>
							<td width="100" align="right">Exam Name</td>
							<td><form:input path="name" readonly="true" /></td>
							<td align="left"><form:errors path="name"
									cssStyle="color:red"></form:errors></td>
						</tr>

						<tr>
							<td width="100" align="right">Start Date</td>
							<td><form:input path="startDate" readonly="true" /></td>
							<td align="left"><form:errors path="startDate"
									cssStyle="color:red"></form:errors></td>
						</tr>

						<tr>
							<td width="100" align="right">End Date</td>
							<td><form:input path="endDate" readonly="true" /></td>
							<td align="left"><form:errors path="endDate"
									cssStyle="color:red"></form:errors></td>
						</tr>
						<tr>
							<td width="100" align="right">STATUS</td>
							<td><form:select path="status" readonly="true">

									<form:option value="C" label="Completed" />
									<form:option value="NC" label="Incomplete" />
								</form:select></td>
							<td></td>
						</tr>
						<tr valign="bottom">
							<td colspan="1" align="center"><input type="button"
								value="Back" onclick="javascript:go('viewAllExam.do');">
							</td>
						</tr>
					</table>
				</form:form></td>
		</tr>
	</table>
</body>
</html>

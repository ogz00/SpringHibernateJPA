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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/exam.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<title><spring:message code="App.Title"></spring:message></title>
</head>
<body style="font-family: Arial; font-size: smaller;">

	<table bgcolor="lightblue" width="750" height="500" align="center"
		style="border-collapse: collapse;" border="1" bordercolor="#006699">
		<tr>
			<td align="center"><h3>Edit Exam Detail</h3></td>
		</tr>
		<tr valign="top" align="center">
			<td align="center"><form:form action="updateExam.do"
					method="post" commandName="editExam">
					<table width="500" style="border-collapse: collapse;" border="0"
						bordercolor="#006699" cellspacing="2" cellpadding="2">
						<tr>
							<td width="100" align="right"><form:label path="idExam">
									<spring:message text="Exam ID" />
								</form:label></td>
							<td width="150"><form:input path="idExam" readonly="true"
									disabled="true" /></td>
							<td align="left"><form:errors path="idExam"
									cssStyle="color:red"></form:errors></td>
						</tr>
						<tr>
							<td width="100" align="right"><form:label path="name">
									<spring:message text="Exam Name" />
								</form:label></td>
							<td><form:input path="name" /></td>
							<td align="left"><form:errors path="name"
									cssStyle="color:red"></form:errors></td>
						</tr>

						<tr>
							<td width="100" align="right"><form:label path="startDate">
									<spring:message text="Start Date" />
								</form:label></td>
							<td><form:input path="startDate" id="demo1" type="text"
									size="25" /><a href="javascript:NewCal('demo1','ddmmyyyy')"><img
									src="${pageContext.request.contextPath}/resources/image/cal.gif" width="16" height="16" border="0"
									alt="Pick a date"></a></td>

							<%-- <td><form:input path="START_DATE"/></td>  
       --%>
							<td align="left"><form:errors path="startDate"
									cssStyle="color:red"></form:errors></td>
						</tr>

						<tr>
							<td width="100" align="right"><form:label path="endDate">
									<spring:message text="End Date" />
								</form:label></td>
							<td><form:input path="endDate" id="demo2" type="text"
									size="25" /><a href="javascript:NewCal('demo2','ddmmyyyy')"><img
									src="${pageContext.request.contextPath}/resources/image/cal.gif" width="16" height="16" border="0"
									alt="Pick a date"></a></td>


							<%-- <td><form:input path="END_DATE"/></td> --%>
							<td align="left"><form:errors path="endDate"
									cssStyle="color:red"></form:errors></td>
						</tr>
						<tr>
							<td width="100" align="right"><form:label path="status">
									<spring:message text="Status" />
								</form:label></td>
							<td><form:select path="status">

									<form:option value="Completed" label="Completed" />
									<form:option value="Incomplete" label="Incomplete" />
								</form:select></td>
						</tr>

						<tr>
							<td width="100" align="right"><form:label path="description">
									<spring:message text="Description" />
								</form:label></td>
							<td><form:input path="description" /></td>
							<td align="left"><form:errors path="description"
									cssStyle="color:red"></form:errors></td>
						</tr>



						<tr valign="bottom">
							<td colspan="2" align="center"><input type="button"
								value="Delete"
								onclick="javascript:executeDelete('deleteExam.do?idExam=${editExam.idExam}');">
								&nbsp;&nbsp; <input type="submit" name="" value="Save">
								&nbsp;&nbsp; <input type="button" value="Back"
								onclick="javascript:go('viewAllExam.do');"></td>
						</tr>

					</table>
				</form:form></td>
		</tr>
	</table>
</body>
</html>

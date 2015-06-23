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
	src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/datetimepicker.js"></script>
<title><spring:message code="App.Title"></spring:message></title>
</head>

<body style="font-family: Arial; font-size: smaller;">

	<table bgcolor="#F1D4B8" width="1000" height="600" align="center"
		style="border-collapse: collapse;" border="1" bordercolor="#006699">
		<tr>
			<td align="center"><h3>Adding new Exam</h3></td>
		</tr>
		<tr valign="top" align="center">
			<td align="center"><form:form action="saveExam.do" method="post"
					commandName="newExam">

					<table width="700" style="border-collapse: collapse;" border="0"
						bordercolor="#006699" cellspacing="2" cellpadding="2">
						<tr>
							<td width="50" align="right">Exam Name</td>
							<td width="50"><form:input path="name" /></td>
							<td align="left"><form:errors path="name"
									cssStyle="color:red"></form:errors></td>
						</tr>

						<tr>
							<td width="75" align="right">Start Date</td>
							<td><form:input path="startDate" id="demo1" type="text"
									size="25" /><a href="javascript:NewCal('demo1','ddmmyyyy')"><img
									src="${pageContext.request.contextPath}/resources/image/cal.gif"
									width="16" height="16" border="0" alt="Pick a date"></a></td>

							<td align="left"><form:errors path="startDate"
									cssStyle="color:red"></form:errors></td>
						</tr>
						<tr>
							<td width="50" align="right">End Date</td>
							<td><form:input path="endDate" id="demo2" type="text"
									size="25" /><a href="javascript:NewCal('demo2','ddmmyyyy')"><img
									src="${pageContext.request.contextPath}/resources/image/cal.gif"
									width="16" height="16" border="0" alt="Pick a date"></a></td>

							<td align="left"><form:errors path="endDate"
									cssStyle="color:red"></form:errors></td>
						</tr>

						<tr>
							<td width="50" align="right">STATUS</td>
							<td><form:select path="status">

									<form:option value="Completed" label="Completed" />
									<form:option value="Incomplete" label="Incomplete" />
								</form:select></td>
						</tr>
					</table>

					<table width="700" style="border-collapse: collapse;" border="0"
						bordercolor="#006699" cellspacing="2" cellpadding="2">
						<tr>
							<td>
								<div id='TextBoxesGroup'>
									<div id="TextBoxDiv1">
										<p style="vertical-align: middle;">
											Question #1 :
											<form:textarea cols="29" rows="3" path="questions" />
										</p>
										<br /> Answer #1 : &nbsp;
										<form:input path="answers" id='textbox1' size="50" />
										&nbsp; #Is True Answer(Set 0 OR 1) ?
										<form:input path="trueAnswer" id='boolBox1' size="1"
											maxlength="1" />
										&nbsp; <br />Answer #2 : &nbsp;
										<form:input path="answers" id='textbox2' size="50" />
										&nbsp; #Is True Answer(Set 0 OR 1) ?
										<form:input path="trueAnswer" id='boolBox2' size="1"
											maxlength="1" />
										&nbsp; <br />Answer #3 : &nbsp;
										<form:input path="answers" id='textbox3' size="50" />
										&nbsp; #Is True Answer(Set 0 OR 1) ?
										<form:input path="trueAnswer" id='boolBox3' size="1"
											maxlength="1" />
										&nbsp; <br />Answer #4 : &nbsp;
										<form:input path="answers" id='textbox4' size="50" />
										&nbsp; #Is True Answer(Set 0 OR 1) ?
										<form:input path="trueAnswer" id='boolBox4' size="1"
											maxlength="1" />
										&nbsp; <br />
										<br />

									</div>
								</div>
						</tr>
						<tr>
							<td colspan="5"><input type='button' value='Add Question'
								id='addButton'>&nbsp;&nbsp; <input type='button'
								value='Remove Question' id='removeButton'></td>
						</tr>

						<tr>
							<td colspan="3" align="center"><input type="submit" name=""
								value="Save"> &nbsp;&nbsp; <input type="reset" name=""
								value="Reset"> &nbsp;&nbsp; <input type="button"
								value="Back" onclick="javascript:go('viewAllExam.do');">
							</td>
						</tr>
					</table>
				</form:form></td>
		</tr>
	</table>
</body>
</html>

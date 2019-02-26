<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Add Education</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-education-style.css"/>
		 
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Education</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Education</h3>
		<form:form action="addEducation" modelAttribute="education" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Educational level:</label></td>
						<td><form:input path="educationalLevel" /></td>
					</tr>
					<tr>
						<td><label>Course:</label></td>
						<td><form:input path="course" /></td>
					</tr>
					<tr>
						<td><label>Institution:</label></td>
						<td><form:input path="institution" /></td>
					</tr>
					<tr>
						<td><label>Start year:</label></td>
						<td><form:input path="startYear" /></td>
					</tr>
					<tr>
						<td><label>End year:</label></td>
						<td><form:input path="endYear" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
			
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/education/list">Back to List</a>
		</p>
	</div>
</body>
</html>






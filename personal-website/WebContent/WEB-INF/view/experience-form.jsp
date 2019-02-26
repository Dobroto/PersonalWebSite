<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Add Experience</title>
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
			<h2>Experience</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Experience</h3>
		<form:form action="addExperience" modelAttribute="experience" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Work Position:</label></td>
						<td><form:input path="workPosition" /></td>
					</tr>
					<tr>
						<td><label>Company:</label></td>
						<td><form:input path="company" /></td>
					</tr>
					<tr>
						<td><label>Start date:</label></td>
						<td><form:input path="startDate" /></td>
					</tr>
					<tr>
						<td><label>End date:</label></td>
						<td><form:input path="endDate" /></td>
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
			<a href="${pageContext.request.contextPath}/experience/list">Back to List</a>
		</p>
	</div>
</body>
</html>






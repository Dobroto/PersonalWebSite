<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Add Skill</title>
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
			<h2>Skill</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Skill</h3>
		<form:form action="addSkill" modelAttribute="skill" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>Skill Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Level:</label></td>
						<td><form:input path="level" /></td>
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
			<a href="${pageContext.request.contextPath}/skill/list">Back to List</a>
		</p>
	</div>
</body>
</html>






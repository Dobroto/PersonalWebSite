<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Education</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>Education</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		<security:authorize access="hasRole('ADMIN')">
		
			<input type="button" value="Add Education"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"/>
		</security:authorize>
		<table>
			<tr>
				<th>Educational Level</th>
				<th>Course</th>
				<th>Institution</th>
				<th>Start year</th>
				<th>End year</th>
				<security:authorize access="hasRole('ADMIN')">
				<th>Action</th>
				</security:authorize>
			</tr>
			
			<c:forEach var="tempEducation" items="${educations}">
				<c:url var="updateLink" value="/education/showFormForUpdate">
					<c:param name="educationId" value="${tempEducation.id }"/>
				</c:url>
				
				<c:url var="deleteLink" value="/education/delete">
					<c:param name="educationId" value="${tempEducation.id }"/>
				</c:url>
				
				<tr>
					<td>${tempEducation.educationalLevel}</td>
					<td>${tempEducation.course}</td>
					<td>${tempEducation.institution}</td>
					<td>${tempEducation.startYear}</td>
					<td>${tempEducation.endYear}</td>
					<td>
						<security:authorize access="hasRole('ADMIN')">
							<a href="${updateLink}">Update</a>
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to remove this education?'))) return false">Delete</a>
						</security:authorize>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<div>
	<a href="${pageContext.request.contextPath}/home/start">Back to Home Page</a>
</div>
</body>
</html>
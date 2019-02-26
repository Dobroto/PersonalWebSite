<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Work Experience</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>Work experience</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		<security:authorize access="hasRole('ADMIN')">
			<input type="button" value="Add Work"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"/>
		</security:authorize>
		<table>
			<tr>
				<th>Work Position</th>
				<th>Company</th>
				<th>Start date</th>
				<th>End date</th>
				<security:authorize access="hasRole('ADMIN')">
				<th>Action</th>
				</security:authorize>	
			</tr>
			<c:forEach var="tempExperience" items="${experiences}">
				<c:url var="updateLink" value="/experience/showFormForUpdate">
					<c:param name="experienceId" value="${tempExperience.id }"/>
				</c:url>
				
				<c:url var="deleteLink" value="/experience/delete">
					<c:param name="experienceId" value="${tempExperience.id }"/>
				</c:url>
				
				<tr>
					<td>${tempExperience.workPosition}</td>
					<td>${tempExperience.company}</td>
					<td>${tempExperience.startDate}</td>
					<td>${tempExperience.endDate}</td>
					<td>
						<security:authorize access="hasRole('ADMIN')">
							<a href="${updateLink}">Update</a>
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to remove this experience?'))) return false">Delete</a>
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
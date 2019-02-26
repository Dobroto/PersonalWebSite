<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Skills</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

<div id="wrapper">
	<div id="header">
		<h2>Skills</h2>
	</div>
</div>

<div id="container">
	<div id="content">
		<security:authorize access="hasRole('ADMIN')">
			<input type="button" value="Add Skills"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"/>
		</security:authorize>		   
		<table>
			<tr>
				<th>Skill name</th>
				<th>Level</th>
				<security:authorize access="hasRole('ADMIN')">
				<th>Action</th>
				</security:authorize>	
			</tr>
			
			<c:forEach var="tempSkill" items="${skills}">
				<c:url var="updateLink" value="/skill/showFormForUpdate">
					<c:param name="skillId" value="${tempSkill.id }"/>
				</c:url>
				
				<c:url var="deleteLink" value="/skill/delete">
					<c:param name="skillId" value="${tempSkill.id }"/>
				</c:url>
				
				<tr>
					<td>${tempSkill.name}</td>
					<td>${tempSkill.level}</td>
					<td>
						<security:authorize access="hasRole('ADMIN')">
							<a href="${updateLink}">Update</a>
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to remove this skill?'))) return false">Delete</a>
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
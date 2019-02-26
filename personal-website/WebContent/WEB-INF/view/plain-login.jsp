<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/colors-and-styles.css"/>

</head>

<body>
	<h3>Login</h3>
	
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			   method="POST">
			 
		<c:if test="${param.error != null }">
			<i class="failed">Sorry! you entered invalid username/password.</i>
		</c:if>
		
		<c:if test="${param.logout != null}">
		
			<div>
				You have been logged out.
			</div>
		
		</c:if>
		<p>
			User name: <input type="text" name="username"/>
		</p>
		
		<p>
			Password: <input type="password" name="password"/>
		</p>
		
		<input type="submit" value="Login" class="buttonStyle"/>
		
	</form:form>
	<p>
		<a href="${pageContext.request.contextPath }/home/start">Enter as guest</a>
	</p>
</body>
</html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
	
<html>
<head>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/colors-and-styles.css"/>
</head>
<body>

	<h3>
		Welcome to my web site
	</h3>
	
	<div id="introduction">
		<p>
		My name is Bobby. I like to climb mountains, go to the seaside and read books.
		If you want to learn more about me and my professional interests, you can have a look.
		If you are interested in technologies like Java and Spring, you can email me at georg.borislav@gmail.com
		</p>
		
	</div>
	
	<hr>
	
	<p>
		<a href="${pageContext.request.contextPath }/education/list">Education</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath }/skill/list">Skills</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath }/experience/list">Experience</a>
	</p>
	<hr>
	
	<br/>
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Login" class="buttonStyle"/>
	
	</form:form>

</body>

</html>

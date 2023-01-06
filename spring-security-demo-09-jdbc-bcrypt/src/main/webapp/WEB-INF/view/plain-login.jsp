<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Custom Login Page</title>

<style>
	.failed{
		color: red;
	}
</style>
</head>
<body>
	<h3>My custom login page</h3>
	
	<form:form action="${pageContext.request.contextPath }/authenticateTheUser" method="post">
		
		<!-- check for login error -->
		
		<c:if test="${param.error != null }">
			
			<i class="failed">Sorry! you entered invalid usernamr/password.</i>
			
		</c:if>	
		
		<p>
			userName: <input type="text" name="username"/>
		</p>
		<p>
			passWord: <input type="password" name="password"/>
		</p>
		<input type="submit" value="login"/>
	</form:form>
</body>
</html>
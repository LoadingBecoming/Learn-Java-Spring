<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<HTML>

<head>
	<title> Customer Form </title>
	
	<style>
		.error{
			color:red
		}
		
	</style>
</head>

<body>
	<i>Fill on the form. Asterick (*) means required</i>
	<form:form action="processForm" modelAttribute ="customer">
	
		FirstName (*):  <form:input path="firstName"/> <br>
		
		LastName: <form:input path = "lastName"/>
		<form:errors path="lastName" cssClass="error"/> <br>
		
		Free passes: <form:input path = "freePasses"/>
		<form:errors path="freePasses" cssClass="error"/> <br>
		
		Postal code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/> <br>
		
		Course code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/> <br>
		
		<input type = "submit" value="submit" />
	</form:form>
	
	
</body>

</HTML>
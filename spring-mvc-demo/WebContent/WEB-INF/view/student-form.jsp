<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name: <form:input path="lasttName"/>
		
		<br><br>
		
		Country: <form:select path="country">
		
					<!-- <form:option value="Brazil" label="Br"/>
					<form:option value="France" label="Fr"/>
					<form:option value="Germany" label="Ger"/>
					<form:option value="India" label="In"/>
					<form:option value="VietNam" label="Vi"/> --> 
			
					 <form:options items="${student.countryOptions }"/>
				</form:select> 
			
		<br><br>
		
		Favorite Language: 
					C# <form:radiobutton path="favoriteLang" value="C#"/>
					java <form:radiobutton path="favoriteLang" value="Java"/>
					Py <form:radiobutton path="favoriteLang" value="Py"/>
					Js <form:radiobutton path="favoriteLang" value="Js"/>
		
		<br><br>
		
		Operate System: 
					Linux <form:checkbox path="operateSystems" value="Linux"/>
					Window <form:checkbox path="operateSystems" value="Window"/>
					MacOS <form:checkbox path="operateSystems" value="MacOS"/>
		
		<br><br>
		
		<input type="submit" value="Submit"/>
	
	</form:form>




	
</body>
</html>

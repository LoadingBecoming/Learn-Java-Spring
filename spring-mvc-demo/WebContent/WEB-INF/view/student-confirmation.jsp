<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Confirmation</title>
</head>

<body>

	The student is confirmed: ${student.firstName} ${student.lasttName }
	
	<br>
	
	The student come from: ${student.country }
	
	<br>
	
	Student's favorite Language: ${student.favoriteLang }
	
	<br>
	
	Operate Systems:
	
	<ul>
		<c:forEach var="temp" items = "${student.operateSystems }">
			<li> ${temp }</li>
		</c:forEach>
	</ul>
	
	
</body>

</html>
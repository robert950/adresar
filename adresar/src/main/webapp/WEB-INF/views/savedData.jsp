<%@	page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@	taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@	page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="resources/design.css" rel="stylesheet" type="text/css">
	
	<title>Saved Data</title>
</head>

<body>

	<h2>View saved data</h2>
	
	<table class="table table-striped">
		<tr>
			<th>First name: </th>
			<th>Last name: </th>
			<th>Phone: </th>
			<th>eMail: </th>
			
			<th>Country: </th>
			
			<th>City: </th>	
			<th>Zip Code: </th>
			
			<th>Street: </th>
			<th>Street number: </th>
			
			<th>Sex: </th>
		</tr>
			
		
		<c:forEach items="${data}" var="entry">
			<tr>	
				<td>${entry.contact.firstName}</td>
				<td>${entry.contact.lastName}</td>
				<td>${entry.contact.phone}</td>
				<td>${entry.contact.eMail}</td>
				
				<td>${entry.country.name}</td>
				
				<td>${entry.city.name}</td> 
				<td>${entry.city.zipCode}</td>
				
				<td>${entry.address.street}</td>
				<td>${entry.address.street_NO}</td>
				
				<td>${entry.sex.name}</td>	
			</tr>
		</c:forEach>
		
		
			
	</table>
			
	<form:form method="GET" >
		<input type="submit" name="back" class="button" value="back" />
	</form:form>

</body>
</html>
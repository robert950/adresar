<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="resources/design.css" rel="stylesheet" type="text/css">
	
	<title>Data</title>

</head>
<body>

	<h2>Enter your data</h2>
	
	<form:form method="POST" modelAttribute="newDataForm">
	
		<table>	
			
			<tr><td><label>Contact:</label> </td></tr>
			
			<tr> <td> First name: </td> <td> <form:input type="text" path="firstName" /> </td> </tr>
			<tr> <td> Last name: </td> <td> <form:input type="text" path="lastName" /> </td> </tr>
			<tr> <td> Phone: </td> <td> <form:input type="text" path="phone" /> </td> </tr>
			<tr> <td> Email: </td> <td> <form:input type="text" path="eMail" /> </td> </tr>	 
			
				
			
			
			<tr>
				<td><label>Country:</label> </td>
				<td>
					<form:select id="countryName" path="countryName">
						<form:options items="${countries}" itemLabel="name" itemValue="name" />					
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td><label>City:</label> </td>
				<td>

					<form:select id="cityName" path="cityName">
						<form:options items="${cities}" itemLabel="name" itemValue="name" />
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td><label>City Zip:</label> </td>
				<td>

					<form:select id="zipCode" path="zipCode">
						<form:options items="${cities}" itemLabel="zipCode" itemValue="zipCode" />
					</form:select>
				</td>
			</tr>
			
			<tr> <td><label>Address:</label> </td> </tr>
				
			<tr> <td> Street name: </td> <td> <form:input type="text" path="street" /> </td> </tr>
			<tr> <td> Street number: </td> <td> <form:input type="text" path="streetNo" /> </td> </tr>
		

			
			<tr>
				<td><label>Sex:</label> </td>
				<td>

					<form:select id="sex" path="sex">
						<form:options items="${sexes}" itemLabel="name" itemValue="name" />
					</form:select>
				</td>
			</tr>

		
			<tr>
				<td>
					<input type="submit" name="saveButton" id="saveButton" value="Check your data">
				</td>
			</tr>
			
		</table>
		
		
	</form:form>
		
	<a href="<spring:url value="/savedData" />" > <button> View saved data </button> </a>	
	

</body>
</html>
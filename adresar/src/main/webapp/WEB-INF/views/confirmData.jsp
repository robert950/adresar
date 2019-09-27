<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="resources/design.css" rel="stylesheet" type="text/css">
	
	<title>Insert title here</title>
</head>
<body>

	<h1> Confirm entered data </h1>
	
	<p>First name: ${newDataForm.firstName}</p>
	<p>Last name: ${newDataForm.lastName}</p>
	<p>Phone: ${newDataForm.phone}</p>
	<p>eMail: ${newDataForm.eMail}</p>
	
	<p>Country: ${newDataForm.countryName}</p>
	<p>City: ${newDataForm.cityName}</p>
	<p>Street name: ${newDataForm.street}</p>
	<p>Street number: ${newDataForm.streetNo}</p>
	
	<p>Sex: ${newDataForm.sex}</p>
	
	
				
	<button type="button" name="back" onclick="history.back()"> back </button>
		
	<form:form method="GET" >
		<input type="submit" name="confirm" class="button" value="Save data" />
	</form:form>
	
	
	
	
</body>
</html>
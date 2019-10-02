<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>	  
	<head>
		<title>Login Page</title>
		<link href="resources/design.css" rel="stylesheet" type="text/css">
	</head>
	
	<body>
	
		<h3> Login with Username and Password </h3>
		<form:form name='f' method='POST' action="login">
			<table>
				<tr>
					<td> User: </td>
					<td> <input type='text' name='username' value=''> </td>
				</tr>
				<tr>
					<td> Password: </td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'><button name="submit" type="submit"> Submit </button></td>
				</tr>
			</table>
		</form:form>
	
	</body>

</html>
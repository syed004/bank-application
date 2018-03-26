<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>welcome</title>
<style>
div.fixed {
	position: fixed;
	width: 100%;
	bottom: 40px;
}
</style>
</head>
<body style="background-color: gray;">
	<div class="container">
		<br> <br>

		<h1>Welcome to my Website</h1>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />

		<a href="${contextPath}/register" class="btn btn-info" role="button">Register
			Here!</a> <a href="${contextPath}/login" class="btn btn-info"
			role="button">Login Here!</a>
	</div>


</body>
</html>
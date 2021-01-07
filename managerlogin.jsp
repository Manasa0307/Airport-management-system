<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/stylepage.css">
</head>
<body>
	<h3>THE AIR SERVICES</h3>
	<div class="menu">
		<a href="${pageContext.request.contextPath}/admin/welcome">Admin
			Page </a> <a href="${pageContext.request.contextPath}/manager/welcome">Manager
			Page</a>
	</div>
	<form method="get">
		<div class="imgcontainer">
			<img
				src="${pageContext.request.contextPath}/contents/images/airport.png"
				alt="airport" class="avatar">
		</div>
		<div class="container">
			<p style="color: red; align-content: center;">${accessdenied}</p>
			<form:form method="get" modelAttribute="manager">
				<label>Enter Manager First Name:</label>
				<form:input path="ManagerFirstName"
					placeholder="Enter Manager First Name" required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="ManagerFirstName" cssClass="error" />
				<br>
				<label>Enter Password:</label>
				<form:password path="ManagerPassword" placeholder="Enter Password"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<br>
				<form:button name="login" value="submit" formaction="./authenticate">Submit</form:button>
			</form:form>
			<br>Not a member yet?<a href="./newmanager"> please register
				as a manager</a>
		</div>
	</form>
</body>
</html>
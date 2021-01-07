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
		<div class="container">
			<form:form method="get" modelAttribute="admin">
				<label>Enter Admin  Name:</label>
				<form:input path="AdminFirstName"
					placeholder="Enter  Name" required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="AdminFirstName" cssClass="error" />
				<br>
				<label>Enter Password:</label>
				<form:password path="AdminPassword" placeholder="Enter Password"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="AdminPassword" cssClass="error" />
				<br>
				<form:button name="login" value="submit" formaction="./authenticate">Submit</form:button>
			</form:form>
			<br>Not a member yet?<a href="./newadmin"> please register
				as an admin</a>
		</div>
	</form>
</body>
</html>
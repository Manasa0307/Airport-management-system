<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Registration</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/stylepage.css">
</head>
<body>
	<h3>ADMIN REGISTRATION</h3>
	<form method="get">
		<br>
		<div class="container">
			<p style="color: red; align-content: center;">${nouser}</p>
			<p style="color: red; align-content: center;">${userexists}</p>
			<form:form method="get" modelAttribute="admin">
				<label>Enter Firstname: *</label>
				<form:input path="AdminFirstName" placeholder="Enter Firstname"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="AdminFirstName" cssClass="error" />
				<br>
				<label>Enter Lastname:</label>
				<form:input path="AdminLastName" placeholder="Enter Lastname"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="AdminLastName" cssClass="error" />
				<br>
				<label>Enter Age:</label>
				<form:input path="AdminAge" placeholder="Enter Age"
					required="required" />
				<form:errors path="AdminAge" cssClass="error" />
				<br>
				<label>Enter Gender:</label>
				<form:input path="AdminGender" placeholder="Enter Gender"
					required="required" />
				<form:errors path="AdminGender" cssClass="error" />
				<br>
				<label>Enter Contact number: *</label>
				<form:input path="AdminContactNumber"
					placeholder="Enter Contact number" required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="AdminContactNumber" cssClass="error" />
				<br>
				<label>Enter Password: *</label>
				<form:password path="AdminPassword" placeholder="Enter Password"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="AdminPassword" cssClass="error" />
				<br>
				<button type="submit" name="submit" value=submit
					formaction="./addadmin">Submit</button>
			</form:form>
		</div>
	</form>
</body>
</html>
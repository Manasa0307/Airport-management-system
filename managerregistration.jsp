<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Registration</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/stylepage.css">
</head>
<body>
	<h3>MANAGER REGISTRATION</h3>
	<form method="get">
		<br>
		<div class="container">
			<p style="color: red; align-content: center;">${nouser}</p>
			<p style="color: red; align-content: center;">${userexists}</p>
			<form:form method="get" modelAttribute="manager">
				<label>Enter Firstname: *</label>
				<form:input path="ManagerFirstName" placeholder="Enter Firstname"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="ManagerFirstName" cssClass="error" />
				<br>
				<label>Enter Lastname:</label>
				<form:input path="ManagerLastName" placeholder="Enter Lastname"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="ManagerLastName" cssClass="error" />
				<br>
				<label>Enter Age:</label>
				<form:input path="ManagerAge" placeholder="Enter Age"
					required="required" />
				<form:errors path="ManagerAge" cssClass="error" />
				<br>
				<label>Enter Gender:</label>
				<form:input path="ManagerGender" placeholder="Enter Gender"
					required="required" />
				<form:errors path="ManagerGender" cssClass="error" />
				<br>
				<label>Enter Contact number: *</label>
				<form:input path="ManagerContactNumber"
					placeholder="Enter Contact number" required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="ManagerContactNumber" cssClass="error" />
				<br>
				<label>Enter Password: *</label>
				<form:password path="ManagerPassword" placeholder="Enter Password"
					required="required"
					oninvalid="this.setCustomValidity('Mandatory field')"
					oninput="this.setCustomValidity('')" />
				<form:errors path="ManagerPassword" cssClass="error" />
				<br>
				<button type="submit" name="submit" value=submit
					formaction="./addmanager">Submit</button>
			</form:form>
		</div>
	</form>
</body>
</html>
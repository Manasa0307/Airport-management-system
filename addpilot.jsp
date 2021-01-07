<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Pilot</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/stylepage.css">

</head>
<body>
	<h3>ADD PILOT</h3>
	<jsp:include page="adminmenu.jsp" />
	<h2>Hi, ${sessionadmin.adminFirstName}</h2>

	<form:form method="get" modelAttribute="pilot">
		<p style="color: red;">${exists}</p>
		<table>
			<tr>
				<td><label>Pilot Name</label></td>
				<td><form:input path="PilotName" placeholder="Enter Pilot Name"
						required="required"
						oninvalid="this.setCustomValidity('Mandatory field')"
						oninput="this.setCustomValidity('')" /></td>
			</tr>
			<tr>
				<td><label>Pilot Location</label></td>
				<td><form:input path="PilotLocation"
						placeholder="Enter Pilot Location" required="required"
						oninvalid="this.setCustomValidity('Mandatory field')"
						oninput="this.setCustomValidity('')" /></td>

			</tr>
		</table>
		<button style="float: left" type="submit" name="save" value="save"
			formaction="./addpilot">Save</button>
	</form:form>
</body>
</html>
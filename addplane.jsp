<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Planes</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/stylepage.css">
</head>
<body>
	<h3>ADD PLANE</h3>
	<jsp:include page="adminmenu.jsp" />
	<h2>Hi, ${sessionadmin.adminFirstName}</h2>

	<form:form method="get" modelAttribute="plane">
		<p style="color: red;">${exists}</p>
		<table>
			<tr>
				<td><label>Plane Name</label></td>
				<td><form:input path="PlaneName" placeholder="Enter Plane Name"
						required="required"
						oninvalid="this.setCustomValidity('Mandatory field')"
						oninput="this.setCustomValidity('')" /></td>
			</tr>
		</table>
		<button style="float: left" type="submit" name="save" value="save"
			formaction="./addplane">Save</button>

	</form:form>
</body>
</html>
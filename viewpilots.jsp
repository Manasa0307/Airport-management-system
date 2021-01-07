<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/style_my_pets.css">
</head>
<body>
	<h3>AIRPORT MANAGEMENT</h3>
	<jsp:include page="adminmenu.jsp" />
	<h2>Hi, ${sessionadmin.adminFirstName}</h2>
	<div>
		<table class="center" id="pets">
			<thead>
				<tr>
					<th>Pilot Id</th>
					<th>Pilot Name</th>
					<th>Pilot Location</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.pilots}" var="pilot">
					<tr>
						<td><c:out value="${pilot.getPilotId()}" /></td>
						<td><c:out value="${pilot.pilotName}" /></td>
						<td><c:out value="${pilot.pilotLocation}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>


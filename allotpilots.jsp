<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Allot Pilot</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/style_my_pets.css">
</head>
<body>
	<h3>AIRPORT MANAGEMENT</h3>
	<jsp:include page="managermenu.jsp" />
	<h2>Hi, ${sessionmanager.managerFirstName}</h2>
	<div>
		<table class="center" id="pets">
			<thead>
				<tr>
					<th>Pilot Id</th>
					<th>Pilot Name</th>
					<th>Pilot Location</th>
					<th>Plane Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.pilots}" var="pilot">
					<tr>
						<td><c:out value="${pilot.getPilotId()}"></c:out></td>
						<td><c:out value="${pilot.pilotName}"></c:out></td>
						<td><c:out value="${pilot.pilotLocation}"></c:out></td>
						<c:choose>
							<c:when test="${empty pilot.plane}">
								<td><a
									href="./allotpilot?planeId=${planeId}&pilotId=${pilot.getPilotId()}">Allot</a></td>
							</c:when>
							<c:otherwise>
								<td>
									<button disabled="disabled">Alloted</button>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>


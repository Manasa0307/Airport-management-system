<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Allot Plane</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/style_my_pets.css">
<style type="text/css">
</style>
</head>
<body>
	<h3>AIRPORT MANAGEMENT</h3>
	<jsp:include page="managermenu.jsp" />
	<h2>Hi, ${sessionmanager.managerFirstName}</h2>
	<div>
		<table class="center" id="pets">
			<thead>
				<tr>
					<th>PlaneId</th>
					<th>PlaneName</th>
					<th>Pilot Status</th>
					<th>Hangar Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.planes}" var="plane">
					<tr>
						<td><c:out value="${plane.getPlaneId()}"></c:out></td>
						<td><c:out value="${plane.planeName}"></c:out></td>
						<c:choose>
							<c:when test="${empty plane.pilot}">
								<td><a href="./pilot?planeId=${plane.getPlaneId()}">Allot
										Pilot</a></td>
							</c:when>
							<c:otherwise>
								<td>
									<button disabled="disabled">Alloted</button>
								</td>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${empty plane.hangar}">
								<td><a href="./hangar?planeId=${plane.getPlaneId()}">Allot
										Hanger</a></td>
							</c:when>
							<c:otherwise>
								<td>
									<button disabled="disabled">Alloted</button>
								</td>
							</c:otherwise>
						</c:choose>
						<c:if test=""></c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

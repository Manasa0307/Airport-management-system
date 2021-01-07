<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/style_my_pets.css">
</head>
<body>
	<h3>AIRPORT MANAGEMENT</h3>
	<jsp:include page="adminmenu.jsp" />
	<h2>Hi, ${sessionadmin.adminFirstName}</h2>
	<div>
		<table class="center" id=pets>
			<thead>
				<tr>
					<th>PlaneId</th>
					<th>PlaneName</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.planes}" var="plane">
					<tr>
						<td><c:out value="${plane.getPlaneId()}"></c:out></td>
						<td><c:out value="${plane.planeName}"></c:out></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</body>
</html>
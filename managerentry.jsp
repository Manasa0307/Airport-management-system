<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Approval</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/contents/csspages/style_my_pets.css">
</head>
<body>

	<h3>MANAGER APPROVAL</h3>
	<jsp:include page="adminmenu.jsp" />
	<h2>Hi, ${sessionadmin.adminFirstName}</h2>
	<div>
		<table class="center" id="pets">
			<thead>
				<tr>
					<th>Manager Id</th>
					<th>Manager First Name</th>
					<th>Manager Last Name</th>
					<th>Approval Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.managers}" var="manager">
					<tr>
						<td><c:out value="${manager.getManagerId()}"></c:out></td>
						<td><c:out value="${manager.managerFirstName}"></c:out></td>
						<td><c:out value="${manager.managerLastName}"></c:out></td>
						<c:choose>
							<c:when test="${empty manager.approvalStatus}">
								<td><a
									href="./managerentry?managerId=${manager.getManagerId()}">Approve</a></td>
							</c:when>
							<c:otherwise>
								<td>
									<button disabled="disabled">Approved</button>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/csspages/stylemenu.css">
</head>
<body>
	<div class="menu">
		<a href="${pageContext.request.contextPath}/admin/welcome">Log Out</a>
		<a href="./pilot">Add Pilot</a> <a href="./plane">Add Plane</a> <a
			href="./hangar">Add Hangar</a><a href="./viewpilots">View Pilot</a> <a
			href="./viewplanes">View Plane</a> <a href="./viewhangars">View
			Hangar</a> <a href="./getmanagers">Approve Managers</a>
	</div>
</body>
</html>
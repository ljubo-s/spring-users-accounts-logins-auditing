<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Roles List</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h2>Roles List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a></h2>
		<table class="table table-striped">
			<tr>
				<th scope="row">#ID</th>
				<th scope="row">Title</th>
				<th scope="row">Description</th>
				<th scope="row">Status</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</tr>
			<tbody>
				<c:forEach items="${rolesList }" var="roles">
					<tr>
						<td>${roles.id }</td>
						<td>${roles.title }</td>
						<td>${roles.description }</td>
						<td>${roles.status }</td>
						<td>
							<spring:url value="/roles/updateRoles/${roles.id }" var="updateURL" />
							<a class="btn btn-primary" href="${updateURL }" roles="button">Update</a>
						</td>
						<td>
							<spring:url value="/roles/deleteRoles/${roles.id }" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL }" roles="button">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/roles/addRoles/" var="addURL" />
		<a class="btn btn-primary" href="${addURL }" roles="button">Add New Roles</a>
	</div>
</body>
</html>
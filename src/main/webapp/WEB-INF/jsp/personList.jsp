<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users x Role List</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h2>Person List &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a></h2>
		<table class="table table-striped">
			<tr>
				<th scope="row">#ID</th>
				<th scope="row">Name</th>
				<th scope="row">Surname</th>
				<th scope="row">Phone</th>
				<th scope="row">Address</th>
				<th scope="row">Country</th>
				<th scope="row">Town</th>
				<th scope="row">Date of birth</th>
				<th scope="row">Date of insert</th>
				<th scope="row">Last update</th>
				<th scope="row">Status</th>
				<th scope="row">Update</th>
				<th scope="row">Delete</th>
			</tr>
			<tbody>
				<c:forEach items="${personList}" var="person">
					<tr>
						<td>${person.id}</td>
						<td>${person.name}</td>
						<td>${person.surname}</td>
						<td>${person.phone}</td>
						<td>${person.address}</td>
						<td>${person.country}</td>
						<td>${person.town}</td>
						<td>${person.dateofbirth}</td>
						<td>${person.dateofinsert}</td>
						<td>${person.lastupdate}</td>
						<td>${person.status}</td>
						<td>
							<spring:url value="/person/updatePerson/${person.id}" var="updateURL" />
							<a class="btn btn-primary" href="${updateURL}" role="button">Update</a>
						</td>
						<td>
							<spring:url value="/person/deletePerson/${person.id}" var="deleteURL" />
							<a class="btn btn-primary" href="${deleteURL}" role="button">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<spring:url value="/person/addPerson/" var="addURL" />
		<a class="btn btn-primary" href="${addURL}" role="button">Add New Person</a>
	</div>
</body>
</html>
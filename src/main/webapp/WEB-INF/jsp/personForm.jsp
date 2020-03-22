<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Form</title>
<script src="../../webjars/jquery/3.4.1/jquery.min.js"></script>
<script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<spring:url value="/person/savePerson" var="saveURL" />
		<h2>Person</h2>
		<form:form modelAttribute="personForm" method="post" action="${saveURL}" cssClass="form">
			<form:hidden path="id" />
			<div class="form-group">
				<label>Name</label>
				<form:input path="name" cssClass="form-control" id="name" />
			</div>
			<div class="form-group">
				<label>Surname</label>
				<form:input path="surname" cssClass="form-control" id="surname" />
			</div>
			<div class="form-group">
				<label>Phone</label>
				<form:input path="phone" cssClass="form-control" id="phone" />
			</div>
			<div class="form-group">
				<label>Date of birth</label>
				<form:input path="dateofbirth" cssClass="form-control" id="dateofbirth" />
			</div>
			<div class="form-group">
				<label>Date of insert</label>
				<form:input path="dateofinsert" cssClass="form-control" id="dateofinsert" />
			</div>
			<div class="form-group">
				<label>Last update</label>
				<form:input path="lastupdate" cssClass="form-control" id="lastupdate" />
			</div>
			<div class="form-group">
				<label>Address</label>
				<form:input path="address" cssClass="form-control" id="address" />
			</div>
			<div class="form-group">
				<label>Country</label>
				<form:input path="country" cssClass="form-control" id="country" />
			</div>
			<div class="form-group">
				<label>Town</label>
				<form:input path="town" cssClass="form-control" id="town" />
			</div>
			
			<div class="form-group">
				<label>Status</label>
				<form:input path="status" cssClass="form-control" id="status" />
			</div>			
			
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
</body>
</html>
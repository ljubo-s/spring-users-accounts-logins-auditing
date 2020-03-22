<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Users and Role</title>
<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css" /> 
<script type="text/javascript" src="DataTables/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="DataTables/datatables.min.js"></script>
<script>
	function val() {
		d = document.getElementById("select_users_id").value;
		document.getElementById("users_id").value = d;

		d = document.getElementById("select_roles_id").value;
		document.getElementById("roles_id").value = d;
	}
</script>
</head>
<body>
	<table width="100%" align="center">
		<tr>
			<td align="center">
				<h2>
					Users x Role &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/auditing/index"> * </a>
				</h2>

				<form:form action="usersRoles.form" method="post" modelAttribute="usersRoles">

					<table>
						<tr>
							<td>Id</td>
							<td>
								<form:input path="id"></form:input>
							</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>
								<form:input path="description"></form:input>
							</td>
						</tr>
						<tr>
							<td>Status</td>
							<td>
								<form:input path="status"></form:input>
							</td>
						</tr>
						<tr>
							<td>Users Id</td>
							<td>
								<form:input path="users.id" id="users_id" value="${param.users_id}"></form:input>
								&nbsp;&nbsp;&nbsp; Id:
							</td>
							<td>
								<select name="" onchange="val()" id="select_users_id">
									<option value="">	choose id	</option>
									<c:forEach items="${usersList}" var="users">
										<option value="${users.id}">id: ${users.id},&nbsp; ${users.username}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>Role Id</td>
							<td>
								<form:input path="roles.id" id="roles_id" value="${param.roles_id}"></form:input>
								&nbsp;&nbsp;&nbsp; Id:
							</td>
							<td>
								<select name="" onchange="val()" id="select_roles_id">
									<option value="">	choose id	</option>
									<c:forEach items="${rolesList}" var="roles">
										<option value="${roles.id}">id: ${roles.id},&nbsp; ${roles.title}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<br></br>
								<input type="submit" name="action" value="Add" />
								<input type="submit" name="action" value="Edit" />
								<input type="submit" name="action" value="Delete" />
								<input type="submit" name="action" value="Search" />
								<br></br>
							</td>
						</tr>
					</table>
				</form:form>

				<table class="display" style="width:100%; border: 1px solid; table-layout: fixed; word-wrap: break-word;" id="users_roles_table" class="display compact nowrap;">
					<thead style="background: #d3dce3">
						<tr>
							<th>on</th>
							<th>Id</th>
							<th>Description</th>
							<th>Status</th>
							<th>Users id</th>
							<th>Role id</th>
						</tr>
					</thead>
					<tbody style="background: #ccc">
						<c:forEach items="${usersRolesList}" var="usersRole" varStatus="i">
							<tr align="center">
								<td>
									<c:out value="${i.index + 1}" />
								</td>
								<td>${usersRole.id}</td>
								<td>${usersRole.description}</td>
								<td>${usersRole.status}</td>
								<td>${usersRole.users.id}</td>
								<td>${usersRole.roles.id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
		<script>
		$(document).ready(function() {
			$('#users_roles_table').dataTable({});
		});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Users and Role</title>
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
					Users x Role &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a>
				</h2>

				<form:form action="/usersRoles/usersRoles.form" method="post" modelAttribute="usersRoles">

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

				<table style="border: 1px solid; min-width: 80%; max-width: 100%; text-align: center" id="table_id">
					<thead style="background: #d3dce3">
						<tr>
							<th>rb</th>
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
									<c:out value="${i.index + 1 }" />
								</td>
								<td>${usersRoles.id}</td>
								<td>${usersRoles.description}</td>
								<td>${usersRoles.status}</td>
								<td>${usersRoles.users.id}</td>
								<td>${usersRoles.roles.id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
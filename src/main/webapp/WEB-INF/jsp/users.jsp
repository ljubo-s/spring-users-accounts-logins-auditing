<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Users</title>
<script>
	function val() {
		personId = document.getElementById("select_person_id").value;
		document.getElementById("person_id").value = personId;
	}
</script>
</head>
<body>
	<table width="100%" align="center">
		<tr>
			<td align="center">
				<h2>
					Users &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="index"> * </a>
				</h2>

				<form:form action="users.form" method="post" modelAttribute="users">

					<table>
						<tr>
							<td>Id</td>
							<td>
								<form:input path="id" />
							</td>
						</tr>
						<tr>
							<td>Username</td>
							<td>
								<form:input path="username"></form:input>
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>
								<form:input path="password"></form:input>
							</td>
						</tr>
						<tr>
							<td>Date of insert</td>
							<td>
								<form:input path="dateofinsert"></form:input>
							</td>
						</tr>
						<tr>
							<td>Status</td>
							<td>
								<form:input path="status"></form:input>
							</td>
						</tr>
						<tr>
							<td>Person Id</td>
							<td>
								<form:input path="person.id" id="person_id" value="${param.person_id}"></form:input>
								&nbsp;&nbsp;&nbsp; Id:
							</td>
							<td>
								<select name="" onchange="val()" id="select_person_id">
									<option value="">	choose id	</option>
									<c:forEach items="${personList}" var="person">
										<option value="${person.id}">id: ${person.id},&nbsp; ${person.name}</option>
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
							<th>Username</th>
							<th>Password</th>
							<th>Status</th>
							<th>Date of insert</th>
							<th>Person Id</th>
							<th>Roles </th>
						</tr>
					</thead>
					<tbody style="background: #ccc">
						<c:forEach items="${usersList}" var="users" varStatus="i">
							<tr align="center">
								<td>
									<c:out value="${i.index + 1 }" />
								</td>
								<td>${users.id}</td>
								<td>${users.username}</td>
								<td>${users.password}</td>
								<td>${users.status}</td>
								<td>${users.dateofinsert}</td>
								<td>${users.person.id}</td>
								<td>
								<c:forEach var="usersRoles" items="${users.usersRoles}">
       							     ${usersRoles.roles.title};
        		             	</c:forEach>
        		             	</td>
        		         	</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
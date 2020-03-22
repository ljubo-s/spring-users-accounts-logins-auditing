<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Users Aud</title>
<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css" /> 
<script type="text/javascript" src="DataTables/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="DataTables/datatables.min.js"></script>
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
					Users Aud &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/auditing/index"> * </a>
				</h2>

				<form:form action="usersaud.form" method="post" modelAttribute="usersaud">

					<table>
						<tr>
							<td>Rev[Id]</td>
							<td>
								<form:input path="rev"></form:input>
							</td>
						</tr>
						<tr>
							<td>Rev Type</td>
							<td>
								<form:input path="revtype"></form:input>
							</td>
						</tr>
						<tr>
							<td>Users Id</td>
							<td>
								<form:input path="id"></form:input>
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
								<form:input path="dateofinsert" placeholder="dd-MM-yyyy HH:mm:ss"></form:input>
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
								<form:input path="person.id"></form:input>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<br></br>
								<input type="submit" name="action" value="Add" disabled/>
								<input type="submit" name="action" value="Edit" disabled />
								<input type="submit" name="action" value="Delete" disabled />
								<input type="submit" name="action" value="Search" />
								<input type="submit" name="action" value="SearchByRev" />
								<br></br>
							</td>
						</tr>
					</table>
				</form:form>

				<table class="display" style="width:100%; border: 1px solid; table-layout: fixed; word-wrap: break-word;" id="users_aud_table" class="display compact nowrap;">
					<thead style="background: #d3dce3">
						<tr>
							<th>on</th>
							<th>Rev</th>
							<th>Rev Type</th>
							<th>Id</th>
							<th>Username</th>
							<th>Password</th>
							<th>Status</th>
							<th>Date of insert</th>
							<th>Person Id</th>
						</tr>
					</thead>
					<tbody style="background: #ccc">
						<c:forEach items="${usersaudList}" var="usersaud" varStatus="i">
							<tr align="center">
								<td>
									<c:out value="${i.index + 1 }" />
								</td>
								<td>${usersaud.rev}</td>
								<td>${usersaud.revtype}</td>
								<td>${usersaud.id}</td>
								<td>${usersaud.username}</td>
								<td>${usersaud.password}</td>
								<td>${usersaud.status}</td>
								<td><fmt:formatDate value="${usersaud.dateofinsert}" type="date" pattern="dd-MM-yyyy hh:mm:ss" /></td>
								<td>${usersaud.person.id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
	<script>
		$(document).ready(function() {
			$('#users_aud_table').dataTable({});
		});
	</script>
</body>
</html>
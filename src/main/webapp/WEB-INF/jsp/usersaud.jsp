<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Users Aud</title>
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
					Users Aud &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/"> * </a>
				</h2>

				<form:form action="/usersaud/usersaud.form" method="post" modelAttribute="usersaud">

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
								<form:input path="person.id"></form:input>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<br></br>
								<input type="submit" name="action" value="" />
								<input type="submit" name="action" value="" />
								<input type="submit" name="action" value="" />
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
								<td>${usersaud.dateofinsert}</td>
								<td>${usersaud.person.id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Roles</title>
<link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css" /> 
<script type="text/javascript" src="DataTables/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="DataTables/datatables.min.js"></script>
</head>
<body>
	<table width="100%" align="center">
		<tr>
			<td align="center">
				<h2>
					Roles &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/auditing/index"> * </a>
				</h2>

				<form:form action="roles.form" method="post" modelAttribute="roles">

					<table>
						<tr>
							<td>Id</td>
							<td>
								<form:input path="id"></form:input>
							</td>
						</tr>
						<tr>
							<td>Title</td>
							<td>
								<form:input path="title"></form:input>
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

				<table class="display" style="width:100%; border: 1px solid; table-layout: fixed; word-wrap: break-word;" id="roles_table" class="display compact nowrap;">
					<thead style="background: #d3dce3">
						<tr>
							<th>on</th>
							<th>Id</th>
							<th>Title</th>
							<th>Description</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody style="background: #ccc">
						<c:forEach items="${rolesList}" var="roles" varStatus="i">
							<tr align="center">
								<td>
									<c:out value="${i.index + 1 }" />
								</td>
								<td>${roles.id}</td>
								<td>${roles.title}</td>
								<td>${roles.description}</td>
								<td>${roles.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</td>
		</tr>		
	</table>
		<script>
		$(document).ready(function() {
			$('#roles_table').dataTable({});
		});
	</script>
</body>
</html>
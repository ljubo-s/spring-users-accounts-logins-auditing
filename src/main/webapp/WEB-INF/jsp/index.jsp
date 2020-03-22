<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ include file="includes.jsp"%>
<title>Index</title>
</head>
<body>
	<table style="width: 100%; border: 0;">
		<tr>
			<td>
				<div align="right">
					<form action="/auditing/logout" method="post">
						<input type="submit" value="Sign Out" /> 
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</td>
		</tr>	
		<tr>
			<td align="center">
				<h1>Index</h1>
				<p></p>
				<table style="width: 97%; border-spacing: 10px;">
					
					<tr style="width: 100%; height: 75px; cellspacing: 20px;">
						<td style="border: 1px solid black; height: 70px; width: 300px; text-align: left; padding-left: 10px;">
							<details> 
								<summary>Roles</summary>
								<p>1. Roles</p>
							</details>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="roles">
								<button type="button" style="height: 50px; width: 120px;">Roles</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="roles/list">
								<button type="button" style="height: 50px; width: 120px;">Roles List</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
					</tr>
					
					<tr style="width: 100%; height: 75px; cellspacing: 20px;">
						<td style="border: 1px solid black; height: 70px; width: 300px; text-align: left; padding-left: 10px;">
							<details>
							<summary>Users </summary>
							<p>1. Users</p>
							<p>2. Users & Roles</p>
							</details>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="users">
								<button type="button" style="height: 50px; width: 120px;">Users</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="users/list">
								<button type="button" style="height: 50px; width: 120px;">Users List</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="usersRoles">
								<button type="button" style="height: 50px; width: 120px;">Users & Roles</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="usersRoles/list">
								<button type="button" style="height: 50px; width: 120px;">UsersRolesList</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="usersaud">
								<button type="button" style="height: 50px; width: 120px;">Users Aud</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
					</tr>
					
					<tr style="width: 100%; height: 75px; cellspacing: 20px;">
						<td style="border: 1px solid black; height: 70px; width: 300px; text-align: left; padding-left: 10px;">
							<details>
							<summary>Person </summary>
							<p>1. Person</p>
							</details>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="person">
								<button type="button" style="height: 50px; width: 120px;">Person</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="person/list">
								<button type="button" style="height: 50px; width: 120px;">Person List</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
					</tr>
				
					<tr style="width: 100%; height: 75px; cellspacing: 20px;">
						<td style="border: 1px solid black; height: 70px; width: 300px; text-align: left; padding-left: 10px;">
							<details> 
								<summary>Logins</summary>
								<p>1. Logins</p>
							</details>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="logins">
								<button type="button" style="height: 50px; width: 120px;">Logins</button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
						<td style="border: 1px solid black; height: 70px; width: 200px; text-align: center;">
							<a href="">
								<button type="button" style="height: 50px; width: 120px;"></button>
							</a>
						</td>
					</tr>
				
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
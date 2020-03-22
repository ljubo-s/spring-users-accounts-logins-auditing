<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<td align="center">
					<h1>Login</h1>
				</td>
			</tr>
			<tr>
				<td align="center">
					<c:if test="${param.error ne null}">
						<div>Invalid username and password.</div>
					</c:if>
					<c:if test="${param.logout ne null}">
						<div>You have been logged out.</div>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<p>
					<form action="/auditing/login" method="post">
						<table style="font-size: 120%; cellpadding: 10px; cellspacing: 10px; border-spacing: 20px;">
							<tr>
								<td>Username :</td>
								<td>
									<input type="text" name="username" />
								</td>
							</tr>
							<tr>
								<td>
									<div>
										<label> Password: </label>
									</div>
								</td>
								<td>
									<input type="password" name="password" />
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<div>
										<input type="submit" value="Sign In" style="width: 120px; height: 40px;" />
									</div>
								<td>
							</tr>
						</table>
					</form>

				</td>
			</tr>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Hello</title>
</head>
<body>
	<table style="width: 100%; align: center;">
		<tr>
			<td align="center">
				<table style="width: 100%; align: center; cellpadding: 0;">
					<tr>
					<td align="right">
							
						</td>
						<td align="center" style="font-size: 1.3em; font-weight: bold;">
							Ulogovani ste kao: &nbsp;&nbsp; <c:out value="${pageContext.request.remoteUser}" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center" style="font-size: 1.5em; font-weight: bold;">
				<br>
			</td>
		</tr>
	</table>
</body>
</html>
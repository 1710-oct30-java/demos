<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>

	<table>
			<thead>
				<tr>
					<td>id:</td>
					<td>username:</td>
					<td>password:</td>
					<td>first name:</td>
					<td>last name:</td>
					<td>email:</td>
					<td>role id:</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td><c:out value="${user.userId}" /></td>
						<td><c:out value="${user.username}" /></td>
						<td><c:out value="${user.password}" /></td>
						<td><c:out value="${user.firstName}" /></td>
						<td><c:out value="${user.lastName}" /></td>
						<td><c:out value="${user.email}" /></td>
						<td><c:out value="${user.roleId}" /></td>

						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		</body>
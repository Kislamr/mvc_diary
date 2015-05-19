<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.kislamr.webapps.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="include/header.jsp"%>

<title>Users panel</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container-fluid">
			<div class="panel panel-default">
				<div class="panel-heading">Users</div>
				<div class="panel-body"></div>
				<form action="users" method="get">
					<table class="table table-striped">
						<tbody>
							<tr>
								<th>userid</th>
								<th>username</th>
								<th colspan="2">password</th>
							</tr>
							<c:forEach items="${listOfUser}" var="user">
								<tr>
									<td><c:out value="${user.userId}"></c:out></td>
									<td><c:out value="${user.userName}"></c:out></td>
									<td><c:out value="*******"></c:out></td>
									<td>
										<button type="submit" name="remove"
											value="<c:out value="${user.userId}"></c:out>">X</button>
									</td>
								</tr>
							</c:forEach>
							</form>

							<form action="users" method="post">
								<tr>
									<td><input type="text" value="" name="userId"
										placeholder="<c:out value='${error}'></c:out>"Firstname"></td>
									<td><input type="text" value="" name="userName"></td>
									<td><input type="text" value="" name="userPassword"></td>
									<td><input type="submit" name="add" value="+"></td>
								</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
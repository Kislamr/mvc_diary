<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.kislamr.webapps.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="include/header.jsp" %>
<title>Index Page!</title>
</head>
<body>
<div class="jumbotron">
  <div class="container-fluid">
<%-- Using JSTL forEach --%>

<div class="panel panel-default">
  <div class="panel-heading">Entries</div>
  <div class="panel-body">
  </div>
	<table class="table table-striped">
	<thead>
		<tr>
		  <th>id</th>
		  <th>title</th>
		  <th>text</th>
		  <th>date</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${listOfEntry}" var="entry">
	<tr>
		<td><c:out value="${entry.id}"></c:out></td>
		<td><c:out value="${entry.title}"></c:out></td>
		<td><c:out value="${entry.text}"></c:out></td>
		<td><c:out value="${entry.date}"></c:out></td>
	</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</body>
</html>
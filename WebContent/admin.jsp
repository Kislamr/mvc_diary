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

<title>Admin panel</title>
</head>
		<div class="btn-group btn-group-justified" role="group" aria-label="selection">
		  <div class="btn-group" role="group">
	   <a href="entries">
	    <button type="button" class="btn btn-default">entries</button>
	   </a>
	  </div>
	  <div class="btn-group" role="group">
	  <a href="users">
	    <button type="button" class="btn btn-default">users</button>
	  </a>
	  </div>
	</div>
</body>
</html>
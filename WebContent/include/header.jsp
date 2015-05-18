
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Personal Diary</title>
<c:if test="${savedUsername != null}">
	<c:out value="${savedUsername}"></c:out>
	<a href="LoginController?logout=true">logout</a>
</c:if>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<form class="navbar-header">
				<h4 class="navbar-text navbar-left" link="#">My Personal Diary</h4>

				<c:if test="${user.userName == null}">
					<a href="login.jsp" class="alert alert-info" role="button" >login</a>
				</c:if>
				<c:if test="${user.userName != null}">

					<a href="index?logout=true" method="post" class="alert alert-info"
						role="button">logout: <c:out value="${user.userName}"></c:out></a>
					<div class="btn-group btn-group-justified" role="group"
						aria-label="selection">
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
				</c:if>
			</form>


		</div>
	</div>
	</nav>
</body>
</html>


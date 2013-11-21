<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todo Web</title>
</head>
<body>

	<div class="container">

		<div class="page-header">
			<span class="pull-right"> ${sessionScope.useremail} <a
				href="login.jsp">Logout</a></span>
			<h1>Todo List Web</h1>
			<p class="lead">Here is your dashboard</p>
		</div>

		<h3>List of todo for <strong>${sessionScope.username}</strong></h3>
		<p>
			You have a total 123 tasks <strong>there are 5 high priority
				tasks overdue</strong>. Have a good day.
		</p>
		<div class="row">

			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Task Name</th>
						<th>Priority</th>
						<th>Status</th>
						<th>Due Date</th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Update servers</td>
						<td>Normal</td>
						<td>Not Started</td>
						<td>2013-11-15</td>
						<td><a class="btn btn-link"
							href="${pageContext.request.contextPath}/tasks?id=1">Edit</a></td>
					</tr>
					<tr class="danger">
						<td>2</td>
						<td>Backup Database</td>
						<td>High</td>
						<td>Started</td>
						<td>2013-11-12</td>
						<td><a class="btn btn-link"
							href="${pageContext.request.contextPath}/tasks?id=2">Edit</a></td>
					</tr>
					<tr>
						<td>4</td>
						<td>Clone repository</td>
						<td>Normal</td>
						<td>Not Started</td>
						<td>2013-11-15</td>
						<td><a class="btn btn-link"
							href="${pageContext.request.contextPath}/tasks?id=3">Edit</a></td>
					</tr>
					<tr class="success">
						<td>3</td>
						<td>Send Email</td>
						<td>High</td>
						<td>Finished</td>
						<td>2013-11-11</td>
						<td><a class="btn btn-link"
							href="${pageContext.request.contextPath}/tasks?id=4">Edit</a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<hr>
		<form action="${pageContext.request.contextPath}/tasks" method="get">
			<button type="submit" class="btn btn-primary">Add Task</button>
		</form>
	</div>

</body>
</html>



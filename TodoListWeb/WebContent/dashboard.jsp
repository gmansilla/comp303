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
<title>TodoList Web</title>
</head>
<body>

	<div class="container">

		<div class="page-header">
			<span class="pull-right">${sessionScope.useremail} <a
				href="${pageContext.request.contextPath}/login" name="logout">Logout</a></span>
			<h1>Todo List Web</h1>
			<p class="lead">Welcome, ${sessionScope.username}. Here is your dashboard</p>
		</div>
		<p>
			You have a total 123 tasks <strong>there are 5 high priority
				tasks overdue</strong>. Have a good day.
		</p>
		<br >
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>#</th>
						<th>Task Name</th>
						<th>Description</th>
						<th>Priority</th>
						<th>Due Date</th>
						<th>Task Status</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.taskList}" var="task">
						<tr>
							<td>${task.id}</td>
							<td>${task.name}</td>
							<td>${task.description}</td>
							<c:if test="${task.priority == 'l'}">
								<td>Low</td>
							</c:if>
							<c:if test="${task.priority == 'm'}">
								<td>Medium</td>
							</c:if>
							<c:if test="${task.priority == 'h'}">
								<td>High</td>
							</c:if>
							<td>${task.dueDate}</td>
							<c:if test="${task.status == 'p'}">
								<td>Not Started</td>
							</c:if>
							<c:if test="${task.status == 'f'}">
								<td>Finished</td>
							</c:if>
							<c:if test="${task.status == 's'}">
								<td>Started</td>
							</c:if>
							<td>
								<a class="btn btn-link"
								href="${pageContext.request.contextPath}/tasks?id=${task.id}">Edit</a>
								<a class="btn btn-link" name="taskFinish"
								href="${pageContext.request.contextPath}/tasks?id=${task.id}&status=f">Finish</a>
							</td>
						</tr>
					</c:forEach>
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



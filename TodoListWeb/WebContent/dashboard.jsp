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

			<p class="lead">Welcome, ${sessionScope.username}. Here is your
				dashboard</p>

		</div>
		<div class="pull-right">
			<form action="${pageContext.request.contextPath}/tasks" method="get">
				<button type="submit" class="btn btn-primary">Add New Task</button>
			</form>
		</div>
		<p>
			Total Created: <strong>${requestScope.totalTasks} tasks</strong>,
			Finished: <strong>${requestScope.finishedTasks} tasks</strong>,
			Pending: <strong>${requestScope.pendingTaskCount} tasks</strong>

		</p>
		<h3>All Tasks</h3>
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
							<td>
								<c:choose>
									<c:when test="${task.priority == 'l'}">Low</c:when>
									<c:when test="${task.priority == 'm'}">Medium</c:when>
									<c:when test="${task.priority == 'h'}">High</c:when>
								</c:choose>
							</td>
							<td>${task.dueDate}</td>
							<td>
								<c:choose>
									<c:when test="${task.status == 'p'}">Not Started</c:when>
									<c:when test="${task.status == 's'}">Started</c:when>
									<c:when test="${task.status == 'f'}">Finished</c:when>
								</c:choose>
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/tasks?id=${task.id}">Edit</a>
								<c:choose>
									<c:when test="${task.status == 'p'}">
										<a name="taskFinish"
										href="${pageContext.request.contextPath}/tasks?id=${task.id}&status=s"> Start</a>
									</c:when>
									<c:when test="${task.status == 's'}">
										<a name="taskFinish"
										href="${pageContext.request.contextPath}/tasks?id=${task.id}&status=f"> Finish</a>
									</c:when>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<hr>
		
		<h3>Tasks already finished</h3>
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
					<tr>
						<td>102</td>
						<td>sample Task Name</td>
						<td>sample Description</td>
						<td>sample Priority</td>
						<td>sample Due Date</td>
						<td>sample Task Status</td>
						<td>No Action</td>
					</tr>
			</table>
		</div>

	</div>

</body>
</html>



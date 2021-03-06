<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="assets/css/bootstrap.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TodoList Web</title>
</head>
<body>

	<div class="container">

		<div class="page-header">
			<span class="pull-right">${sessionScope.useremail} <a
				href="${pageContext.request.contextPath}/login?logout=true"
				name="logout">Logout</a></span>
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
			Total Tasks: <strong>${requestScope.totalTasksCount} tasks</strong>,
			Finished: <strong>${requestScope.finishedTasksCount} tasks</strong>,
			Pending: <strong>${requestScope.pendingTasksCount} tasks</strong>

		</p>
		<h3>Pending Tasks</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Description</th>
					<th>Priority</th>
					<th>Due Date</th>
					<th>Task Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.tasksPending}" var="task">
					<tr class="<c:if test="${task.priority == 'h'}">danger</c:if>">
						<td>${task.name}</td>
						<td>${task.description}</td>
						<td><c:choose>
								<c:when test="${task.priority == 'l'}">Low</c:when>
								<c:when test="${task.priority == 'm'}">Medium</c:when>
								<c:when test="${task.priority == 'h'}">High</c:when>
							</c:choose></td>
						<td>${task.dueDate}</td>
						<td><c:choose>
								<c:when test="${task.status == 'p'}">Not Started</c:when>
								<c:when test="${task.status == 's'}">Started</c:when>
								<c:when test="${task.status == 'f'}">Finished</c:when>
							</c:choose></td>
						<td>
							<i class="glyphicon glyphicon-edit"></i> 
							<a href="${pageContext.request.contextPath}/tasks?id=${task.id}">Edit</a>
							<i class="glyphicon glyphicon-trash"></i>
							<a href="${pageContext.request.contextPath}/tasks?id=${task.id}&status=d">Delete</a>
							<c:choose>
								<c:when test="${task.status == 'p'}">
								<i class="glyphicon glyphicon-play"></i> 
									<a name="taskFinish"
										href="${pageContext.request.contextPath}/tasks?id=${task.id}&status=s">
										Start</a>
								</c:when>
								<c:when test="${task.status == 's'}">
								<i class="glyphicon glyphicon-ok"></i> 
									<a name="taskFinish"
										href="${pageContext.request.contextPath}/tasks?id=${task.id}&status=f">
										Finish</a>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<h3>Tasks already finished</h3>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Task Name</th>
					<th>Description</th>
					<th>Priority</th>
					<th>Due Date</th>
					<th>Task Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.tasksFinished}" var="task">
					<tr class="<c:if test="${task.priority == 'h'}">danger</c:if>">
						<td>${task.name}</td>
						<td>${task.description}</td>
						<td><c:choose>
								<c:when test="${task.priority == 'l'}">Low</c:when>
								<c:when test="${task.priority == 'm'}">Medium</c:when>
								<c:when test="${task.priority == 'h'}">High</c:when>
							</c:choose></td>
						<td>${task.dueDate}</td>
						<td><c:choose>
								<c:when test="${task.status == 'p'}">Not Started</c:when>
								<c:when test="${task.status == 's'}">Started</c:when>
								<c:when test="${task.status == 'f'}">Finished</c:when>
							</c:choose></td>
					</tr>
				</c:forEach>
		</table>
	</div>


</body>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		</div>

		<h3>Add/Edit Tasks</h3>
		<p>
			You can <strong>add new tasks</strong> or <strong>edit
				existing tasks</strong> here.
		</p>
		<div class="row">


			<form class="form-horizontal" role="form" method="post"
				action="${pageContext.request.contextPath}/tasks">
				<div class="form-group">
					<label for="taskName" class="col-sm-2 control-label">Task
						Name</label>
					<div class="col-sm-3">
						<input type="text" class="form-control" name="taskName"
							placeholder="Task Name">
					</div>
				</div>

				<div class="form-group">
					<label for="taskDesc" class="col-sm-2 control-label">Task
						Name</label>
					<div class="col-sm-3">
						<textarea class="form-control" name="taskDesc"
							placeholder="Task Description"></textarea>
					</div>
				</div>

				<div class="form-group">
					<label for="taskPriority" class="col-sm-2 control-label">Task
						Priority</label>
					<div class="col-sm-3">
						<select class="form-control" name="taskPriority">
							<option value="h">High</option>
							<option value="m">Medium</option>
							<option value="l">Low</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="taskStatus" class="col-sm-2 control-label">Task
						Status</label>
					<div class="col-sm-3">
						<select class="form-control" name="taskStatus">
							<option value="s">Started</option>
							<option value="p">Not Started</option>
							<option value="f">Finished</option>
						</select>
					</div>
				</div>


				<div class="form-group">
					<label for="inputDate" class="col-sm-2 control-label">Due
						Date</label>
					<div class="col-sm-3">
						<input type="date" class="form-control" name="inputDate"
							placeholder="Date">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-success" name="saveTask">Save</button>
						<button type="button" class="btn btn-danger"
							onclick="window.location.href='${pageContext.request.contextPath}/dashboard'">Cancel</button>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>
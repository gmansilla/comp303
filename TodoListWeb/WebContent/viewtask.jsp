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
			<h1>Todo List Web</h1>
			<p class="lead">Here are the details of your task</p>
		</div>
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered" style="border: none">
					<tr>
						<td>Task</td>
						<th>Backup Database</th>
					</tr>
					<tr>
						<td>Priority</td>
						<th><span class="label label-danger">High Priority</span></th>
					</tr>
					<tr>
						<td>Status</td>
						<th>Started</th>
					</tr>
					<tr>
						<td>Due Date</td>
						<th>2013-11-12</th>
					</tr>
				</table>
				<div class="form-group">
						<button type="submit" class="btn btn-success">Mark as
							Done</button>
						<button type="submit" class="btn btn-info">Edit Task</button>
						<button type="submit" class="btn btn-danger">Remove Task</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
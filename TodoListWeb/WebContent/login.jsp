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
			<h1>Todo List Web</h1>
			<p class="lead">Please login to your account</p>
		</div>
		<div class="row col-md-4">
			<form role="form" method="post" action=${pageContext.request.contextPath}/login>
				<div class="form-group">
					<label for="useremail">Email address</label> <input
						type="email" class="form-control" id="useremail" name="useremail"
						placeholder="Enter email">
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input
						type="password" class="form-control" id="password" name="password"
						placeholder="Password">
				</div>
				<button type="submit" class="btn btn-primary">Sign In</button>
			</form>
		</div>
	</div>
</body>
</html>

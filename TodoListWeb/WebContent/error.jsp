<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">
	<link href="assets/css/docs.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
	<div class="container">
		
		<div class="page-header">
			<h1>Todo List Web</h1>
		</div>
		<div class="bs-docs-section">
			<div class="bs-callout bs-callout-danger">
      			<h4>${requestScope.message}</h4>
      			<p>Click <a href="${pageContext.request.contextPath}/dashboard">here</a> to return to the dashboard.</p>
    		</div>
    	</div>
	</div>
</body>
</html>
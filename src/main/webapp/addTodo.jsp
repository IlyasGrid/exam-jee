<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Header-Footer.css">
</head>
<body>

	<header>
		<h1>Todo</h1>
		<nav>
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="AddTodoServleet">AddTodo</a></li>
				<li><a href="ListTodoServlet">listTodo</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<form method="post">
			<input name="Todotitle" placeholder="title"> 
			<button type="submit">submit</button>
		</form>
		<p> ${ msg!=null ? msg : "" }</p>
	</main>
	<footer>
		<p>2023 Gl</p>
	</footer>

</body>
</html>
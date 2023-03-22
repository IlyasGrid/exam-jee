<%@page import="java.util.List"%>
<%@page import="com.estf.exam.beans.Todo"%>
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

		<%
		List<Todo> myList = (List<Todo>) request.getAttribute("mylist");

		for (Todo todo : myList) {
		%>
		<div class="todocontainer">
			<div>
				<h2><%=todo.getTitle()%></h2>
			</div>
			<form method="post">
				<input type="hidden" name="idToDelete" value=<%=todo.getId()%>>
				<button type="submit">Delete</button>
			</form>

			<%
			if (myList.size() == 1) {
			%>
			<%
			} else if (myList.indexOf(todo) == 0) {
			%>
			<form method="post">
				<input type="hidden" name="idPriority" value=<%=todo.getId()%>>
				<input type="hidden" name="UpOrDown" value=<%="Down"%>>
				<button type="submit">Down</button>
			</form>
			<%
			} else if (myList.indexOf(todo) == (myList.size() - 1)) {
			%>
			<form method="post">
				<input type="hidden" name="idPriority" value=<%=todo.getId()%>>
				<input type="hidden" name="UpOrDown" value=<%="Up"%>>
				<button type="submit">Up</button>
			</form>
			<%
			} else {
			%>
			<form method="post">
				<input type="hidden" name="idPriority" value=<%=todo.getId()%>>
				<input type="hidden" name="UpOrDown" value=<%="Up"%>>
				<button type="submit">Up</button>
			</form>
			<form method="post">
				<input type="hidden" name="idPriority" value=<%=todo.getId()%>>
				<input type="hidden" name="UpOrDown" value=<%="Down"%>>
				<button type="submit">Down</button>
			</form>
			<%
			}
			%>


		</div>

		<%
		}
		%>
	</main>
	<footer>
		<p>2023 Gl</p>
	</footer>
</body>
</html>
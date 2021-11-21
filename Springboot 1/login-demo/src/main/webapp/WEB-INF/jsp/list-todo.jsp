<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>To do List Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>

	Here is the to do list for ${name}.
<br>
	<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todoList}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>	
	<!-- add a link to add more todos  -->
	<div><a class="button" href="/add-todo">Add a Todo entry</a></div>
	
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>
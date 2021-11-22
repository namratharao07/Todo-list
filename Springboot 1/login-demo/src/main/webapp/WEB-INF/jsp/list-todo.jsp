<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<head>
<title>To do List Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
	    		
</head>
<body>
<h1>Here is the to do list for ${name}.</h1>
	
<br>
	<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Done?</th>
				<th>Update Button</th>
				<th>Delete Button</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todoList}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td><fmt:formatDate value="${todo.targetDate}" pattern="MM/dd/yyyy"/></td>
				<td>${todo.done}</td>
				<td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a></td>
				<td><a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
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
<%@ include file = "common/header.jspf" %>
<%@ include file= "common/navigation.jspf" %>
	
<div class="container">

	<h1>Your todos</h1>
	
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target date</th>
				<th>Complete</th>
			</tr>
		</thead>
		<tbody>
			<tag:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetdate}</td>
					<td>${todo.isdone}</td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-info">UPDATE</a></td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-warning">DELETE</a></td>
				</tr>
			</tag:forEach>

		</tbody>
	</table>
	<a href="add-todos" class="btn btn-success"> Add Todo</a>
</div>
<%@ include file = "common/footer.jspf" %>
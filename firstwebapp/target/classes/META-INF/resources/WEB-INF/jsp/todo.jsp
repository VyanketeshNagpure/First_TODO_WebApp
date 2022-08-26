<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>

<div class="container">

	<h1>Enter To-do details</h1>
	
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input type="text" path="description" required="required" />
			<form:errors path="description" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<!-- mb if for margin of size 3 -->
			<form:label path="targetdate">Target Dates</form:label>
			<form:input type="text" path="targetdate" required="required" />
			<form:errors path="targetdate" cssClass="text-warning" />
		</fieldset>

		<fieldset class="mb-3">
			<!-- mb if for margin of size 3 -->
			<form:label path="isdone">Task Status</form:label>
			<form:input type="text" path="isdone" required="required" />
			<form:errors path="isdone" cssClass="text-warning" />
		</fieldset>

		<form:input type="hidden" path="id" />
		<input type="submit" class="btn btn-success" />
	</form:form>
</div>
<%@ include file = "common/footer.jspf" %>
<script type="text/javascript">
$('#targetdate').datepicker({
    format: 'yyyy-mm-dd'
});
</script>

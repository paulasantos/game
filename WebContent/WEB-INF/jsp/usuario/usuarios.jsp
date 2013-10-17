<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='../index/index.jsp' />

<form>

	<table class="table table-striped">
		<tr>
			<th>Nome</th>
			<th>login</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.nome}</td>
				<td>${usuario.login}</td>
			</tr>
		</c:forEach>
	</table>


</form>
</body>
</html>

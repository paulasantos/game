<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page='../index/index.jsp' />

<form>

	<table class="table table-striped">
		<tr>
			<th>Nome</th>
			<th>Edição</th>
			<th>Ano</th>
			<c:if test="${usuarioWeb.logado}">
				<th>Edite</th>
			</c:if>
			
		</tr>
		<c:forEach items="${livros}" var="livro">
		<tr id="produto-${produto.id}">
			
			
				<td>${livro.nome} </td>
				<td>${livro.edicao}</td>
				<td>${livro.ano}</td>
				<c:if test="${usuarioWeb.logado}">
					<td><a class="link"
						href='<c:url value="comentario/list/${livro.id}"/>'> <i
							class="icon-edit"></i>
					</a>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>

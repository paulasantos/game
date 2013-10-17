<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../index/index.jsp" />



	<form id="livroForm" action="<c:url value="/livro"/>" method="POST" autocomplete="off">
		<div class='separator-form'>
				<div class="separator-title">Dados do Livro</div>
			
			<div class="control-group">
				<div class="controls">
					<input id="nome" class="required input" type="text" name="livro.nome"
						placeholder="Nome" value="${livro.nome }" />
				</div>
			</div>
			
			<div class="control-group">
				<div class="controls">
					<input id="nome" class="required input" type="text" name="livro.edicao"
						placeholder="edicao" value="${livro.edicao }" />
				</div>
			</div>
			
			<div class="control-group">
				<div class="controls">
					<input id="nome" class="required input" type="text" name="livro.ano"
						placeholder="Ano" value="${livro.ano}" />
				</div>
			</div>
			
			<div class="control-group">
				<div class="controls">
					<button id="enviar" type="submit" class="btn">Enviar</button>
				</div>
			</div>
		</div>
	</form>

<script>
</script>

</body>
</html>

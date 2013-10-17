<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../index/index.jsp" />



	<form id="usuariosForm" action="<c:url value="/usuario"/>" method="POST" autocomplete="off">
		<div class='separator-form'>
				<div class="separator-title">Dados do usuário</div>
			
			<div class="control-group">
				<div class="controls">
					<input id="nome" class="required input" type="text" name="usuario.nome"
						placeholder="Nome" value="${usuario.nome }" />
				</div>
			</div>

			<div class="control-group">
				<div class="controls">
					<input placeholder="login" id="login" class="required" type="text"
						name="usuario.login" value="${usuario.login }" onblur="verificaUsuario();" />
<!-- 						<span class="sucesso" style='display ="none"'> Login Disponível </span> -->
<!-- 						<span class="erroLogin" style='display ="none"'> Login Indisponível </span> -->
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<input id="senha" class="required input" type="password"
						placeholder="senha" name="usuario.senha" />
				</div>
			</div>
			
			<div class="control-group">
				<div class="controls">
					<input id="confirmacao" placeholder="Confirme sua senha"
						equalTo="#senha" type="password" class="input"/>
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
	$(function() {
		$("#login").val("");
	});
	
	function verificaUsuario() {
		var login = $("#login").val();
		var url = "/game/usuario/login/" + login;
		$.ajax({
			url: url,
			type : "GET",
			success: function(retorno) {
				if(retorno){
					$(".sucesso").hide();
					$(".erroLogin").show();
				}else{
					$(".sucesso").show();
					$(".erroLogin").hide();
				}
			},
		});
	};
	
	
	$('#usuariosForm').validate();


</script>


</body>
</html>

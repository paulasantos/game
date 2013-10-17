<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class='login-container'>
		<div class="box box-login">
			<div class="box-login-empresa">
				<img src="<c:url value="game/images/logo.jpg"/>" width="58" height="67" />
<!-- 				<div class='login-empresa-nome'>Acesse o game Livros Sociais</div> -->
			</div>
			<div class="box-login-title">Acesse o game Livros Sociais</div>
			<div class="box-login-cont">
				
				<form id="formLogin" class="" action="<c:url value="usuario/login"/>" method="post" autocomplete="off">
					
					<label>E-mail:</label>
					<input type="text" id="usuarioLogin" placeholder="E-mail" class="" name="usuario.nome">
					
					<label>Senha:</label>
					<input type="password" id="usuarioPassword" class="" placeholder="Senha" name="usuario.senha" >

					<a class="redefinir-senha link" href="<c:url value='usuario/redefinirsenha'/>">Esqueci minha senha</a>
				</form>
			</div>
			
		</div>
	
	
</body>
</html>
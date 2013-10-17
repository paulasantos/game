<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="/game/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/game/css/bootstrap.css">
<link rel="stylesheet"
	href="<c:url  value="/css/bootstrap-responsive.css" />" />
<fmt:setLocale value="pt_br" />
<script src="/game/js/script.js" type="text/javascript"></script>
<jsp:include page="../index/head.jsp" />
</head>

<body>
	<div id="menu-principal">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="<c:url value="/"/>">Livros	Sociais</a>
					<div class="nav-collapse collapse">
						<ul class="nav">
							<li><a href="<c:url value="/"/>">
								<i class="icon-home icon-white" style="padding-right: 5px;"></i>Início</a>
							</li>
							<li><a href="<c:url value="/livro/new"/>">Cadastrar</a></li>
							<li><a href="<c:url value="/livro"/>">Meus Livros</a></li>
							<li><a href="<c:url value="/geral/ranking"/>">Conversa</a></li>
						</ul>
						<c:if test="${usuarioWeb.logado}">
							<form class="navbar-form pull-right"
								action="<c:url value="/usuario/logout" />" method="post">
								<span style="color: white;">Olá, ${usuarioWeb.nome }!</span>
								<button class="btn btn-small" type="submit" class="btn">Logout</button>
							</form>
						</c:if>
						<c:if test="${empty usuarioWeb or not usuarioWeb.logado}">
							<form class="navbar-form pull-right"
								action="<c:url value="/usuario/login" />" method="post">
								<input class="span2" type="text" placeholder="Login"
									name="usuario.login" /> <input class="span2" type="password"
									placeholder="Senha" name="usuario.senha" />
								<button class="btn btn-small" type="submit" class="btn">Entrar</button>
								<a href="<c:url value="/usuario/new" />" class="btn btn-small">Cadastre-se</a>
							</form>
						</c:if>
					</div>
					<!--/.nav-collapse -->
				</div>
			</div>
		</div>
	</div>
	<script src="<c:url  value="/js/jquery-1.10.2.min.js" />"></script>
	<script src="<c:url  value="/js/bootstrap.js" />"></script>
	<div class="container">
		<div class="hero-unit">
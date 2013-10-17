<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../index/index.jsp" />

<div class="content-body">
<div id="content">
<div class="box box-feed">
	<div class="col-3 col">
						<div class="box-title">
							<div>Quero compartilhar com a empresa</div>
						</div>
						<div class="box-cont">
							<form id="formNewMensagem" class="frm-compartilhar" method="post" action="<c:url value='/livro/new'/>">
								<div class="feeds-textarea-panel">
									<textarea class="required" name="comentario.conteudo" maxlength="140"></textarea>
									<div class="autoComplete-search-results"><ul></ul></div>
									<div class="btn-enviar">
										<div class="contadorDeCaracteres">
											<div class="conta-letras length">
												140
											</div>
										</div>
										<div class="ir button" onclick="intranet.views.mensagens.gravar(${usuarioLogado});"><i class='icon-plus'></i></div>
									</div>
								</div>
							</form>
							<ul class="lista-compartilhados"></ul>
						</div>
					</div>

</div>
</div>
</div>

</body>
</html>

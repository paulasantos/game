(function(app){
	app.views.mensagens = {
		curtir : function( mensagemId, usuarioLogado ) {
			var url = contextPath + "/mensagens/"+ mensagemId +"/curtir";
			$.post(url)
				.success(function(success) {
					app.views.mensagens.listar(null, usuarioLogado);
				})
				.error(function() {});
		},
		loadUsersCurtir : function( mensagemId ) {
			var url = contextPath + "/mensagens/"+ mensagemId +"/loadUsersCurtir";
			listUserCurtir = "";
			$.ajax({	
				url : url,
				type : "GET",
				cache : false,
				success: function(retorno) {
					var usuarios = retorno.usuarios;
					$(usuarios).each(function(i, usuario) {
						listUserCurtir += "<li onclick='intranet.views.usuario.show("+usuario.id+")'>"+usuario.nome+"</li>";
					});
					listUserCurtir = listUserCurtir.substring(0, listUserCurtir.length-1);
					
					var curtidas = $("#"+mensagemId).find(".icon-thumbs-up").html();
					if (curtidas != " ") {
						curtidas = curtidas.substring(0, 2)
						$("#"+mensagemId).find(".icon-thumbs-up").html(curtidas + '<div style="display: none;background: white;min-width: 150px;position: absolute;right: -2px;z-index: 99;top: 15px;border-radius: 4px;border: 2px solid rgb(196, 191, 191);">'+listUserCurtir+'</div>');
					}
					
					/*$("#"+mensagemId).find(".icon-thumbs-up").tooltip({
						position: {
					        my: "bottom"
						}
					});*/
				}
			});
		},
		gravar : function(usuarioLogado) {
			var $formNewMensagem = $("#formNewMensagem"),
				contadorDeCaracteres = $("#formNewMensagem").find(".conta-letras");
				url = contextPath + "/mensagens";
			if( $formNewMensagem.valid() )
				$.post(url, $formNewMensagem.serialize())
					.success(function(success) {
						app.views.mensagens.listar(filtroIdMensagens, usuarioLogado);
						$formNewMensagem[0].reset();
						contadorDeCaracteres.html("140");
						$formNewMensagem.find("textarea").focus();
					})
					.error(function() {});
		},
		listar : function( filtroId, usuarioLogado ) {
			var url = contextPath + "/mensagens/feedmensagens";
			if( filtroId ) url += "/filtroid/"+ filtroId;
			
			$.ajax({
				url : url,
				type : "GET",
				cache : false,
				success : function( retorno ) {
					if( !filtroId ) $(".lista-compartilhados").html("");
					var mensagens = retorno.mensagens;
					filtroIdMensagens = mensagens[0] ? mensagens[0].id : filtroIdMensagens;
					$(mensagens).each(function(i, mensagem) {
						if ( typeof versaoMobile == 'undefined') {
							var versaoMobile = false;
						}
						
						var msgCont = mensagem.conteudo;
						if (/Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent))
							var mensagemConteudo = linkify(msgCont.replace(/\/grupofortes\/conteudos/g, "/grupofortes/mobile/conteudos"));
						else var mensagemConteudo = linkify(mensagem.conteudo);
						var curtidas = mensagem.curtidas;
						var mensagemCurtidas;
						
						var botaoValue = "Curtir";
						var totalCurtidas = "";
						if ( curtidas != null && curtidas.length > 0 ) {
							var totalCurtidas =  curtidas.length;
							if (curtidas.length > 1)
								mensagemCurtidas = curtidas.length + " colaboradores curtiram isso.";
							else if ( curtidas[0] == usuarioLogado )
								mensagemCurtidas = "Você curtiu isso.";
							else
								mensagemCurtidas = "1 colaborador curtiu isso.";
							
							$(curtidas).each(function(y, id){
								if( id == usuarioLogado )
									botaoValue = "Curtir (Desfazer)";
							});
						} else mensagemCurtidas = "Nenhum colaborador curtiu isso.";
						
						var imgRemetente = "<img class='link' onclick='intranet.views.usuario.show("+ mensagem.remetente.id +")'" +
								" src='"+ contextPath +"/usuarios/"+ mensagem.remetente.id +"/foto/thumb'>";
						if (mensagem.remetente.fotoFileName == null || mensagem.remetente.fotoFileName == "")
							imgRemetente = "<img src='/imagens/photo_unregistered.png' />";
						
						var tempoPassado = app.utils.tempoPassado(mensagem.cadastradoEm);
						
						var postCompartilhadoTpl = $("#post-compartilhado-tpl").html();
						var dados = {
							mensagem: mensagem,
							tempoPassado: tempoPassado,
							usuarioLogado: usuarioLogado,
							botaoValue: botaoValue,
							totalCurtidas: totalCurtidas,
							texto: (mensagem.titulo ? mensagem.titulo + ": " + mensagemConteudo : mensagemConteudo )
						};
						campoConteudo = Mustache.render(postCompartilhadoTpl, dados);

						
						if( filtroId ) {
								if( versaoMobile ) {
									$(".lista-compartilhados").prepend(campoConteudo);
								} else {
									$(".lista-compartilhados .mCSB_container").prepend(campoConteudo);
								}
						}
						else $(".lista-compartilhados").append(campoConteudo);
					});
					
					
					if( !filtroId ) {
						$(".lista-compartilhados").mCustomScrollbar({
							mouseWheel: false,
							theme: "dark",
							scrollButtons:{
							    enable: true
							},
							advanced:{
							    updateOnContentResize: Boolean
							}
						});
					}
					
					
					$(".lista-compartilhados .foto-container").imgLiquid();
					
					$(".icon-thumbs-up").mouseenter(function() {
						var id = $(this).parent().parent().parent().parent().attr("id");
						intranet.views.mensagens.loadUsersCurtir(id);
					});
				},
				error : function (){}
			});
		}
	};
})(intranet);
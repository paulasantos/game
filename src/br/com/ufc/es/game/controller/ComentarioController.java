package br.com.ufc.es.game.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.ufc.es.game.dao.ComentarioDao;
import br.com.ufc.es.game.dao.LivroDao;
import br.com.ufc.es.game.dao.UsuarioDao;
import br.com.ufc.es.game.model.Comentario;

@Resource
@Path("/comentario")
public class ComentarioController {
	
	private Result result;
	private Validator validator;
	private ComentarioDao comentarioDao;
	private LivroDao livroDao;
	private UsuarioDao usuarioDao;

	public ComentarioController(Result result, Validator validator, ComentarioDao comentarioDao, LivroDao livroDao,
			UsuarioDao usuarioDao) {
		this.result = result;
		this.validator = validator;
		this.comentarioDao = comentarioDao;
		this.livroDao = livroDao;
		this.usuarioDao = usuarioDao;
	}
	
	@Get("/list/{id}")
	public void  comentarios(Long id){
		System.out.println("comentário");
	}
	
	public void ListarComentarios(Long id_livro){
		List<Comentario> comentarios = comentarioDao.listComentario(id_livro);
		//result.include("comentarios", comentarios).redirectTo(this).comentarios();
	}
	
	
	
}

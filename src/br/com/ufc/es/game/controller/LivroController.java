package br.com.ufc.es.game.controller;

import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.ufc.es.game.dao.ComentarioDao;
import br.com.ufc.es.game.dao.LivroDao;
import br.com.ufc.es.game.dao.UsuarioDao;
import br.com.ufc.es.game.model.Comentario;
import br.com.ufc.es.game.model.Livro;
import br.com.ufc.es.game.model.Usuario;
import br.com.ufc.es.game.model.UsuarioWeb;

@Resource
@Path("/livro")
public class LivroController {

	private LivroDao livroDao;
	private Result result;
	private UsuarioWeb usuarioWeb;
	private UsuarioDao usuarioDao;
	private ComentarioDao comentarioDao;

	public LivroController(Result result, LivroDao livroDao,
			UsuarioWeb usuarioWeb, UsuarioDao usuarioDao, ComentarioDao comentarioDao) {
		this.result = result;
		this.livroDao = livroDao;
		this.usuarioWeb = usuarioWeb;
		this.usuarioDao = usuarioDao;
		this.comentarioDao = comentarioDao;
	}

	@Get("/new")
	public void formulario() {
	}
	
	@Get({"", "/"})
	public void livros(){
		result.include("livros",livroDao.list());
	}

	@Post("")
	public void save(Livro livro) {
		
		Usuario usuario = usuarioDao.load(usuarioWeb.getId());
		usuario.adicionarLivro(livro);
		//livro.adicionarUsuario(usuario);
		
		//livroDao.save(livro);
		usuarioDao.save(usuario);
		livro.adicionarUsuario(usuario);
		livroDao.update(livro);		
		result.redirectTo(LivroController.class).livros();
	}	
	
	@Get("/coment/{id}")
	public void ListarComentarios(Long id){
//		List<Comentario> comentarios = comentarioDao.listComentario(id);
//		result.include("comentarios", comentarios).redirectTo(ComentarioController.class).comentarios();
	}
}

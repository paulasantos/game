package br.com.ufc.es.game.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.ufc.es.game.dao.UsuarioDao;
import br.com.ufc.es.game.model.Usuario;
import br.com.ufc.es.game.model.UsuarioWeb;

@Resource
@Path("/usuario")
public class UsuarioController {

	private final UsuarioDao usuarioDao;
	private final Result result;
	private UsuarioWeb usuarioWeb;
	private Validator validator;

	public UsuarioController(UsuarioDao usuarioDao, Result result,
			UsuarioWeb usuarioWeb, Validator validator) {
		this.usuarioDao = usuarioDao;
		this.result = result;
		this.usuarioWeb = usuarioWeb;
		this.validator = validator;
	}

	@Get("/new")
	public void formulario() {
	}
	
	@Get({ "", "/" })
	public void usuarios() {
		result.include("usuarios", usuarioDao.list());
	}

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = usuarioDao.carrega(usuario);
		if (carregado != null) {
			usuarioWeb.login(carregado);
			result.redirectTo(UsuarioController.class).formulario();
		} else {
			result.include("login", "Usuário não cadastrado!");
			validator.add(new ValidationMessage("loginIncorreto","Login já existe"));
			validator.onErrorUsePageOf(UsuarioController.class).formulario();
			result.redirectTo(UsuarioController.class).formulario();
		}
	}

	@Get("/login/{login}")
	public void verificaLogin(String login) {
		result.use(json()).withoutRoot()
				.from(usuarioDao.verificaUsuario(login)).serialize();
	}	

	@Post("")
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		result.redirectTo(UsuarioController.class).formulario();
	}
	
	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(UsuarioController.class).formulario();
	}
}

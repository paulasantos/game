package br.com.ufc.es.game.dao;

import java.util.List;

import br.com.ufc.es.game.model.Usuario;

public interface UsuarioDao extends GenericDao{

	public boolean verificaUsuario(String login);
	public Usuario load(Long id);
	public Usuario carrega(Usuario usuario);
	public List<Usuario> list();

}

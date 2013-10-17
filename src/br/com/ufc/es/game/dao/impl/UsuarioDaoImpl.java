package br.com.ufc.es.game.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.ufc.es.game.dao.UsuarioDao;
import br.com.ufc.es.game.model.Usuario;

@Component 
@RequestScoped
public class UsuarioDaoImpl extends GenericDaoImpl implements UsuarioDao{

	@Override
	public boolean  verificaUsuario(String login) {
		Usuario encontrado = (Usuario) getSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("login", login))
				.uniqueResult();
		return encontrado != null;
	}

	@Override
	public Usuario load(Long id) {
		return (Usuario) getSession().load(Usuario.class, id);
	}

	@Override
	public Usuario carrega(Usuario usuario) {
		return (Usuario) getSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("login", usuario.getLogin()))
				.add(Restrictions.eq("senha", usuario.getSenha()))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> list() {
		return getSession().createCriteria(Usuario.class).list();
	}
}

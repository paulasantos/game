package br.com.ufc.es.game.dao.impl;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.ufc.es.game.dao.LivroDao;
import br.com.ufc.es.game.model.Comentario;
import br.com.ufc.es.game.model.Livro;

@Component
public class LivroDaoImpl extends GenericDaoImpl implements LivroDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Livro> list() {
		return getSession().createCriteria(Livro.class).list();
	}

	@Override
	public List<Comentario> listComentario(Long id) {
		
		return null;
	}
	
}

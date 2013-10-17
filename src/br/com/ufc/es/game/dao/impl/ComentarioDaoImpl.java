package br.com.ufc.es.game.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.com.ufc.es.game.dao.ComentarioDao;
import br.com.ufc.es.game.model.Comentario;

@Component
public class ComentarioDaoImpl extends GenericDaoImpl implements ComentarioDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Comentario> listComentario(Long id_livro) {
		return getSession().createCriteria(Comentario.class).add(Restrictions.eq("livro", id_livro)).list();
	}
}

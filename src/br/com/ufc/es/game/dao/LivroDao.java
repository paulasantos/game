package br.com.ufc.es.game.dao;

import java.util.List;

import br.com.ufc.es.game.model.Comentario;
import br.com.ufc.es.game.model.Livro;

public interface LivroDao extends GenericDao{

	public List<Livro> list();

	public List<Comentario> listComentario(Long id);

}

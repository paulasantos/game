package br.com.ufc.es.game.dao;

import java.util.List;

import br.com.ufc.es.game.model.Comentario;

public interface ComentarioDao extends GenericDao {

	public List<Comentario> listComentario(Long id_livro);
}

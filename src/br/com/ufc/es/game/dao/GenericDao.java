package br.com.ufc.es.game.dao;

public interface GenericDao {
	public boolean save(Object object);
	public boolean update(Object object);
	public boolean delete(Object object);
}

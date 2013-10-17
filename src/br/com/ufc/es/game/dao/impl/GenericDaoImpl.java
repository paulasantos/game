package br.com.ufc.es.game.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.ufc.es.game.dao.GenericDao;

public class GenericDaoImpl implements GenericDao {

	@Autowired
	private Session session;

	public Session getSession() {
		return session;
	}

	@Override
	public boolean save(Object object) {
		try {
			getSession().save(object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Object object) {
		try {
			getSession().update(object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Object object) {
		try {
			getSession().delete(object);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

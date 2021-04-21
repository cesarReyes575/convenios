package mx.com.convenios.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import mx.com.convenios.dao.GenericDAO;

public class GenericDAOImpl<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public T findById(ID id) {
		try {
			return getHibernateTemplate().get(getPersistente(), id);

		} catch (DataAccessException e) {
			logger.error(e);
			return null;
		}

	}

	@Override
	public List<T> findAll() {

		return findByCriteria();
	}

	@Override
	public List<T> findByExample(T entidad, String... propiedadesExcluidas) {

		try {
			DetachedCriteria crit = DetachedCriteria.forClass(getPersistente());
			Example example = Example.create(entidad);
			example.excludeZeroes();
			for (String excude : propiedadesExcluidas) {
				example.excludeProperty(excude);
			}
			crit.add(example);
			return (List<T>) getHibernateTemplate().findByCriteria(crit);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public boolean makePersistent(T entidad) {
		try {
			getHibernateTemplate().saveOrUpdate(entidad);
			return true;
		} catch (Exception e) {
			logger.error("error al guardar ", e);
			return false;
		}
	}

	@Override
	public boolean makeTransient(T entidad) {
		try {
			getHibernateTemplate().delete(entidad);
			return true;
		} catch (Exception e) {
			logger.error("error al eliminar " + e);
			return false;
		}
	}

	@Override
	public List<T> findByCriteria(Criterion... criterion) {

		DetachedCriteria crit = DetachedCriteria.forClass(getPersistente());
		for (Criterion c : criterion) {
			if (c != null) {
				crit.add(c);
			}
		}
		return (List<T>) getHibernateTemplate().findByCriteria(crit);
	}

	private Class<T> persistente;

	public Class<T> getPersistente() {
		return persistente;
	}

	public void setPersistente(Class<T> persistente) {
		this.persistente = persistente;
	}

	public GenericDAOImpl() {
		this.persistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

}

package mx.com.convenios.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

public interface GenericDAO<T , ID extends Serializable> {

	public T findById(ID id);
	public List<T> findAll();
	public List<T> findByExample(T entidad, String... propiedadesExcluidas);
	public boolean makePersistent(T entidad);
	public boolean makeTransient(T entidad);
	public List<T> findByCriteria(Criterion... criterion);


}
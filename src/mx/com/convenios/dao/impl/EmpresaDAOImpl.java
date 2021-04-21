package mx.com.convenios.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import mx.com.convenios.bean.CatEmpresa;
import mx.com.convenios.dao.EmpresaDAO;

public class EmpresaDAOImpl extends GenericDAOImpl<CatEmpresa, Integer> implements EmpresaDAO {

	Logger _log = Logger.getLogger(EmpresaDAOImpl.class);

	@Override
	public boolean saveEmpresa(CatEmpresa catEmpresa) {

		Session s = getSessionFactory().openSession();
		Transaction tx = s.getTransaction();
		try {
			_log.info("catEmpresa "+catEmpresa);
			s.getTransaction().begin();
			s.save(catEmpresa); 
			s.flush();
			tx.commit();
			return true;
		} catch (Exception e) {
			_log.error("Error ", e);
			tx.rollback();
			return false;
		}finally{
			s.close();
		}

	}


}

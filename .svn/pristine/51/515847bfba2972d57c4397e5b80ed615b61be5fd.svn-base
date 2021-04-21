package mx.com.convenios.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import mx.com.convenios.bean.CatSubEmpresa;
import mx.com.convenios.dao.SubEmpresaDAO;

public class SubEmpresaDAOImpl extends GenericDAOImpl<CatSubEmpresa, Integer> implements SubEmpresaDAO {

	Logger _log = Logger.getLogger(SubEmpresaDAOImpl.class);

	@Override
	public boolean saveSubEmpresa(CatSubEmpresa catSubEmpresa) {

		Session s = getSessionFactory().openSession();
		Transaction tx = s.getTransaction();
		try {
			s.getTransaction().begin();
			s.save(catSubEmpresa); 
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

package mx.com.convenios.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import mx.com.convenios.bean.HistoricoEmpresa;
import mx.com.convenios.dao.HistoricoEmpresaDAO;

public class HistoricoEmpresaDAOImpl extends GenericDAOImpl<HistoricoEmpresa, Integer> implements HistoricoEmpresaDAO {

	Logger _log = Logger.getLogger(HistoricoEmpresaDAOImpl.class);

	@Override
	public boolean saveHistoricoEmpresa(HistoricoEmpresa historicoEmpresa) {

		Session s = getSessionFactory().openSession();
		Transaction tx = s.getTransaction();
		try {
			_log.info("historicoEmpresa "+historicoEmpresa);
			s.getTransaction().begin();
			s.save(historicoEmpresa); 
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

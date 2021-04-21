package mx.com.convenios.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import mx.com.convenios.bean.HistoricoCampanaConvenio;
import mx.com.convenios.dao.HistoricoCampanaConvenioDAO;

public class HistoricoCampanaConvenioDAOImpl extends GenericDAOImpl<HistoricoCampanaConvenio, Integer> implements HistoricoCampanaConvenioDAO {

	Logger _log = Logger.getLogger(HistoricoCampanaConvenioDAOImpl.class);

	@Override
	public boolean saveHistoricoCampanaConvenio(HistoricoCampanaConvenio historicoCampanaConvenio) {

		Session s = getSessionFactory().openSession();
		Transaction tx = s.getTransaction();
		try {
			s.getTransaction().begin();
			s.save(historicoCampanaConvenio); 
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

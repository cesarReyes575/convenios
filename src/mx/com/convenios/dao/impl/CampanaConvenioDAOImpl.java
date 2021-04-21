package mx.com.convenios.dao.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import mx.com.convenios.bean.CampanaConvenio;
import mx.com.convenios.dao.CampanaConvenioDAO;
public class CampanaConvenioDAOImpl  extends GenericDAOImpl<CampanaConvenio, Integer> implements CampanaConvenioDAO {

	Logger _log = Logger.getLogger(CampanaConvenioDAOImpl.class);

	@Override
	public void saveCampana(CampanaConvenio campanaConvenios) {

		Session s = getSessionFactory().openSession();
		Transaction tx = s.getTransaction();
		try {
			s.getTransaction().begin();
			 s.save(campanaConvenios);
			s.flush();
			tx.commit();
		} catch (Exception e) {
			_log.error("Error ", e);
			tx.rollback();
		}finally{
			s.close();
		}

	}

	@Override
	public List<CampanaConvenio> getListCampanaConvenioOrder() {
		
		Session s = getSessionFactory().openSession();
		try {
			Criteria c = s.createCriteria(CampanaConvenio.class, "CampanaConvenio");
			c.addOrder(Order.asc("idCampana"));
			return c.list();
		} catch (Exception e) {
			_log.error("Error "+e);
			return null;
		}
	}


}

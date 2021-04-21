package mx.com.convenios.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mx.com.convenios.bean.MonederoConvenio;
import mx.com.convenios.dao.MonederoConvenioDAO;

public class MonederoConvenioDAOImpl extends GenericDAOImpl<MonederoConvenio, Integer> implements MonederoConvenioDAO {

	Logger _log = Logger.getLogger(MonederoConvenioDAOImpl.class);

	@Override
	public boolean saveMonederoConvenio(MonederoConvenio monederoConvenio) {

		Session s = getSessionFactory().openSession();
		Transaction tx = s.getTransaction();
		try {
			s.getTransaction().begin();
			s.save(monederoConvenio); 
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

	@Override
	public List<MonederoConvenio> getListMonederoConvenioByCampana(int idCampana) {
		Session s = getSessionFactory().openSession();
		try {
			String sql = "select *from POS_DEVLYN.modero_convenio where ID_CAMPANA = :idCampana";
			SQLQuery query = s.createSQLQuery(sql);
			query.addEntity(MonederoConvenio.class);
			query.setParameter("idCampana", idCampana);
			SQLQuery results = query;
			return (List<MonederoConvenio>) results.list();

		} catch (Exception e) {
			_log.error("Error "+e);
			return null;
		}finally{
			s.close();
		}

	}

}

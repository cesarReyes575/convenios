package mx.com.convenios.dao.impl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.dao.support.DataAccessUtils;

import mx.com.convenios.bean.Usuario;
import mx.com.convenios.dao.UsuarioDAO;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

	Logger _log = Logger.getLogger(UsuarioDAOImpl.class);

	@Override
	public Usuario getUsuario(String nombreUsuario) {
		
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
			criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
			return (Usuario) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(criteria));
		} catch (Exception e) {
			_log.error("Error ",e);
			return null;
		}
	}

}

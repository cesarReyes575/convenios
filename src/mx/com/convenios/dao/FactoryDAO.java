package mx.com.convenios.dao;


public abstract class FactoryDAO {

	public static Class HIBERNATE = mx.com.convenios.dao.impl.FactoryDAOImpl.class;

	public static FactoryDAO instance(Class factory){
		try {

			return (FactoryDAO) factory.newInstance();
		} catch (Exception e) {

			throw new RuntimeException(
					"No se puede crear DAOFactory: "+ factory);
		}
	}

	public abstract UsuarioDAO getUsuarioDAO();
	
	public abstract EmpresaDAO getEmpresaDAO();
	
	public abstract SubEmpresaDAO getSubEmpresaDAO();
	
	public abstract CampanaConvenioDAO getCampanaConvenioDAO();
	
	public abstract MonederoConvenioDAO getMonederoConvenioDAO();
	
	public abstract HistoricoEmpresaDAO getHistoricoEmpresaDAO();
	
	public abstract HistoricoCampanaConvenioDAO getHistoricoCampanaConvenioDAO();
	

}
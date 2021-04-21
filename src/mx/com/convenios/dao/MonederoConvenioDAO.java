package mx.com.convenios.dao;

import java.util.List;

import mx.com.convenios.bean.MonederoConvenio;

public interface MonederoConvenioDAO extends GenericDAO<MonederoConvenio, Integer> {

	public boolean saveMonederoConvenio(MonederoConvenio monederoConvenio);

	public List<MonederoConvenio> getListMonederoConvenioByCampana(int idCampana);	
}
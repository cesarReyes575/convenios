package mx.com.convenios.dao;

import mx.com.convenios.bean.HistoricoCampanaConvenio;

public interface HistoricoCampanaConvenioDAO extends GenericDAO<HistoricoCampanaConvenio, Integer> {

	public boolean saveHistoricoCampanaConvenio(HistoricoCampanaConvenio historicoCampanaConvenio);

}
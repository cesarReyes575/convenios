package mx.com.convenios.service;

import mx.com.convenios.bean.HistoricoCampanaConvenio;
import mx.com.convenios.dao.HistoricoCampanaConvenioDAO;

public class HistoricoCampanaConvenioService extends Service {

	private HistoricoCampanaConvenioDAO dao;

	public HistoricoCampanaConvenioService() {
		this.dao = factoryDAO.getHistoricoCampanaConvenioDAO();
	}

	public boolean saveHistoricoCampanaConvenio(HistoricoCampanaConvenio historicoCampanaConvenio) {
		return dao.saveHistoricoCampanaConvenio(historicoCampanaConvenio);
	}
}

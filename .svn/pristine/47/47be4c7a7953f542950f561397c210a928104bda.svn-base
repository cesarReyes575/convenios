package mx.com.convenios.service;

import java.util.List;

import mx.com.convenios.bean.MonederoConvenio;
import mx.com.convenios.dao.MonederoConvenioDAO;

public class MonederoConvenioService extends Service {

	private MonederoConvenioDAO dao;

	public MonederoConvenioService() {
		this.dao = factoryDAO.getMonederoConvenioDAO();
	}

	public boolean saveMonederoConvenio(MonederoConvenio monederoConvenio) {
		return dao.saveMonederoConvenio(monederoConvenio);
	}

	public List<MonederoConvenio> getListMonederoConvenioByCampana(int idCampana) {
		return dao.getListMonederoConvenioByCampana(idCampana);
	}

}

package mx.com.convenios.service;

import java.util.List;

import mx.com.convenios.bean.CampanaConvenio;
import mx.com.convenios.dao.CampanaConvenioDAO;

public class CampanaConvenioService extends Service {

	private CampanaConvenioDAO dao;

	public CampanaConvenioService() {
		this.dao = factoryDAO.getCampanaConvenioDAO();
	}

	public List<CampanaConvenio> saveCampana(CampanaConvenio campanaConvenios) {
		dao.saveCampana(campanaConvenios);
		return  dao.getListCampanaConvenioOrder();
	}

	public boolean updateCampana(CampanaConvenio campanaConvenios) {
		return dao.makePersistent(campanaConvenios);
	}

	public List<CampanaConvenio> getListCampana(){
		return dao.findAll();
	}

	public CampanaConvenio getCampana(int idCampana) {
		return dao.findById(idCampana);
	}

}




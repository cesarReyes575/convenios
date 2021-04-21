package mx.com.convenios.dao;

import java.util.List;

import mx.com.convenios.bean.CampanaConvenio;

public interface CampanaConvenioDAO extends GenericDAO<CampanaConvenio, Integer> {

	public void saveCampana(CampanaConvenio campanaConvenios);

	public List<CampanaConvenio> getListCampanaConvenioOrder();


}
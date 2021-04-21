package mx.com.convenios.service;

import mx.com.convenios.dao.FactoryDAO;

public class Service {

	protected FactoryDAO factoryDAO;

	public Service(){
		factoryDAO = factoryDAO.instance(FactoryDAO.HIBERNATE);
	} 

}
package mx.com.convenios.service;

import java.util.List;

import org.jboss.logging.Logger;

import mx.com.convenios.bean.CatEmpresa;
import mx.com.convenios.dao.EmpresaDAO;

public class EmpresaService extends Service {

	private EmpresaDAO dao;

	public EmpresaService() {
		this.dao = factoryDAO.getEmpresaDAO();
	}

	public boolean saveEmpresa(CatEmpresa catEmpresa) {
		return dao.saveEmpresa(catEmpresa);
	}

	public List<CatEmpresa> getListEmpresa() {
		return dao.findAll();
	}
	
	public CatEmpresa getEmpresa(int idEmpresa) {
		return dao.findById(idEmpresa);
	}

}

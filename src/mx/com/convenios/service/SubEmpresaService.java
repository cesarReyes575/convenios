package mx.com.convenios.service;

import java.util.List;

import mx.com.convenios.bean.CatSubEmpresa;
import mx.com.convenios.dao.SubEmpresaDAO;

public class SubEmpresaService extends Service {

	private SubEmpresaDAO dao;

	public SubEmpresaService() {
		this.dao = factoryDAO.getSubEmpresaDAO();
	}

	public boolean saveSubEmpresa(CatSubEmpresa catSubEmpresa) {
		return dao.saveSubEmpresa(catSubEmpresa);
	}

	public List<CatSubEmpresa> getListSubEmpresa() {
		return dao.findAll();
	}

	public CatSubEmpresa getSubEmpresa(int idSubEmpresa) {
		return dao.findById(idSubEmpresa);
	}
}

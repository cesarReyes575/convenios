package mx.com.convenios.dao.impl;

import org.springframework.web.context.ContextLoaderListener;

import mx.com.convenios.dao.CampanaConvenioDAO;
import mx.com.convenios.dao.EmpresaDAO;
import mx.com.convenios.dao.FactoryDAO;
import mx.com.convenios.dao.HistoricoCampanaConvenioDAO;
import mx.com.convenios.dao.HistoricoEmpresaDAO;
import mx.com.convenios.dao.MonederoConvenioDAO;
import mx.com.convenios.dao.SubEmpresaDAO;
import mx.com.convenios.dao.UsuarioDAO;

public class FactoryDAOImpl extends FactoryDAO {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return (UsuarioDAO) ContextLoaderListener.getCurrentWebApplicationContext().getBean("UsuarioDAO");
	}

	@Override
	public EmpresaDAO getEmpresaDAO() {
		return (EmpresaDAO) ContextLoaderListener.getCurrentWebApplicationContext().getBean("EmpresaDAO");
	}

	@Override
	public SubEmpresaDAO getSubEmpresaDAO() {
		return (SubEmpresaDAO) ContextLoaderListener.getCurrentWebApplicationContext().getBean("SubEmpresaDAO");
	}

	@Override
	public CampanaConvenioDAO getCampanaConvenioDAO() {
		return (CampanaConvenioDAO) ContextLoaderListener.getCurrentWebApplicationContext().getBean("CampanaConvenioDAO");
	}

	@Override
	public MonederoConvenioDAO getMonederoConvenioDAO() {
		return (MonederoConvenioDAO) ContextLoaderListener.getCurrentWebApplicationContext().getBean("MonederoConvenioDAO");
	}

	@Override
	public HistoricoEmpresaDAO getHistoricoEmpresaDAO() {
		return (HistoricoEmpresaDAO) ContextLoaderListener.getCurrentWebApplicationContext().getBean("HistoricoEmpresaDAO");
	}

	@Override
	public HistoricoCampanaConvenioDAO getHistoricoCampanaConvenioDAO() {
		return (HistoricoCampanaConvenioDAO) ContextLoaderListener.getCurrentWebApplicationContext().getBean("HistoricoCampanaConvenioDAO");
	}


}
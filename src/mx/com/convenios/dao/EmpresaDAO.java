package mx.com.convenios.dao;

import mx.com.convenios.bean.CatEmpresa;

public interface EmpresaDAO extends GenericDAO<CatEmpresa, Integer> {

	public boolean saveEmpresa(CatEmpresa catEmpresa);


}
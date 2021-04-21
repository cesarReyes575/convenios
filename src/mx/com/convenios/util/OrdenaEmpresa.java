package mx.com.convenios.util;

import java.util.Comparator;

import mx.com.convenios.bean.CatEmpresa;

public class OrdenaEmpresa implements Comparator<CatEmpresa> {

	
	@Override
	public int compare(CatEmpresa o1, CatEmpresa o2) {

		return o1.getIdEmpresa() > o2.getIdEmpresa()? 1 : -1;

	}

}
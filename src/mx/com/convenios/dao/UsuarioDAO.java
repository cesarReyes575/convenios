package mx.com.convenios.dao;

import mx.com.convenios.bean.Usuario;
import mx.com.convenios.dao.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

	public abstract Usuario getUsuario(String usuario);


}


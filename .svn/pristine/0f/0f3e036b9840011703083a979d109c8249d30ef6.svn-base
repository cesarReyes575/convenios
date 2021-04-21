package mx.com.convenios.service;

import mx.com.convenios.bean.Usuario;
import mx.com.convenios.dao.UsuarioDAO;

public class UsuarioService extends Service {

	private UsuarioDAO dao;

	public UsuarioService() {
		this.dao = factoryDAO.getUsuarioDAO();
	}

	public Usuario getUsuario(String nombreUsuario) {
		return dao.getUsuario(nombreUsuario);
	}

}

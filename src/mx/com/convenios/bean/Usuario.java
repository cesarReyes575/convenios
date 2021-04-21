package mx.com.convenios.bean;

import org.apache.struts.action.ActionForm;

public class Usuario extends ActionForm implements java.io.Serializable{

	private int idUsuario;
	private String nombreUsuario;
	private String contrasena;

	public Usuario() {
	}

	public Usuario(int idUsuario, String nombreUsuario, String contrasena) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena
				+ "]";
	}

}

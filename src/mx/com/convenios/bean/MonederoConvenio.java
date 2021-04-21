package mx.com.convenios.bean;
// Generated Apr 19, 2021, 12:37:22 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * MonederoConvenio generated by hbm2java
 */
public class MonederoConvenio implements java.io.Serializable {

	private String idTarjeta;
	private CampanaConvenio campanaConvenio;
	private boolean activo;
	private BigDecimal saldo;
	private String idCentro;
	private Integer idEmpleadoCreacion;
	private Timestamp fechaCreacion;
	private Timestamp fechaRedencion;
	private Integer idEmpleadoRedencion;
	private Integer idCliente;
	private Integer idPedido;
	private Timestamp fechaActivacion;

	public MonederoConvenio() {
	}

	public MonederoConvenio(String idTarjeta, CampanaConvenio campanaConvenio, boolean activo, BigDecimal saldo) {
		this.idTarjeta = idTarjeta;
		this.campanaConvenio = campanaConvenio;
		this.activo = activo;
		this.saldo = saldo;
	}

	public MonederoConvenio(String idTarjeta, CampanaConvenio campanaConvenio, boolean activo, BigDecimal saldo,
			String idCentro, Integer idEmpleadoCreacion, Timestamp fechaCreacion, Timestamp fechaRedencion,
			Integer idEmpleadoRedencion, Integer idCliente, Integer idPedido, Timestamp fechaActivacion) {
		this.idTarjeta = idTarjeta;
		this.campanaConvenio = campanaConvenio;
		this.activo = activo;
		this.saldo = saldo;
		this.idCentro = idCentro;
		this.idEmpleadoCreacion = idEmpleadoCreacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaRedencion = fechaRedencion;
		this.idEmpleadoRedencion = idEmpleadoRedencion;
		this.idCliente = idCliente;
		this.idPedido = idPedido;
		this.fechaActivacion = fechaActivacion;
	}

	public String getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(String idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public CampanaConvenio getCampanaConvenio() {
		return this.campanaConvenio;
	}

	public void setCampanaConvenio(CampanaConvenio campanaConvenio) {
		this.campanaConvenio = campanaConvenio;
	}

	public boolean isActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getIdCentro() {
		return this.idCentro;
	}

	public void setIdCentro(String idCentro) {
		this.idCentro = idCentro;
	}

	public Integer getIdEmpleadoCreacion() {
		return this.idEmpleadoCreacion;
	}

	public void setIdEmpleadoCreacion(Integer idEmpleadoCreacion) {
		this.idEmpleadoCreacion = idEmpleadoCreacion;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaRedencion() {
		return this.fechaRedencion;
	}

	public void setFechaRedencion(Timestamp fechaRedencion) {
		this.fechaRedencion = fechaRedencion;
	}

	public Integer getIdEmpleadoRedencion() {
		return this.idEmpleadoRedencion;
	}

	public void setIdEmpleadoRedencion(Integer idEmpleadoRedencion) {
		this.idEmpleadoRedencion = idEmpleadoRedencion;
	}

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Timestamp getFechaActivacion() {
		return this.fechaActivacion;
	}

	public void setFechaActivacion(Timestamp fechaActivacion) {
		this.fechaActivacion = fechaActivacion;
	}

}
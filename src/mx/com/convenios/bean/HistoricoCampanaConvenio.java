package mx.com.convenios.bean;
// Generated Apr 19, 2021, 12:37:22 PM by Hibernate Tools 4.3.5.Final

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * HistoricoCampanaConvenio generated by hbm2java
 */
public class HistoricoCampanaConvenio implements java.io.Serializable {

	private int idHistoricoCampanaConvenio;
	private CampanaConvenio campanaConvenio;
	private int idEmpleado;
	private Timestamp fecha;
	private Timestamp fechaInicio;
	private Timestamp fechaVigencia;
	private BigDecimal montoMinimo;
	private Boolean capturaDatos;
	private Character status;

	public HistoricoCampanaConvenio() {
	}

	public HistoricoCampanaConvenio(int idHistoricoCampanaConvenio, CampanaConvenio campanaConvenio, int idEmpleado,
			Timestamp fecha) {
		this.idHistoricoCampanaConvenio = idHistoricoCampanaConvenio;
		this.campanaConvenio = campanaConvenio;
		this.idEmpleado = idEmpleado;
		this.fecha = fecha;
	}

	public HistoricoCampanaConvenio(int idHistoricoCampanaConvenio, CampanaConvenio campanaConvenio, int idEmpleado,
			Timestamp fecha, Timestamp fechaInicio, Timestamp fechaVigencia, BigDecimal montoMinimo,
			Boolean capturaDatos, Character status) {
		this.idHistoricoCampanaConvenio = idHistoricoCampanaConvenio;
		this.campanaConvenio = campanaConvenio;
		this.idEmpleado = idEmpleado;
		this.fecha = fecha;
		this.fechaInicio = fechaInicio;
		this.fechaVigencia = fechaVigencia;
		this.montoMinimo = montoMinimo;
		this.capturaDatos = capturaDatos;
		this.status = status;
	}

	public int getIdHistoricoCampanaConvenio() {
		return this.idHistoricoCampanaConvenio;
	}

	public void setIdHistoricoCampanaConvenio(int idHistoricoCampanaConvenio) {
		this.idHistoricoCampanaConvenio = idHistoricoCampanaConvenio;
	}

	public CampanaConvenio getCampanaConvenio() {
		return this.campanaConvenio;
	}

	public void setCampanaConvenio(CampanaConvenio campanaConvenio) {
		this.campanaConvenio = campanaConvenio;
	}

	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Timestamp getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Timestamp getFechaVigencia() {
		return this.fechaVigencia;
	}

	public void setFechaVigencia(Timestamp fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public BigDecimal getMontoMinimo() {
		return this.montoMinimo;
	}

	public void setMontoMinimo(BigDecimal montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	public Boolean getCapturaDatos() {
		return this.capturaDatos;
	}

	public void setCapturaDatos(Boolean capturaDatos) {
		this.capturaDatos = capturaDatos;
	}

	public Character getStatus() {
		return this.status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

}
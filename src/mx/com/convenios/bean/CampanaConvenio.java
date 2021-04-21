package mx.com.convenios.bean;
// Generated Apr 19, 2021, 12:37:22 PM by Hibernate Tools 4.3.5.Final

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts.action.ActionForm;

/**
 * CampanaConvenio generated by hbm2java
 */
public class CampanaConvenio extends ActionForm  implements java.io.Serializable {

	private int idCampana;
	private CatEmpresa catEmpresa;
	private CatSubEmpresa catSubEmpresa;
	private String nombre;
	private Timestamp fechaInicio;
	private Timestamp fechaVigencia;
	private Timestamp fechaCreacion;
	private BigDecimal montoMinimo;
	private boolean capturaDatos;
	private long monederos;
	private Character status;
	private Character tipoMonedero;
	private Set<HistoricoCampanaConvenio> historicoCampanaConvenios = new HashSet<HistoricoCampanaConvenio>(0);
	private Set<MonederoConvenio>  monederoConvenios = new HashSet<MonederoConvenio>(0);

	public CampanaConvenio() {
	}

	public CampanaConvenio(int idCampana, CatEmpresa catEmpresa, CatSubEmpresa catSubEmpresa, String nombre,
			Timestamp fechaInicio, Timestamp fechaVigencia,Timestamp fechaCreacion, BigDecimal montoMinimo, boolean capturaDatos,
			long monederos) {
		this.idCampana = idCampana;
		this.catEmpresa = catEmpresa;
		this.catSubEmpresa = catSubEmpresa;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaVigencia = fechaVigencia;
		this.fechaCreacion = fechaCreacion;
		this.montoMinimo = montoMinimo;
		this.capturaDatos = capturaDatos;
		this.monederos = monederos;
	}

	public CampanaConvenio(int idCampana, CatEmpresa catEmpresa, CatSubEmpresa catSubEmpresa, String nombre,
			Timestamp fechaInicio, Timestamp fechaVigencia, Timestamp fechaCreacion, BigDecimal montoMinimo, boolean capturaDatos,
			long monederos, Character status, Character tipoMonedero, Set<HistoricoCampanaConvenio> historicoCampanaConvenios,
			Set<MonederoConvenio> monederoConvenios) {
		this.idCampana = idCampana;
		this.catEmpresa = catEmpresa;
		this.catSubEmpresa = catSubEmpresa;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaVigencia = fechaVigencia;
		this.fechaCreacion = fechaCreacion;
		this.montoMinimo = montoMinimo;
		this.capturaDatos = capturaDatos;
		this.monederos = monederos;
		this.status = status;
		this.tipoMonedero = tipoMonedero;
		this.historicoCampanaConvenios = historicoCampanaConvenios;
		this.monederoConvenios = monederoConvenios;
	}

	public int getIdCampana() {
		return this.idCampana;
	}

	public void setIdCampana(int idCampana) {
		this.idCampana = idCampana;
	}

	public CatEmpresa getCatEmpresa() {
		return this.catEmpresa;
	}

	public void setCatEmpresa(CatEmpresa catEmpresa) {
		this.catEmpresa = catEmpresa;
	}

	public CatSubEmpresa getCatSubEmpresa() {
		return this.catSubEmpresa;
	}

	public void setCatSubEmpresa(CatSubEmpresa catSubEmpresa) {
		this.catSubEmpresa = catSubEmpresa;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public boolean isCapturaDatos() {
		return this.capturaDatos;
	}

	public void setCapturaDatos(boolean capturaDatos) {
		this.capturaDatos = capturaDatos;
	}

	public long getMonederos() {
		return this.monederos;
	}

	public void setMonederos(long monederos) {
		this.monederos = monederos;
	}

	public Character getStatus() {
		return this.status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Character getTipoMonedero() {
		return this.tipoMonedero;
	}

	public void setTipoMonedero(Character tipoMonedero) {
		this.tipoMonedero = tipoMonedero;
	}

	public Set<HistoricoCampanaConvenio> getHistoricoCampanaConvenios() {
		return this.historicoCampanaConvenios;
	}

	public void setHistoricoCampanaConvenios(Set<HistoricoCampanaConvenio> historicoCampanaConvenios) {
		this.historicoCampanaConvenios = historicoCampanaConvenios;
	}

	public Set<MonederoConvenio> getMonederoConvenios() {
		return this.monederoConvenios;
	}

	public void setMonederoConvenios(Set<MonederoConvenio> monederoConvenios) {
		this.monederoConvenios = monederoConvenios;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	

}
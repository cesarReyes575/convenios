package mx.com.convenios.action;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.JsonObject;

import mx.com.convenios.bean.CampanaConvenio;
import mx.com.convenios.bean.CampanaJsonRequest;
import mx.com.convenios.bean.CatEmpresa;
import mx.com.convenios.bean.CatSubEmpresa;
import mx.com.convenios.bean.HistoricoCampanaConvenio;
import mx.com.convenios.bean.MonederoConvenio;
import mx.com.convenios.bean.Usuario;
import mx.com.convenios.service.CampanaConvenioService;
import mx.com.convenios.service.EmpresaService;
import mx.com.convenios.service.MonederoConvenioService;
import mx.com.convenios.service.SubEmpresaService;
import mx.com.convenios.util.ConveniosKeys;
import mx.com.convenios.util.OrdenaEmpresa;

public class CampanaAction extends DispatchAction {

	private final static String LISTCAMPANAS = "listCampanas";
	private final static String FORMCAMPANA = "formCampana";
	private final static String FORMUPDATECAMPANA = "formUpdateCampana";

	Logger _log = Logger.getLogger(CampanaAction.class);

	public ActionForward saveCampana(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String fCreacion = sdf.format(date);
		Timestamp fechaCreacion = new Timestamp(sdf.parse(fCreacion ).getTime());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/x-json");
		JsonObject json = new JsonObject();
		CampanaJsonRequest campanaJson = (CampanaJsonRequest) form;

		try {
			EmpresaService es = new EmpresaService();
			CatEmpresa catEmpresa = es.getEmpresa(campanaJson.getIdEmpresa());

			SubEmpresaService ses = new SubEmpresaService();
			CatSubEmpresa catSubEmpresa = ses.getSubEmpresa(campanaJson.getIdSubEmpresa());

			CampanaConvenioService cs = new CampanaConvenioService();

			MonederoConvenioService mcs = new  MonederoConvenioService();

			Timestamp fechaInicial = new Timestamp(sdf.parse(campanaJson.getFechaInicio() + " 00:00:00").getTime());
			Timestamp fechaVigencia = new Timestamp(sdf.parse(campanaJson.getFechaVigencia() + " 23:59:59").getTime());

			/**************Campana*/
			CampanaConvenio campana = new CampanaConvenio();
			campana.setNombre(campanaJson.getNombre());
			campana.setCapturaDatos(campanaJson.isCapturaDatos());
			campana.setFechaCreacion(fechaCreacion);
			campana.setFechaInicio(fechaInicial);
			campana.setFechaVigencia(fechaVigencia);
			campana.setMonederos(campanaJson.getCantidadMonedero());
			campana.setStatus('A');
			campana.setTipoMonedero(campanaJson.getTipoMonedero().charAt(0));
			campana.setMontoMinimo(campanaJson.getMontoMinimo());
			campana.setNombre(campanaJson.getNombre());
			campana.setCatEmpresa(catEmpresa);		
			campana.setCatSubEmpresa(catSubEmpresa);

			List<CampanaConvenio> listCampanaConvenio = cs.saveCampana(campana);
			int idCampana = listCampanaConvenio.get( listCampanaConvenio.size()-1 ).getIdCampana();
			_log.info("idCampana: "+idCampana);
			if(idCampana !=0) {
				int pos;
				int rango = 100000000;
				Stack < String > codigos = new Stack < String > ();
				for (int i = 0; i < campanaJson.getCantidadMonedero() ; i++) {
					pos = (int) Math.floor(Math.random() * rango );
					while (codigos.contains(pos)) {
						pos = (int) Math.floor(Math.random() * rango );
					}
					codigos.push( (pos+1)+"");
				}
				Stack < String > codigosCompletos = new Stack < String > ();
				String tipoMon = campana.getTipoMonedero() =='V'  ? "MV0": "900";
				DecimalFormat df = new DecimalFormat("00000000");
				for (String cod : codigos) {
					codigosCompletos.push(tipoMon+idCampana+df.format(Double.parseDouble(cod)));
				}

				Usuario usuario = (Usuario) request.getSession().getAttribute(ConveniosKeys.USUARIO_SESSION);
				CampanaConvenio cc = cs.getCampana(idCampana);

				for (String codigosC : codigosCompletos) {
					MonederoConvenio mc = new MonederoConvenio();
					mc.setIdTarjeta(codigosC);
					mc.setCampanaConvenio(cc);
					if(tipoMon.equals("900")) {
						mc.setActivo(true);
						mc.setFechaActivacion(fechaCreacion);
					}else {
						mc.setActivo(false);
					}
					mc.setSaldo(new BigDecimal(campanaJson.getMontoMonedero()) );
					mc.setIdEmpleadoCreacion(usuario.getIdUsuario());
					mc.setFechaCreacion(fechaCreacion);
					mcs.saveMonederoConvenio(mc);
				}
			}else {
				_log.info("Error al guardar campaña");
				json.addProperty("respuesta", 0);
				json.addProperty("mensaje", "Error al guardar la campaña");
			}

			json.addProperty("respuesta", 1);
			json.addProperty("mensaje", "Se guardo la Campaña correctamente");

		} catch (Exception e) {
			json.addProperty("respuesta", 0);
			json.addProperty("mensaje", "Error general");
			_log.error("Error " + e);
		}  
		pw.write(json.toString());
		pw.flush();
		return null;
	}

	public ActionForward formUpdateCampana(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		int idCampana = Integer.parseInt( request.getParameter("idCampana") );
		try {
			CampanaConvenioService cs = new CampanaConvenioService();
			CampanaConvenio cc = cs.getCampana(idCampana);
			request.setAttribute("campanaConvenioRequest", cc);
			request.setAttribute("saldoRequest",cc.getMonederoConvenios().iterator().next().getSaldo().toString() );
		} catch (Exception e) {
			_log.error("Error "+e);
			e.printStackTrace();
			return mapping.findForward(FORMUPDATECAMPANA);
		}
		return mapping.findForward(FORMUPDATECAMPANA);
	}

	public ActionForward formCampana(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		try {
			EmpresaService es = new EmpresaService();
			List<CatEmpresa> listEmpresa = es.getListEmpresa();
			Collections.sort(listEmpresa, new OrdenaEmpresa());
			request.setAttribute("listEmpresaRequest", listEmpresa);
		} catch (Exception e) {
			_log.error("Error " + e);
			return mapping.findForward(FORMCAMPANA);
		}  
		return mapping.findForward(FORMCAMPANA);
	}

	public ActionForward getListCampana(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		try {
			CampanaConvenioService ccs = new CampanaConvenioService(); 
			List<CampanaConvenio> listCampanaConvenio = ccs.getListCampana();
			request.setAttribute("listCampanaConvenioRequest", listCampanaConvenio);

		} catch (Exception e) {
			_log.error("Error "+e);
			return mapping.findForward(LISTCAMPANAS);
		}
		return mapping.findForward(LISTCAMPANAS);
	}

	public ActionForward cancelarCampana(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/x-json");
		JsonObject json = new JsonObject();
		int idCampana = Integer.parseInt( request.getParameter("idCampana") );
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String fCreacion = sdf.format(date);
		Timestamp fechaCreacion = new Timestamp(sdf.parse(fCreacion).getTime());
		try { 
			Usuario usuario = (Usuario) request.getSession().getAttribute(ConveniosKeys.USUARIO_SESSION);
			CampanaConvenioService ccs = new CampanaConvenioService();
			CampanaConvenio cc = ccs.getCampana(idCampana);
			cc.setStatus('C');

			HistoricoCampanaConvenio hcc = new HistoricoCampanaConvenio();
			hcc.setFecha(fechaCreacion);
			hcc.setFechaInicio(cc.getFechaInicio());
			hcc.setFechaVigencia(cc.getFechaVigencia());
			hcc.setMontoMinimo(cc.getMontoMinimo());
			hcc.setCapturaDatos(cc.isCapturaDatos());
			hcc.setIdEmpleado(usuario.getIdUsuario());
			hcc.setCampanaConvenio(cc);
			hcc.setStatus(cc.getStatus());	
			cc.getHistoricoCampanaConvenios().add(hcc);

			if(ccs.updateCampana(cc)) {
				_log.info("se actualizo campana");
				json.addProperty("respuesta", 1);
				json.addProperty("mensaje", "Se guardo la Campaña correctamente");
			}else {
				_log.info("No se actualizo campana");
				json.addProperty("respuesta", 0);
				json.addProperty("mensaje", "Error al Cancelar la campaña");
			}

		} catch (Exception e) {
			json.addProperty("respuesta", 0);
			json.addProperty("mensaje", "Error general");
			_log.error("Error "+e);
		}
		pw.write(json.toString());
		pw.flush();
		return null;
	}

	public ActionForward updateCampana(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/x-json");
		JsonObject json = new JsonObject();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		CampanaJsonRequest campanaJson = (CampanaJsonRequest) form;
		Timestamp fechaInicial = new Timestamp(sdf.parse(campanaJson.getFechaInicio() + " 00:00:00").getTime());
		Timestamp fechaVigencia = new Timestamp(sdf.parse(campanaJson.getFechaVigencia() + " 23:59:59").getTime());
		Stack < String > codigosTotales = new Stack < String > ();
		Stack < String > codigosNuevos = new Stack < String > ();
		Date date = new Date();
		String fCreacion = sdf.format(date);
		Usuario usuario = (Usuario) request.getSession().getAttribute(ConveniosKeys.USUARIO_SESSION);
		Timestamp fechaCreacion = new Timestamp(sdf.parse(fCreacion).getTime());

		try {

			CampanaConvenioService ccs = new CampanaConvenioService();
			CampanaConvenio campana = ccs.getCampana(campanaJson.getIdCampana());
			_log.info("campanaJson: "+campanaJson);


			/*----------campana*/
			campana.setFechaInicio(fechaInicial);
			campana.setFechaVigencia(fechaVigencia);
			campana.setMontoMinimo(campanaJson.getMontoMinimo());
			campana.setCapturaDatos(campanaJson.isCapturaDatos());

			int cuponesRestan = campanaJson.getCantidadMonedero() - (int)campana.getMonederos();
			if(cuponesRestan != 0) {
				_log.info("entro a generar "+cuponesRestan+"  nuevos cupones");
				for (MonederoConvenio mc : campana.getMonederoConvenios()) {
					codigosTotales.push( mc.getIdTarjeta() );
				}
				int pos;
				int rango = 100000000;
				String tipoMon = campana.getTipoMonedero() =='V'  ? "MV0": "900";
				String codigoTemp;
				DecimalFormat df = new DecimalFormat("00000000");
				for (int i = 0; i < cuponesRestan ; i++) {
					pos = (int) Math.floor(Math.random()*(100000000-1+1)+1);
					codigoTemp = tipoMon+campanaJson.getIdCampana()+df.format(Double.parseDouble(pos+""));
					while (codigosTotales.contains(codigoTemp)) {
						pos = (int) Math.floor(Math.random() * rango );
						codigoTemp = tipoMon+campanaJson.getIdCampana()+df.format(Double.parseDouble(pos+""));
					}
					codigosTotales.push( codigoTemp );
					codigosNuevos.push( codigoTemp );
				}
				for (String codigos : codigosNuevos) {
					MonederoConvenio mc = new MonederoConvenio();
					mc.setIdTarjeta(codigos);
					mc.setCampanaConvenio(campana);
					if(tipoMon.equals("900")) {
						mc.setActivo(true);
						mc.setFechaActivacion(fechaCreacion);
					}else {
						mc.setActivo(false);
					}

					mc.setSaldo(new BigDecimal(campanaJson.getMontoMonedero()) );
					mc.setFechaCreacion(fechaCreacion);
					mc.setIdEmpleadoCreacion(usuario.getIdUsuario());
					campana.getMonederoConvenios().add(mc);
				}

			}
			campana.setMonederos(campanaJson.getCantidadMonedero());
			/*----------Historico campana*/
			HistoricoCampanaConvenio hcc = new HistoricoCampanaConvenio();
			hcc.setFecha(fechaCreacion);
			hcc.setFechaInicio(fechaInicial);
			hcc.setFechaVigencia(fechaVigencia);
			hcc.setMontoMinimo(campanaJson.getMontoMinimo());
			hcc.setCapturaDatos(campanaJson.isCapturaDatos());
			hcc.setIdEmpleado(usuario.getIdUsuario());
			hcc.setCampanaConvenio(campana);
			hcc.setStatus(campana.getStatus());
			campana.getHistoricoCampanaConvenios().add(hcc);
			ccs.updateCampana(campana);
			json.addProperty("respuesta", 1);
			json.addProperty("mensaje", "Se guardo la Campaña correctamente");

		} catch (Exception e) {
			json.addProperty("respuesta", 0);
			json.addProperty("mensaje", "Error general");
			_log.error("Error " + e);
		}  
		_log.info(".............................");
		pw.write(json.toString());
		pw.flush();
		return null;
	}

}

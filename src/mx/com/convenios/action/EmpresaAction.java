package mx.com.convenios.action;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.JsonObject;

import mx.com.convenios.bean.CatEmpresa;
import mx.com.convenios.service.EmpresaService;
import mx.com.convenios.util.OrdenaEmpresa;


public class EmpresaAction extends DispatchAction {

	private final static String LISTEMPRESAS = "listEmpresas";

	Logger _log = Logger.getLogger(EmpresaAction.class);

	public ActionForward saveEmpresa(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/x-json");
		JsonObject json = new JsonObject();
		CatEmpresa empresa = (CatEmpresa) form;
		try {
			EmpresaService es = new EmpresaService();
			List<CatEmpresa> listEmpresas = es.getListEmpresa();
			boolean bandera = true;
			for (CatEmpresa catEmpresa : listEmpresas) {
				if(catEmpresa.getNombre().equalsIgnoreCase(empresa.getNombre())) {
					bandera = false;
				}
			}
			if(bandera) {
				if(es.saveEmpresa(empresa)) {
					json.addProperty("respuesta", 1);
					json.addProperty("mensaje", "Se guardo la Empresa correctamente");
				}else {
					_log.info("no se pudo guardar empresa");
					json.addProperty("respuesta", 0);
					json.addProperty("mensaje", "No se guardardo la Empresa");
				}
			}else {
				_log.info("no se pudo guardar empresa");
				json.addProperty("respuesta", 0);
				json.addProperty("mensaje", "La Empresa ya esta registrada");

			}


		} catch (Exception e) {
			json.addProperty("respuesta", 0);
			json.addProperty("mensaje", "Error general");
			_log.error("Error " + e);
		}  
		pw.write(json.toString());
		pw.flush();
		return null;
	}

	public ActionForward getListEmpresa(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		try {
			EmpresaService es = new EmpresaService();
			List<CatEmpresa> listEmpresa = es.getListEmpresa();
			Collections.sort(listEmpresa, new OrdenaEmpresa());
			request.setAttribute("listEmpresaRequest", listEmpresa);
		} catch (Exception e) {
			_log.error("Error " + e);
			return mapping.findForward(LISTEMPRESAS);
		}  
		return mapping.findForward(LISTEMPRESAS);
	}

}

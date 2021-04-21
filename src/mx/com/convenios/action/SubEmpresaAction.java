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
import mx.com.convenios.bean.CatSubEmpresa;
import mx.com.convenios.service.EmpresaService;
import mx.com.convenios.service.SubEmpresaService;
import mx.com.convenios.util.OrdenaEmpresa;

public class SubEmpresaAction extends DispatchAction {

	private final static String FORMSUBEMPRESA = "formSubEmpresa";
	Logger _log = Logger.getLogger(SubEmpresaAction.class);

	public ActionForward formSubEmpresa(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		try {
			EmpresaService es = new EmpresaService();
			List<CatEmpresa> listEmpresa = es.getListEmpresa();
			Collections.sort(listEmpresa, new OrdenaEmpresa());
			request.setAttribute("listEmpresaRequest", listEmpresa);
		} catch (Exception e) {
			_log.error("Error " + e);
			return mapping.findForward(FORMSUBEMPRESA);
		}  
		return mapping.findForward(FORMSUBEMPRESA);
	}
	
	public ActionForward saveSubEmpresa(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/x-json");
		JsonObject json = new JsonObject();
		String nombre = request.getParameter("nombre");
		int idEmpresa = Integer.parseInt(request.getParameter("idEmpresa"));		
		try {
			EmpresaService es = new EmpresaService();
			CatEmpresa catEmpresa = es.getEmpresa(idEmpresa);
			CatSubEmpresa catSubEmpresa = new CatSubEmpresa();
			catSubEmpresa.setNombre(nombre);
			catSubEmpresa.setCatEmpresa(catEmpresa);
			SubEmpresaService ses = new SubEmpresaService();
			if(ses.saveSubEmpresa(catSubEmpresa)) {
				json.addProperty("respuesta", 1);
				json.addProperty("mensaje", "Se guardo la Sub Empresa correctamente");
			}else {
				_log.info("no se pudo guardar");
				json.addProperty("respuesta", 0);
				json.addProperty("mensaje", "No se guardardo la Sub Empresa");
			}

		} catch (Exception e) {
			json.addProperty("respuesta", 0);
			json.addProperty("mensaje", "error general");
			_log.error("Error " + e);
		}
		pw.write(json.toString());
		pw.flush();
		return null;
	}

}

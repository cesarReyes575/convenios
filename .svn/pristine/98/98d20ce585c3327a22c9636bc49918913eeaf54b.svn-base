package mx.com.convenios.processor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.tiles.TilesRequestProcessor;

import mx.com.convenios.bean.Usuario;
import mx.com.convenios.util.ConveniosKeys;

public class ConveniosProcessor extends TilesRequestProcessor {

	private static final Logger _log = Logger.getLogger(ConveniosProcessor.class);

	public ConveniosProcessor() {
		super();
	}

	@Override
	protected boolean processRoles(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping)
			throws IOException, ServletException {

		Usuario usuario = (Usuario) request.getSession().getAttribute(ConveniosKeys.USUARIO_SESSION);
		String path= mapping.getPath();
		if(usuario != null && usuario.getNombreUsuario() != null ) {
			if( !path.contains("Welcome") && !path.contains("login")){
				return true;
			}else {
				response.sendRedirect(request.getContextPath() + "/principal.do");
				return true;
			}
		}
		else {
			if( !path.contains("Welcome") && !path.contains("login") ){
				response.sendRedirect(request.getContextPath() + "/Welcome.do");
				return true;
			} 
			if(path.contains("Welcome") || path.contains("login")){
				return true;
			}
		}
		return super.processRoles(request, response, mapping);
	}

}
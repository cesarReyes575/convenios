package mx.com.convenios.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import mx.com.convenios.bean.Usuario;
import mx.com.convenios.service.UsuarioService;
import mx.com.convenios.util.ConveniosKeys;


public class LoginAction extends DispatchAction {

	private final static String SUCCESS = "success";
	private final static String LOGOUT = "logout";
	private final static String FAILURE = "failure";

	Logger _log = Logger.getLogger(LoginAction.class);

	public ActionForward login(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		_log.info("---------Login----------");
		Usuario user = (Usuario) form;
		try {
			if(user.getNombreUsuario() != null && user.getContrasena() != null) {
				UsuarioService service = new UsuarioService();
				Usuario usuario = service.getUsuario(user.getNombreUsuario());
				if (usuario.getNombreUsuario().equals(user.getNombreUsuario()) 
						&& usuario.getContrasena().equals(user.getContrasena())
						) {
					request.getSession().setAttribute(ConveniosKeys.USUARIO_SESSION, usuario);
					return mapping.findForward(SUCCESS);
				} else {
					return mapping.findForward(FAILURE);
				}
			}else {
				return mapping.findForward(FAILURE);
			}
		} catch (Exception e) {
			_log.error("Error ", e);
			return mapping.findForward(FAILURE);
		}
	}

	public ActionForward logout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		try {
			if(request.getSession().getAttribute(ConveniosKeys.USUARIO_SESSION) != null){
				request.getSession().removeAttribute(ConveniosKeys.USUARIO_SESSION);
				_log.info("session cerrada!!!!");
				_log.info("*____________________________________________________*");
			}
			//			request.getSession().invalidate();
		} catch (Exception e) {
			_log.error("Error " + e);
		}  
		return mapping.findForward(LOGOUT);
	}
}

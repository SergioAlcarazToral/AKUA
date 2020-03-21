package ejb;

import org.apache.openejb.server.httpd.HttpSession;

import pojo.Usuario;

public class SesionesEJB {

	public Usuario usuarioLogeado(HttpSession session) {
		Usuario usuario = null;
		if(session != null) {
			usuario = (Usuario) session.getAttribute("usuario");
		}
		return usuario;
	}
	
	public void loginUsuario(HttpSession session, Usuario usuario) {
		if (session != null) {
			session.setAttribute("usuario", usuario);
		} else {
			session.invalidate();
		}

	}
	
	public void logoutUsuario(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
	}

}

package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.servlet.http.HttpSession;

import pojo.Usuario;

@Stateless
@LocalBean
public class SesionesEJB {

	public Usuario usuarioLogeado(HttpSession session) {
		Usuario usuario = null;
		if (session != null) {
			usuario = (Usuario) session.getAttribute("usuario");
		}
		return usuario;
	}

	public void loginUsuario(HttpSession session, Usuario usuario) {
		if (session != null) {
			session.setAttribute("usuario", usuario);
		}
	}

	public void logoutUsuario(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}

}

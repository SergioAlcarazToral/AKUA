package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.servlet.http.HttpSession;

import pojo.Usuario;

/**
 * Operaciones relacionadas con las sesiones
 * 
 * @author Sergio
 *
 */
@Stateless
@LocalBean
public class SesionesEJB {

	/**
	 * Saber si tenemos un usuario logeado
	 * 
	 * @param session La sesion actual
	 * @return usuario
	 */
	public Usuario usuarioLogeado(HttpSession session) {
		Usuario usuario = null;
		if (session != null) {
			usuario = (Usuario) session.getAttribute("usuario");
		}
		return usuario;
	}

	/**
	 * Logear un usuario en la sesion
	 * 
	 * @param session La sesion actual
	 * @param usuario El usuario que queremos logear
	 */
	public void loginUsuario(HttpSession session, Usuario usuario) {
		if (session != null) {
			session.setAttribute("usuario", usuario);
		}
	}

	/**
	 * Sacar un usuario de la sesion
	 * 
	 * @param session La sesion que finalizaremos
	 */
	public void logoutUsuario(HttpSession session) {
		if (session != null) {
			session.invalidate();
		}
	}

}

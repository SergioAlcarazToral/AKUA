package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import ejb.UsuarioEJB;
import pojo.Usuario;

/**
 * Servlet para poder dar de baja un usuario en la aplicacion
 * 
 * @author Sergio
 *
 */
@WebServlet("/DarDeBaja")
public class DarDeBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger loggerERROR = LoggerFactory.getLogger("ERROR");

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	UsuarioEJB usuarioEJB;

	@EJB
	ListaReproduccionEJB listaEJB;

	/**
	 * Borra el usuario de la base de datos
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);
		try {
			listaEJB.deleteListasUsuario(usuario.getId());
			usuarioEJB.deleteUsuario(usuario.getId());
		} catch (Exception e) {
			loggerERROR.error("No se ha podido borrar la cuenta de un usuario");
			response.sendRedirect("Error");
		}
		sesionesEJB.logoutUsuario(session);

		response.sendRedirect("Principal");

	}

}

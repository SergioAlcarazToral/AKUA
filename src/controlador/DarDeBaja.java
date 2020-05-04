package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	UsuarioEJB usuarioEJB;

<<<<<<< HEAD
	@EJB
	ListaReproduccionEJB listaEJB;
=======
<<<<<<< HEAD
	@EJB
	ListaReproduccionEJB listaEJB;
=======
>>>>>>> master
>>>>>>> master
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
			e.printStackTrace();
<<<<<<< HEAD
		}
		sesionesEJB.logoutUsuario(session);
		
=======
<<<<<<< HEAD
		}
		sesionesEJB.logoutUsuario(session);
		
=======
			// Poner el logger aqui
		}
		sesionesEJB.logoutUsuario(session);
>>>>>>> master
>>>>>>> master
		response.sendRedirect("Principal");

	}

}

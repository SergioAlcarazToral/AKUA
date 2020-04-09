package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.SesionesEJB;

/**
 * Servlet para poder salir de la sesion del usuario
 * @author Sergio
 *
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	SesionesEJB sesionesEJB;
	
	/**
	 * Comprueba que no exista una sesion, si existe la cerrara
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session != null) {
			sesionesEJB.logoutUsuario(session);
		}
		response.sendRedirect("Principal");
	}

}

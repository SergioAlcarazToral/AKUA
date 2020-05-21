package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejb.SesionesEJB;
import ejb.UsuarioEJB;
import pojo.Usuario;

/**
 * Servlet que se encaraga de poder iniciar sesion en la aplicacion
 * 
 * @author Sergio
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger loggerERROR = LoggerFactory.getLogger("ERROR");

	@EJB
	UsuarioEJB usuarioEJB;

	@EJB
	SesionesEJB sesionesEJB;

	/**
	 * Muestra la pagina de login
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession(false);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Login.jsp");

		// Intentamos obtener el usuario de la sesion
		Usuario usuario = sesionesEJB.usuarioLogeado(session);
		if (usuario != null) {
			// Ya esta logeado, asi que lo redirigimos a la pagina principal
			response.sendRedirect("Principal");
		} else {
			rs.forward(request, response);
		}
	}

	/**
	 * Hace comprovaciones y si el usuario existe crea una sesion con dicho usuario
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String correo = request.getParameter("correo");
		String pass = request.getParameter("pass");

		if (session != null) {
			// Si tenemos sesion, miramos si tenemos un usuario en dicha sesion
			Usuario usuario = usuarioEJB.existeUsuario(correo, pass);

			// Si no tenemos usuario, es una sesion no valida y la desabilitamos
			if (usuario == null) {
				sesionesEJB.logoutUsuario(session);
			}
			try {
				sesionesEJB.loginUsuario(session, usuario);
			} catch (Exception e) {
				response.getWriter().append("Error al iniciar sesion");
				// Aqui va el loger
				loggerERROR.error("Errores para iniciar sesion debido a que los datos son incorrectos");
			}
			response.sendRedirect("Principal");
		} else {

			Usuario usuario = usuarioEJB.existeUsuario(correo, pass);

			if (usuario == null) {
				// No hemos encontrado al usuario, informamos que hay un error
				response.sendRedirect("Login?error=hay");
				loggerERROR.error("Errores a la hora de hacer login debido a que el usuario no existe o los parametros son incorrectos");
			} else {
				session = request.getSession(true);
				sesionesEJB.loginUsuario(session, usuario);
				// Lo redirigimos a la pagina principal
				response.sendRedirect("Principal");
			}
		}

	}

}

package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import ejb.UsuarioEJB;
import pojo.ListaReproduccion;
import pojo.Usuario;

/**
 * Servlet que muestra la pagina principal
 * 
 * @author Sergio
 *
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	UsuarioEJB usuarioEJB;

<<<<<<< HEAD
	@EJB
	ListaReproduccionEJB listasEJB;

=======
<<<<<<< HEAD
	@EJB
	ListaReproduccionEJB listasEJB;

=======
>>>>>>> master
>>>>>>> master
	/**
	 * Muestra la pagina principal
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Principal.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		ArrayList<ListaReproduccion> listas;
		if (usuario != null) {
			listas = listasEJB.getListasUsuario(usuario.getId());
			request.setAttribute("listas", listas);
		}

		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
	}

}

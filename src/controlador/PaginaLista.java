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

import ejb.CancionEJB;
import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import pojo.CancionCompleta;
import pojo.ListaReproduccion;
import pojo.Usuario;

/**
 * Para poder mostrar la pagina de una lista que ha creado un usuario
 * 
 * @author Sergio
 *
 */
@WebServlet("/PaginaLista")
public class PaginaLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ListaReproduccionEJB listasEJB;

	@EJB
	CancionEJB cancionEJB;

	/**
	 * Muestra la pagian de una lista
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		String nombre = request.getParameter("nombre");

		ListaReproduccion lista = listasEJB.getLista(usuario.getId(), nombre);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaLista.jsp");

		ArrayList<CancionCompleta> cancionesLista = cancionEJB.getCancionesCompletasLista(usuario.getId());

		ArrayList<ListaReproduccion> listas = listasEJB.getListasUsuario(usuario.getId());
		request.setAttribute("listas", listas);
		request.setAttribute("lista", lista);
		request.setAttribute("usuario", usuario);
		request.setAttribute("canciones", cancionesLista);

		rs.forward(request, response);
	}

}

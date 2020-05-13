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
 * Servlet implementation class ReproductorAnimadoLista
 */
@WebServlet("/ReproductorAnimadoLista")
public class ReproductorAnimadoLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ListaReproduccionEJB listasEJB;

	@EJB
	CancionEJB cancionEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		String nombre = request.getParameter("nombre");

		ListaReproduccion lista = listasEJB.getLista(usuario.getId(), nombre);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaReproductorLista.jsp");

		ArrayList<CancionCompleta> cancionesLista = cancionEJB.getCancionesCompletasLista(usuario.getId());

		request.setAttribute("lista", lista);
		request.setAttribute("usuario", usuario);
		request.setAttribute("canciones", cancionesLista);

		rs.forward(request, response);

	}

}

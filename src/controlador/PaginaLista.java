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
import pojo.Cancion;
<<<<<<< HEAD
import pojo.ListaReproduccion;
=======
<<<<<<< HEAD
import pojo.ListaReproduccion;
=======
>>>>>>> master
>>>>>>> master
import pojo.Usuario;

/**
 * Servlet implementation class PaginaLista
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
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
>>>>>>> master
>>>>>>> master
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		String nombre = request.getParameter("nombre");

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
		ListaReproduccion lista = listasEJB.getLista(usuario.getId(), nombre);

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaLista.jsp");

		ArrayList<Cancion> cancionesLista = cancionEJB.getCancionesLista(usuario.getId());

		request.setAttribute("lista", lista);
		request.setAttribute("usuario", usuario);
		request.setAttribute("canciones", cancionesLista);
		
		rs.forward(request, response);
<<<<<<< HEAD
=======
=======
		try {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaLista.jsp");

			ArrayList<Cancion> cancionesLista = cancionEJB.getCancionesLista(usuario.getId());
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("canciones", cancionesLista);
		} catch (Exception e) {
			// TODO: handle exception
		}

>>>>>>> master
>>>>>>> master
	}

}

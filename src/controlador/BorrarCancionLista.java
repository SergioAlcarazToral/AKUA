package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> master
>>>>>>> master

import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import pojo.ListaReproduccion;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
import pojo.Usuario;

/**
 * Servlet para poder borrar una cancion de una lista de reproduccion
 * 
 * @author Sergio
 *
<<<<<<< HEAD
=======
=======

/**
 * Servlet implementation class BorrarCancionLista
>>>>>>> master
>>>>>>> master
 */
@WebServlet("/BorrarCancionLista")
public class BorrarCancionLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ListaReproduccionEJB listaEJB;

	/**
	 * Para poder borrar una cancion de una lista de reproduccion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		// Parametros para poder borrar la cancion de una lista
<<<<<<< HEAD
=======
=======
       
	@EJB
	SesionesEJB sesionesEJB;
	
	@EJB
	ListaReproduccionEJB listaEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
>>>>>>> master
>>>>>>> master
		String idCancion = request.getParameter("idCancion");
		String idUsuario = request.getParameter("idUsuario");
		String lista = request.getParameter("nombre");

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
		// Creamos una lista de reproduccion
		ListaReproduccion listaR = new ListaReproduccion();

		// Transformamos los parametros necesarios en int
		Integer idSong = Integer.parseInt(idCancion);
		Integer idUser = Integer.parseInt(idUsuario);

		// Añadimos los datos
		listaR.setNombre(lista);
		listaR.setIdUsuario(idUser);
		listaR.setIdCancion(idSong);

		// Borramos las cancion de la lista
		listaEJB.deleteCancionLista(listaR);

		response.sendRedirect("Principal");

<<<<<<< HEAD
=======
=======
		ListaReproduccion listaR = new ListaReproduccion();

		Integer idSong = Integer.parseInt(idCancion);
		Integer idUser = Integer.parseInt(idUsuario);

		listaR.setNombre(lista);

		listaR.setIdUsuario(idUser);
		listaR.setIdCancion(idSong);

		listaEJB.deleteCancionLista(listaR);
		
		response.sendRedirect("Principal");
		
>>>>>>> master
>>>>>>> master
	}

}

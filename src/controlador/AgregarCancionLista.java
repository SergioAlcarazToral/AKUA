package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import pojo.ListaReproduccion;

/**
<<<<<<< HEAD
 * Este servlet se encarga de que pueda insertarse una cancion en una lista de reproduccion
 * @author Sergio
 *
=======
<<<<<<< HEAD
 * Este servlet se encarga de que pueda insertarse una cancion en una lista de reproduccion
 * @author Sergio
 *
=======
<<<<<<< HEAD
 * Este servlet se encarga de que pueda insertarse una cancion en una lista de reproduccion
 * @author Sergio
 *
=======
 * Servlet implementation class AgregarCancionLista
>>>>>>> master
>>>>>>> master
>>>>>>> master
 */
@WebServlet("/AgregarCancionLista")
public class AgregarCancionLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ListaReproduccionEJB listaEJB;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
	/**
	 * Para poder insertar canciones en las listas de reproduccion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Parametros para insertar
		String idCancion = request.getParameter("idCancion");
		String idUsuario = request.getParameter("idUsuario");
		String lista = request.getParameter("nombre");

		//Creamos una lista con los datos
		ListaReproduccion listaR = new ListaReproduccion();

		//Transformamos los id en int
		Integer idSong = Integer.parseInt(idCancion);
		Integer idUser = Integer.parseInt(idUsuario);

		//Añadimos los datos
		listaR.setNombre(lista);
		listaR.setIdUsuario(idUser);
		listaR.setIdCancion(idSong);
		
		//Insertamos en la base de datos
		listaEJB.insertCancion(listaR);
		
		response.sendRedirect("Principal");
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCancion = request.getParameter("idCancion");
		String idUsuario = request.getParameter("idUsuario");
		String lista = request.getParameter("lista");

		ListaReproduccion listaR = new ListaReproduccion();

		listaR.setNombre(lista);
		Integer idSong = Integer.parseInt(idCancion);
		
		Integer idUser = Integer.parseInt(idUsuario);
		listaR.setIdUsuario(idUser);
		listaR.setIdCancion(idSong);

		listaEJB.insertCancion(listaR);
>>>>>>> master
>>>>>>> master
>>>>>>> master

	}

}

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
import pojo.ListaReproduccion;
import pojo.Usuario;

/**
 * Este servlet se encarga de que pueda insertarse una cancion en una lista de reproduccion
 * @author Sergio
 *
 */
@WebServlet("/AgregarCancionLista")
public class AgregarCancionLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ListaReproduccionEJB listaEJB;

	/**
	 * Para poder insertar canciones en las listas de reproduccion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		//Parametros para insertar
		String idCancion = request.getParameter("idCancion");
		String lista = request.getParameter("nombre");

		//Creamos una lista con los datos
		ListaReproduccion listaR = new ListaReproduccion();

		//Transformamos los id en int
		Integer idSong = Integer.parseInt(idCancion);

		//Añadimos los datos
		listaR.setNombre(lista);
		listaR.setIdUsuario(usuario.getId());
		listaR.setIdCancion(idSong);
		
		//Insertamos en la base de datos
		listaEJB.insertCancion(listaR);
		
		response.sendRedirect("Principal");

	}

}

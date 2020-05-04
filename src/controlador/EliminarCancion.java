package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.CancionEJB;
import ejb.SesionesEJB;

/**
 * Para poder eliminar una cancion de la base de datos
 * 
 * @author Sergio
 *
 */

@WebServlet("/EliminarCancion")
public class EliminarCancion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	CancionEJB cancionEJB;

	/**
	 * Metodo para poder borrar una cancion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCancion = request.getParameter("id");

		int id = Integer.parseInt(idCancion);

		cancionEJB.deleteCancion(id);

		response.sendRedirect("Principal");

	}

}

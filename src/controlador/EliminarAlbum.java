package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.AlbumEJB;
import ejb.SesionesEJB;

/**
 * Clase para poder borrar un album de la base de datos
 * 
 * @author Sergio
 *
 */

@WebServlet("/EliminarAlbum")
public class EliminarAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	AlbumEJB albumEJB;

	/**
	 * Este metodo es para recoger el id del album para poder borrarlo
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idAlbum = request.getParameter("id");

		int id = Integer.parseInt(idAlbum);

		albumEJB.deleteAlbum(id);
		response.sendRedirect("Principal");
	}

}

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejb.CancionEJB;
import ejb.GeneroEJB;
import ejb.SesionesEJB;
import pojo.Cancion;
import pojo.Genero;
import pojo.Usuario;

/**
 * Servlet para editar una cancion
 * 
 * @author Sergio
 *
 */
@WebServlet("/EditarCancion")
public class EditarCancion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger loggerERROR = LoggerFactory.getLogger("ERROR");

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	CancionEJB cancionEJB;

	@EJB
	GeneroEJB generoEJB;

	/**
	 * Pintar un formulario para editar los datos
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String idCancion = request.getParameter("id");

		int id = Integer.parseInt(idCancion);

		ArrayList<Genero> generos = generoEJB.getGeneros();

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EditarCancion.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		Cancion cancion = cancionEJB.getCancion(id);

		request.setAttribute("cancion", cancion);
		request.setAttribute("usuario", usuario);
		request.setAttribute("generos", generos);
		rs.forward(request, response);
	}

	/**
	 * Edita los datos de la cancion
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");

		try {
			int idCancion = Integer.parseInt(id);
			Cancion cancion = new Cancion();
			cancion.setId(idCancion);
			cancion.setTitulo(titulo);
			cancion.setGenero(genero);

			cancionEJB.updateCancion(cancion);
			response.sendRedirect("Principal");
		} catch (Exception e) {
			loggerERROR.error("No se pudo editar la cancion por motivos desconocidos");
			response.sendRedirect("Error");
		}

	}

}

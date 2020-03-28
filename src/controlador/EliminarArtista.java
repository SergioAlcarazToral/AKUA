package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.ArtistaEJB;
import ejb.SesionesEJB;

/**
 * Servlet implementation class EliminarArtista
 */
@WebServlet("/EliminarArtista")
public class EliminarArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ArtistaEJB artistaEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idArtista = request.getParameter("id");

		int id = Integer.parseInt(idArtista);

		artistaEJB.deleteArtista(id);

		response.sendRedirect("Principal");

	}

}

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

import ejb.AlbumEJB;
import ejb.ArtistaEJB;
import ejb.SesionesEJB;
import pojo.Album;
import pojo.Artista;
import pojo.Usuario;

/**
 * Servlet que se encarga de mostrar la pagina del artista con sus albumes
 * 
 * @author Sergio
 *
 */
@WebServlet("/PaginaArtista")
public class PaginaArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ArtistaEJB artistaEJB;

	@EJB
	AlbumEJB albumEJB;

	@EJB
	SesionesEJB sesionesEJB;

	/**
	 * Muestra la pagina del artista
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		String id = request.getParameter("id");
		try {
			int idArtista = Integer.parseInt(id);
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaArtista.jsp");

			Artista artista = artistaEJB.getArtista(idArtista);

			ArrayList<Album> albumes = albumEJB.getAlbumesArtista(artista.getId());

			request.setAttribute("usuario", usuario);
			request.setAttribute("artista", artista);
			request.setAttribute("albumes", albumes);
			rs.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("Principal");
		}

	}

}

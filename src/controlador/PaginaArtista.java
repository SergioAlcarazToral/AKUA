package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.AlbumEJB;
import ejb.ArtistaEJB;
import pojo.Artista;

/**
 * Servlet implementation class PaginaArtista
 */
@WebServlet("/PaginaArtista")
public class PaginaArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ArtistaEJB artistaEJB;
	
	@EJB
	AlbumEJB albumEJB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		try {
			int idArtista = Integer.parseInt(id);
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaArtista.jsp");
			
			Artista artista = artistaEJB.getArtista(idArtista);
			request.setAttribute("artista", artista);
			rs.forward(request, response);
		} catch (Exception e) {
			response.sendRedirect("Principal");
		}
		
	}

}

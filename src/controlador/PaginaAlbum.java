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
import ejb.CancionEJB;
import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import pojo.Album;
import pojo.Cancion;
import pojo.ListaReproduccion;
import pojo.Usuario;

/**
 * Servlet que se encarga de mostrar la pagina de un album
 * 
 * @author Sergio
 *
 */
@WebServlet("/PaginaAlbum")
public class PaginaAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	AlbumEJB albumEJB;

	@EJB
	CancionEJB cancionEJB;

<<<<<<< HEAD
	@EJB
	ListaReproduccionEJB listaEJB;
=======
<<<<<<< HEAD
	@EJB
	ListaReproduccionEJB listaEJB;
=======
>>>>>>> master
>>>>>>> master
	/**
	 * Muestra la pagina del album con sus respectivas canciones
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		String id = request.getParameter("id");
		try {
			int idAlbum = Integer.parseInt(id);
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaAlbum.jsp");

			Album album = albumEJB.getAlbum(idAlbum);

			ArrayList<Cancion> canciones = cancionEJB.getCancionesAlbum(idAlbum);
			ArrayList<ListaReproduccion> listas = listaEJB.getListasUsuario(usuario.getId());
			
			request.setAttribute("usuario", usuario);
			request.setAttribute("album", album);
			request.setAttribute("listas", listas);
			request.setAttribute("canciones", canciones);
			rs.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

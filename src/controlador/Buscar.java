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
import ejb.CancionEJB;
import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import ejb.UsuarioEJB;
import pojo.Album;
import pojo.Artista;
import pojo.CancionCompleta;
import pojo.ListaReproduccion;
import pojo.Usuario;

/**
 * Clase para poder hacer una busqueda en la aplicacion
 * 
 * @author Sergio
 *
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	UsuarioEJB usuarioEJB;

	@EJB
	ArtistaEJB artistaEJB;

	@EJB
	AlbumEJB albumEJB;
	
	@EJB
	CancionEJB cancionEJB;
	
	@EJB
	ListaReproduccionEJB listasEJB;
	
	/**
	 * Metodo que muestra la pagina de buscar y muestra los resultado
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Buscar.jsp");

		String buscar = request.getParameter("buscar");

		ArrayList<Artista> artistasBuscados = artistaEJB.getArtistaBuscado(buscar);
		ArrayList<Album> albumsBuscados = albumEJB.getAlbumesBuscados(buscar);
		ArrayList<CancionCompleta> cancionesBuscadas = cancionEJB.getCancionesBuscadas(buscar);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);
		ArrayList<ListaReproduccion> listas;
		if (usuario != null) {
			listas = listasEJB.getListasUsuario(usuario.getId());

			request.setAttribute("listas", listas);
		}
		request.setAttribute("artistas", artistasBuscados);
		request.setAttribute("albums", albumsBuscados);
		request.setAttribute("canciones", cancionesBuscadas);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);

	}


}

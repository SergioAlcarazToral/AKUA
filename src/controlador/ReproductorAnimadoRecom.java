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
import ejb.GeneroEJB;
import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import pojo.CancionCompleta;
import pojo.Genero;
import pojo.ListaReproduccion;
import pojo.Usuario;

/**
 * Servlet implementation class ReproductorAnimadoRecom
 */
@WebServlet("/ReproductorAnimadoRecom")
public class ReproductorAnimadoRecom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	CancionEJB cancionEJB;

	@EJB
	ListaReproduccionEJB listaEJB;

	@EJB
	GeneroEJB generoEJB;

	@EJB
	AlbumEJB albumEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		String nombre = request.getParameter("nombre");
		try {
			RequestDispatcher rs = getServletContext().getRequestDispatcher("/PaginaReproductorRecom.jsp");

			ArrayList<CancionCompleta> canciones = cancionEJB.getCancionesGenero(nombre);
			Genero genero = new Genero();
			genero.setNombre(nombre);
			
			request.setAttribute("usuario", usuario);

			ArrayList<ListaReproduccion> listas = listaEJB.getListasUsuario(usuario.getId());
			request.setAttribute("listas", listas);

			request.setAttribute("canciones", canciones);
			request.setAttribute("genero", genero);
			rs.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

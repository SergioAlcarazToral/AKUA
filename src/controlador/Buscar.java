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

import ejb.ArtistaEJB;
import ejb.SesionesEJB;
import ejb.UsuarioEJB;
import pojo.Artista;
import pojo.Usuario;

/**
 * Servlet implementation class Buscar
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Buscar.jsp");

		String artistas = request.getParameter("buscar");
		
		ArrayList<Artista> artistasBuscados = artistaEJB.getArtistaBuscado(artistas);
		
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		request.setAttribute("artistas", artistasBuscados);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

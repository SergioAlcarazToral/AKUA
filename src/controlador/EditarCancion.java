package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.CancionEJB;
import ejb.SesionesEJB;
import pojo.Cancion;
import pojo.Usuario;

/**
 * Servlet implementation class EditarCancion
 */
@WebServlet("/EditarCancion")
public class EditarCancion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;
	
	@EJB
	CancionEJB cancionEJB;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String idCancion = request.getParameter("id");

		int id = Integer.parseInt(idCancion);
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EditarAlbum.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		Cancion cancion = cancionEJB.getCancion(id);
		
		request.setAttribute("genero", cancion);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		
		try {
			Cancion cancion = new Cancion();
			 cancion.setTitulo(titulo);
			 cancion.setGenero(genero);
			 
			 cancionEJB.updateCancion(cancion);
			 response.sendRedirect("Principal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

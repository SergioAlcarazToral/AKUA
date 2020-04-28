package controlador;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
<<<<<<< HEAD
import java.util.ArrayList;
=======
<<<<<<< HEAD
import java.util.ArrayList;
=======
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.CancionEJB;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
>>>>>>> master
import ejb.GeneroEJB;
import ejb.SesionesEJB;
import pojo.Cancion;
import pojo.Genero;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
import ejb.SesionesEJB;
import pojo.Cancion;
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
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
	
<<<<<<< HEAD
	@EJB
	GeneroEJB generoEJB;
	
=======
<<<<<<< HEAD
	@EJB
	GeneroEJB generoEJB;
	
=======
<<<<<<< HEAD
	@EJB
	GeneroEJB generoEJB;
	
=======
<<<<<<< HEAD
	@EJB
	GeneroEJB generoEJB;
	
=======
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String idCancion = request.getParameter("id");

		int id = Integer.parseInt(idCancion);
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
>>>>>>> master

		ArrayList<Genero> generos = generoEJB.getGeneros();
		
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EditarCancion.jsp");
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EditarAlbum.jsp");
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		Cancion cancion = cancionEJB.getCancion(id);
		
<<<<<<< HEAD
		request.setAttribute("cancion", cancion);
		request.setAttribute("usuario", usuario);
		request.setAttribute("generos", generos);
=======
<<<<<<< HEAD
		request.setAttribute("cancion", cancion);
		request.setAttribute("usuario", usuario);
		request.setAttribute("generos", generos);
=======
<<<<<<< HEAD
		request.setAttribute("cancion", cancion);
		request.setAttribute("usuario", usuario);
		request.setAttribute("generos", generos);
=======
<<<<<<< HEAD
		request.setAttribute("cancion", cancion);
		request.setAttribute("usuario", usuario);
		request.setAttribute("generos", generos);
=======
		request.setAttribute("genero", cancion);
		request.setAttribute("usuario", usuario);
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
		rs.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		
<<<<<<< HEAD
		String id = request.getParameter("id");
=======
<<<<<<< HEAD
		String id = request.getParameter("id");
=======
<<<<<<< HEAD
		String id = request.getParameter("id");
=======
<<<<<<< HEAD
		String id = request.getParameter("id");
=======
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		
		try {
<<<<<<< HEAD
			int idCancion = Integer.parseInt(id);
			Cancion cancion = new Cancion();
			cancion.setId(idCancion);
=======
<<<<<<< HEAD
			int idCancion = Integer.parseInt(id);
			Cancion cancion = new Cancion();
			cancion.setId(idCancion);
=======
<<<<<<< HEAD
			int idCancion = Integer.parseInt(id);
			Cancion cancion = new Cancion();
			cancion.setId(idCancion);
=======
<<<<<<< HEAD
			int idCancion = Integer.parseInt(id);
			Cancion cancion = new Cancion();
			cancion.setId(idCancion);
=======
			Cancion cancion = new Cancion();
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
			 cancion.setTitulo(titulo);
			 cancion.setGenero(genero);
			 
			 cancionEJB.updateCancion(cancion);
			 response.sendRedirect("Principal");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

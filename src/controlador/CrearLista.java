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

import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import pojo.ListaReproduccion;
import pojo.Usuario;

/**
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
 * Servlet para poder crear una lista de reproduccion
 * 
 * @author Sergio
 *
<<<<<<< HEAD
=======
=======
 * Servlet implementation class CrearLista
>>>>>>> master
>>>>>>> master
 */
@WebServlet("/CrearLista")
public class CrearLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master

	@EJB
	ListaReproduccionEJB listaEJB;

<<<<<<< HEAD
=======
=======
	
	@EJB
	ListaReproduccionEJB listaEJB;
>>>>>>> master
>>>>>>> master
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
		
>>>>>>> master
>>>>>>> master
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearLista.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master

		String nombreLista = request.getParameter("nombre");
		String id = request.getParameter("id");

		int idUsuario = Integer.parseInt(id);

<<<<<<< HEAD
=======
=======
		
		String nombreLista = request.getParameter("nombre");
		String id = request.getParameter("id");
		
		int idUsuario = Integer.parseInt(id);
		
>>>>>>> master
>>>>>>> master
		ListaReproduccion lr = new ListaReproduccion();
		lr.setNombre(nombreLista);
		lr.setIdUsuario(idUsuario);
		listaEJB.insertListaR(lr);
<<<<<<< HEAD

		response.sendRedirect("Principal");

=======
<<<<<<< HEAD

		response.sendRedirect("Principal");

=======
	
		response.sendRedirect("Principal");
		
>>>>>>> master
>>>>>>> master
	}

}

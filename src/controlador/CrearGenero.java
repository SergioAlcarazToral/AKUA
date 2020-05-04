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

import ejb.GeneroEJB;
import ejb.SesionesEJB;
import pojo.Genero;
import pojo.Usuario;


/**
 * Servlet para poder insertar un genero en la base de datos
 * @author Sergio
 *
 */
@WebServlet("/CrearGenero")
public class CrearGenero extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	GeneroEJB generoEJB;

	/**
	 * Este metodo es para poder pintar el formulario para poder crear un genero
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearGenero.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		
		Genero genero = new Genero();
		
		genero.setNombre(nombre);
		
		generoEJB.insertGenero(genero);
		
		response.sendRedirect("Principal");

	}

}

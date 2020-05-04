package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Pagina que te muestra que el usuario se ha registrado correctamente
 * 
 * @author Sergio
 *
 */
@WebServlet("/InfoRegistro")
public class InfoRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Muestra la pagina de informacion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/InfoRegistro.jsp");

		rs.forward(request, response);
	}
}

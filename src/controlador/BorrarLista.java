package controlador;

import java.io.IOException;

import javax.ejb.EJB;
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
 * Servlet para poder borrar una lista de reproduccion de la base de datos
 * 
 * @author Sergio
 *
 */
@WebServlet("/BorrarLista")
public class BorrarLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;
	
	@EJB
	ListaReproduccionEJB listaEJB;
	
	/**
	 * Para poder borrar una lista de reproduccion de la base de datos
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		//Parametros necesarios 
		String nombreLista = request.getParameter("nombre");
		String id = request.getParameter("id");
		
		//Transformamos los datos necesarios a int
		int idUsuario = Integer.parseInt(id);
		
		//Creamos un objeto lista
		ListaReproduccion lr = new ListaReproduccion();
		
		//Añadimos los datos
		lr.setNombre(nombreLista);
		lr.setIdUsuario(idUsuario);
		
		//Borramos la lista
		listaEJB.deleteListaR(lr);
	
		response.sendRedirect("Principal");
		
	}

}

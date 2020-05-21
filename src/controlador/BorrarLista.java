package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	Logger loggerERROR = LoggerFactory.getLogger("ERROR");

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
		try {
			//Parametros necesarios 
			String nombreLista = request.getParameter("nombre");
			
			//Transformamos los datos necesarios a int
			
			//Creamos un objeto lista
			ListaReproduccion lr = new ListaReproduccion();
			
			//Añadimos los datos
			lr.setNombre(nombreLista);
			lr.setIdUsuario(usuario.getId());
			
			//Borramos la lista
			listaEJB.deleteListaR(lr);
		
			response.sendRedirect("Principal");
		} catch (Exception e) {
			loggerERROR.error("No se ha podido eliminar una lista de un usuario");
			response.sendRedirect("Error");
		}
		
		
	}

}

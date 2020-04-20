package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.ListaReproduccionEJB;
import ejb.SesionesEJB;
import pojo.ListaReproduccion;

/**
 * Servlet implementation class AgregarCancionLista
 */
@WebServlet("/AgregarCancionLista")
public class AgregarCancionLista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ListaReproduccionEJB listaEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idCancion = request.getParameter("idCancion");
		String idUsuario = request.getParameter("idUsuario");
		String lista = request.getParameter("lista");

		ListaReproduccion listaR = new ListaReproduccion();

		listaR.setNombre(lista);
		Integer idSong = Integer.parseInt(idCancion);
		
		Integer idUser = Integer.parseInt(idUsuario);
		listaR.setIdUsuario(idUser);
		listaR.setIdCancion(idSong);

		listaEJB.insertCancion(listaR);

	}

}

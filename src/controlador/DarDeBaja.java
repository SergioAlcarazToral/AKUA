package controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.SesionesEJB;
import ejb.UsuarioEJB;
import pojo.Usuario;

/**
 * Servlet implementation class DarDeBaja
 */
@WebServlet("/DarDeBaja")
public class DarDeBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SesionesEJB sesionesEJB;
	
	@EJB
	UsuarioEJB usuarioEJB;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Usuario usuario = sesionesEJB.usuarioLogeado(session);
		try {
			usuarioEJB.deleteUsuario(usuario.getId());
		} catch (Exception e) {
			e.printStackTrace();
			//Poner el logger aqui
		}
		sesionesEJB.logoutUsuario(session);
		response.sendRedirect("Principal");
		
	}

}

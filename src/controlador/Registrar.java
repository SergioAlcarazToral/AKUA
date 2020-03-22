package controlador;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ejb.UsuarioEJB;
import pojo.Usuario;

/**
 * Servlet implementation class Registrar
 */
@WebServlet("/Registrar")
public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "Imatges";

	@EJB
	UsuarioEJB usuarioEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("Registrar.jsp");

		rs.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtenemos una ruta en el servidor para guardar el archivo, en este caso la
		// foto del usuario
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		response.setContentType("text/html; charset=UTF-8");

		// Si la ruta no existe la creamos
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Esta variable sera para guardar el nombre del archivo
		String foto = null;

		// Los paramoetros necesarios para poder insertar un usuario
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String pass = request.getParameter("pass");

		Part partFoto = request.getPart("foto");

		// En el caso de que el usuario no ponga foto de perfil se le asignara una ya
		// predefinida por el sistema

		try {
			String strFoto = partFoto.getHeader("content-disposition");
			strFoto = strFoto.substring(strFoto.lastIndexOf("filename"));
			foto = strFoto.substring(strFoto.indexOf('=') + 2, strFoto.lastIndexOf("\""));
			partFoto.write(uploadPath + File.separator + foto);
		} catch (Exception e) {
			foto = "sinImagen.jpg";
		}

		// Los datos necesarios para poder añadir el usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setCorreo(correo);
		usuario.setPass(pass);
		usuario.setFoto(foto);

		// Registramos el usuario en la base de datos
		usuarioEJB.insertUsuario(usuario);

		// Mostramos la pagina de inicio

		// RequestDispatcher rs =
		// getServletContext().getRequestDispatcher("/PaginaInfoMail.jsp");
		// rs.forward(request, response);
	}

}

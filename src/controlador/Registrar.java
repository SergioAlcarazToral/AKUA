package controlador;

import java.io.File;
import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejb.UsuarioEJB;
import pojo.Usuario;

/**
 * Servlet que se encarga de registrar usuarios en la base de datos
 * 
 * @author Sergio
 *
 */
@WebServlet("/Registrar")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class Registrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "Imatges";
	Logger loggerERROR = LoggerFactory.getLogger("ERROR");

	@EJB
	UsuarioEJB usuarioEJB;

	/**
	 * Muestra la pagian de registro
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/Registrar.jsp");

		rs.forward(request, response);
	}

	/**
	 * Inserta el usuario en la base de datos con los datos que ha recogido
	 */
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

		// Lo utilizaremos para guardar el nombre del archivo
		String foto = null;

		// Los paramoetros necesarios para poder insertar un usuario
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String pass = request.getParameter("pass");

		// En el caso de que el usuario no ponga foto de perfil se le asignara una ya
		// predefinida por el sistema

		try {
			Part partFoto = request.getPart("foto");

			String strFoto = partFoto.getHeader("content-disposition");
			strFoto = strFoto.substring(strFoto.lastIndexOf("filename"));
			foto = strFoto.substring(strFoto.indexOf('=') + 2, strFoto.lastIndexOf("\""));
			partFoto.write(uploadPath + File.separator + foto);
		} catch (Exception e) {
			foto = "sinImagen.jpg";
		}

		// Los datos necesarios para poder a�adir el usuario
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setCorreo(correo);
		usuario.setPass(pass);
		usuario.setFoto(foto);
		// Registramos el usuario en la base de datos
		try {
			usuarioEJB.insertUsuario(usuario);
			response.sendRedirect("InfoRegistro");
		} catch (Exception e) {
			loggerERROR.error("Los datos introducidos ya existen");
			response.sendRedirect("Registrar");
		}
		
		
	}

}

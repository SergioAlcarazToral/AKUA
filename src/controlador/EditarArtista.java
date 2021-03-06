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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ejb.ArtistaEJB;
import ejb.SesionesEJB;
import pojo.Album;
import pojo.Artista;
import pojo.Usuario;

/**
 * Servlet para poder editar un album de la base de datos
 * 
 * @author Sergio
 *
 */
@WebServlet("/EditarArtista")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class EditarArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "ImgArtistas";
	Logger loggerERROR = LoggerFactory.getLogger("ERROR");

	@EJB
	ArtistaEJB artistaEJB;

	@EJB
	SesionesEJB sesionesEJB;

	/**
	 * Muestra la pagina para poder editar un album
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String idAlbum = request.getParameter("id");

		int id = Integer.parseInt(idAlbum);
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EditarArtista.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		Artista artista = artistaEJB.getArtista(id);
		request.setAttribute("artista", artista);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
	}

	/**
	 * Coge los datos y los edita en la base de datos al album que corresponde
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		response.setContentType("text/html; charset=UTF-8");

		// Si la ruta no existe la creamos
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Lo utilizaremos para guardar el nombre del archivo
		String foto = null;

		// Los parametros necesarios para poder insertar un artista en la base de datos

		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");

		// En el caso de que el usuario no ponga foto de perfil se le asignara una ya
		// predefinida por el sistema
		Part partFoto = request.getPart("foto");

		try {
			String strFoto = partFoto.getHeader("content-disposition");
			strFoto = strFoto.substring(strFoto.lastIndexOf("filename"));
			foto = strFoto.substring(strFoto.indexOf('=') + 2, strFoto.lastIndexOf("\""));
			partFoto.write(uploadPath + File.separator + foto);
		} catch (Exception e) {
			foto = "sinImagen.jpg";
		}

		try {
			int idArtista = Integer.parseInt(id);

			Artista artista = new Artista();

			artista.setId(idArtista);
			artista.setNombre(nombre);
			artista.setFoto(foto);

			artistaEJB.updateArtista(artista);

			response.sendRedirect("Principal");
		} catch (Exception e) {
			loggerERROR.error("No se pudo editar el artista por razones desconocidas");
			response.sendRedirect("Error");
		}

	}

}

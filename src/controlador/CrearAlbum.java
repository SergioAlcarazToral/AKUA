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

import ejb.AlbumEJB;
import ejb.ArtistaEJB;
import ejb.SesionesEJB;
import pojo.Album;
import pojo.Artista;
import pojo.Usuario;

/**
 * Servlet para poder crear un album y añadirlo a la base de datos
 * 
 * @author Sergio
 *
 */
@WebServlet("/CrearAlbum")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class CrearAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "ImgAlbums";
	Logger loggerERROR = LoggerFactory.getLogger("ERROR");

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ArtistaEJB artistaEJB;

	@EJB
	AlbumEJB albumEJB;

	/**
	 * Para poder mostrar el formulario para poder crear un album
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		String idArtista = request.getParameter("id");

		int id = Integer.parseInt(idArtista);
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearAlbum.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		Artista artista = artistaEJB.getArtista(id);

		request.setAttribute("idArtista", artista);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
	}

	/**
	 * Insertar el album en la base de datos
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
		String nombre = request.getParameter("nombre");
		String anyo = request.getParameter("anyo");
		String idArtista = request.getParameter("idArtista");
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
			int anyoAlbum = Integer.parseInt(anyo);

			Album album = new Album();

			album.setNombre(nombre);
			album.setAnyo(anyoAlbum);
			album.setIdArtista(idArtista);
			album.setFoto(foto);

			albumEJB.insertAlbum(album);

			response.sendRedirect("Principal");
		} catch (Exception e) {
			loggerERROR.error("Error al crear el album para el artista deseado");
			response.sendRedirect("CrearAlbum?id=" + idArtista);
		}

	}

}

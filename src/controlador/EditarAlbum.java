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

import ejb.AlbumEJB;
import ejb.SesionesEJB;
import pojo.Album;
import pojo.Usuario;

/**
 * Servlet para poder editar un album de la base de datos
 * 
 * @author Sergio
 *
 */
@WebServlet("/EditarAlbum")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class EditarAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "ImgAlbums";

	@EJB
	AlbumEJB albumEJB;

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

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/EditarAlbum.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		Album album = albumEJB.getAlbum(id);
		request.setAttribute("album", album);
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
		String anyo = request.getParameter("anyo");

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
			int idAlbum = Integer.parseInt(id);
			int anyoAlbum = Integer.parseInt(anyo);

			Album album = new Album();

			album.setId(idAlbum);
			album.setNombre(nombre);
			album.setAnyo(anyoAlbum);
			album.setFoto(foto);

			albumEJB.updateAlbum(album);

			response.sendRedirect("Principal");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

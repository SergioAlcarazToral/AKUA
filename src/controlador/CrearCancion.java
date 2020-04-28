package controlador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejb.AlbumEJB;
import ejb.CancionEJB;
import ejb.GeneroEJB;
import ejb.SesionesEJB;
import pojo.Album;
import pojo.Cancion;
import pojo.Genero;
import pojo.Usuario;

/**
 * Servlet para poder insertar una cancion en la base de datos
 * 
 * @author Sergio
 *
 */
@WebServlet("/CrearCancion")
@MultipartConfig(maxFileSize = 2048 * 2048 * 5)

public class CrearCancion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "ArchivosMusica";

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	AlbumEJB albumEJB;

	@EJB
	CancionEJB cancionEJB;

	@EJB
	GeneroEJB generoEJB;

	/**
	 * Muestra un formulario con los requisitos para insertar una cancion
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String idArtista = request.getParameter("id");

		int id = Integer.parseInt(idArtista);
		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearCancion.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		Album album = albumEJB.getAlbum(id);

		ArrayList<Genero> generos = generoEJB.getGeneros();

		request.setAttribute("generos", generos);
		request.setAttribute("idAlbum", album);
		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
	}

	/**
	 * Realiza todas las acciones necesarias como guardar la cancion en disco y
	 * insertar los datos en la base de datos
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

		String archivo = null;

		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String album = request.getParameter("idAlbum");
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
		Part partArchivo = request.getPart("archivo");

		try {
			String strArchivo = partArchivo.getHeader("content-disposition");
			strArchivo = strArchivo.substring(strArchivo.lastIndexOf("filename"));
			archivo = strArchivo.substring(strArchivo.indexOf('=') + 2, strArchivo.lastIndexOf("\""));
			partArchivo.write(uploadPath + File.separator + archivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
		String archivo = request.getParameter("archivo");

		Path archivoRuta = Paths.get("D:\\" + archivo);
		Path ruta = Paths.get(uploadPath + "\\" + archivo);

		Files.move(archivoRuta, ruta, StandardCopyOption.ATOMIC_MOVE);
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master
>>>>>>> master

		if (titulo != null){
			Cancion cancion = new Cancion();

			cancion.setTitulo(titulo);
			cancion.setGenero(genero);
			cancion.setAlbum(album);
			cancion.setArchivo(archivo);

			cancionEJB.insertCancion(cancion);
		}

		response.sendRedirect("Principal");
	}

}

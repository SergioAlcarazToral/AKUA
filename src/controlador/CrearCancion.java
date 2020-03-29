package controlador;

import java.io.File;
import java.io.IOException;
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
import javax.servlet.http.Part;

import ejb.AlbumEJB;
import ejb.CancionEJB;
import ejb.GeneroEJB;
import ejb.SesionesEJB;
import pojo.Album;
import pojo.Cancion;
import pojo.Genero;
import pojo.Usuario;

@WebServlet("/CrearCancion")
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		response.setContentType("text/html; charset=UTF-8");

		// Los parametros necesarios para poder insertar un artista en la base de datos

		// Si la ruta no existe la creamos
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String artista = request.getParameter("idArtista");
		String album = request.getParameter("idAlbum");
		String archivo = request.getParameter("archivo");



		if (titulo != null) {
			Cancion cancion = new Cancion();

			cancion.setTitulo(titulo);
			cancion.setGenero(genero);
			cancion.setAlbum(album);
			cancion.setArchivo(archivo);
			cancion.setArtista(artista);

			cancionEJB.insertCancion(cancion);
		}

	}

}
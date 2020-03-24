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

import ejb.ArtistaEJB;
import ejb.SesionesEJB;
import pojo.Artista;
import pojo.Usuario;

@WebServlet("/CrearArtista")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5)

public class CrearArtista extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "ImgArtistas";

	@EJB
	SesionesEJB sesionesEJB;

	@EJB
	ArtistaEJB artistaEJB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		response.setContentType("text/html; charset=UTF-8");

		RequestDispatcher rs = getServletContext().getRequestDispatcher("/CrearArtista.jsp");

		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		request.setAttribute("usuario", usuario);
		rs.forward(request, response);
	}

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

		//Los datos necesarios para poder añadir el artista
		Artista artista = new Artista();
		artista.setNombre(nombre);
		artista.setFoto(foto);
		
		artistaEJB.insertArtista(artista);
		response.sendRedirect("Principal");
		
	}

}

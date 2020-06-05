package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CancionDAO;
import pojo.Cancion;
import pojo.CancionCompleta;

/**
 * EJB con todas las operaciones que podemos realizar
 * 
 * @author Sergio
 *
 */
@Stateless
@LocalBean
public class CancionEJB {

	/**
	 * Obtener una cancion
	 * 
	 * @param id Id de la cancion
	 * @return cancion
	 */
	public Cancion getCancion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancion(id);
	}

	/**
	 * Obtener todas las canciones
	 * 
	 * @return canciones
	 */
	public ArrayList<Cancion> getCanciones() {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCanciones();
	}

	/**
	 * Obtener canciones buscadas con un parametro anteriormente
	 * 
	 * @param titulo Parametro
	 * @return canciones
	 */
	public ArrayList<CancionCompleta> getCancionesBuscadas(String titulo) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesBuscadas(titulo);
	}

	/**
	 * Obtener canciones aleatorias
	 * 
	 * @return canciones
	 */
	public ArrayList<Cancion> getCancionesRecom() {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesRecom();
	}

	/**
	 * Obtener canciones de un album
	 * 
	 * @param id Id album
	 * @return canciones
	 */
	public ArrayList<Cancion> getCancionesAlbum(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesAlbum(id);
	}

	/**
	 * Obtener las canciones de una lista
	 * 
	 * @param id Id usuario
	 * @return canciones
	 */
	public ArrayList<Cancion> getCancionesLista(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesLista(id);
	}

	/**
	 * Obtener canciones con todos los datos de una lista
	 * 
	 * @param id Id Usuario
	 * @return canciones
	 */
	public ArrayList<CancionCompleta> getCancionesCompletasLista(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesCompletasLista(id);
	}

	/**
	 * Obtener canciones aleatorias por genero
	 * 
	 * @param nombre Genero
	 * @return canciones
	 */
	public ArrayList<CancionCompleta> getCancionesGenero(String nombre) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesGenero(nombre);
	}

	/**
	 * Obtener canciones con todos los datos de un album
	 * 
	 * @param id Id del album
	 * @return canciones
	 */
	public ArrayList<CancionCompleta> getCancionesCompletasAlbum(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesCompletasAlbum(id);
	}

	/**
	 * Insertar una cancion en la base de datos
	 * 
	 * @param cancion La cancion que queremos insertar
	 */
	public void insertCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.insertCancion(cancion);
	}

	/**
	 * Editar una cancion
	 * 
	 * @param cancion La cancion que queremos editar
	 */
	public void updateCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.updateCancion(cancion);
	}

	/**
	 * Eliminar una cancion
	 * 
	 * @param id Id de la cancion que queremos editar
	 */
	public void deleteCancion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.deleteCancion(id);
	}

}

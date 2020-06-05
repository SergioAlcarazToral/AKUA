package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.ArtistaDAO;
import pojo.Artista;

/**
 * EJB con todas las operaciones con los artistas
 * 
 * @author Sergio
 *
 */
@Stateless
@LocalBean
public class ArtistaEJB {

	/**
	 * Obtener todos los artistas
	 * 
	 * @return artistas
	 */
	public ArrayList<Artista> getArtistas() {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtistas();
	}

	/**
	 * Obtener artistas aleatorios
	 * 
	 * @return artistas aleatorios
	 */
	public ArrayList<Artista> getArtistasRandom() {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtistasRandom();
	}

	/**
	 * Obtener un artista en concreto
	 * 
	 * @param id Id del artista
	 * @return artista
	 */
	public Artista getArtista(int id) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtista(id);
	}

	/**
	 * Obtener todos los artistas con el parametro buscado anteriormente
	 * 
	 * @param nombre Parametro
	 * @return artistas
	 */
	public ArrayList<Artista> getArtistaBuscado(String nombre) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtistaBuscado(nombre);
	}

	/**
	 * Insertar un artista en la base de datos
	 * 
	 * @param artista El artista que queremos insertar
	 */
	public void insertArtista(Artista artista) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.insertArtista(artista);
	}

	/**
	 * Editar un artista
	 * 
	 * @param artista El artista que queremos editar
	 */
	public void updateArtista(Artista artista) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.updateArtista(artista);
	}

	/**
	 * Borrar un artista
	 * 
	 * @param id Id del artista que queremos borrar
	 */
	public void deleteArtista(int id) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.deleteArtista(id);
	}

}

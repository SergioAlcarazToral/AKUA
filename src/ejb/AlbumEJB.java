package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.AlbumDAO;
import pojo.Album;

/**
 * EJB relacionado con los albums
 * 
 * @author Sergio
 *
 */
@Stateless
@LocalBean
public class AlbumEJB {

	/**
	 * Obtener todos los albums
	 * 
	 * @return albums
	 */
	public ArrayList<Album> getAlbumes() {
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbumes();
	}

	/**
	 * Obtener los albums buscados por su nombre
	 * 
	 * @param nombre Nombre del album
	 * @return albums buscados
	 */
	public ArrayList<Album> getAlbumesBuscados(String nombre) {
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbumesBuscados(nombre);
	}

	/**
	 * Obtener todos los albums de un artista
	 * 
	 * @param id Id del artista
	 * @return albums del artista
	 */
	public ArrayList<Album> getAlbumesArtista(int id) {
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbumesArtista(id);
	}

	/**
	 * Obtener un album en concreto por su id
	 * 
	 * @param id Id del album
	 * @return album
	 */
	public Album getAlbum(int id) {
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbum(id);
	}

	/**
	 * Insertar un album en la base de datos
	 * 
	 * @param album El album que queremos insertar
	 */
	public void insertAlbum(Album album) {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.insertAlbum(album);
	}

	/**
	 * Editar un album
	 * 
	 * @param album El album que queremos editar
	 */
	public void updateAlbum(Album album) {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.updateAlbum(album);
	}

	/**
	 * Borrar un album de un artista
	 * 
	 * @param id Id del album
	 */
	public void deleteAlbum(int id) {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.deleteAlbum(id);
	}

}

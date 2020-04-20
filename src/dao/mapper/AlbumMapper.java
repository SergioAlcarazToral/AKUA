package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Album;

public interface AlbumMapper {

	/**
	 * Para obtener todos los posibles resultados de la busqueda
	 * 
	 * @param nombre lo que quiere buscarse
	 * @return el resultado de la busqueda
	 */
	public ArrayList<Album> getAlbumesBuscados(@Param("nombre") String nombre);

	/**
	 * Para poder obtener un album en concreto
	 * 
	 * @param id el id del album que queremos
	 * @return el album
	 */
	public Album getAlbum(@Param("id") int id);

	/**
	 * Para obtener todos los albumes de la base de datos
	 * 
	 * @return todos los albums
	 */
	public ArrayList<Album> getAlbumes();

	/**
	 * Para obtener todos los albumes de un artista
	 * 
	 * @param id el id del artista
	 * @return los albumes
	 */
	public ArrayList<Album> getAlbumesArtista(@Param("id") int id);

	/**
	 * Este metodo es para poder insertar una cancion en la base de datos
	 * 
	 * @param cancion la cancion que queremos insertar
	 */
	public void insertAlbum(Album album);

	/**
	 * Para poder actualizar los datos de una cancion
	 * 
	 * @param cancion la cancion que vamos a actualizar
	 */
	public void updateAlbum(Album album);

	/**
	 * Elimina un usuario en base de datos
	 * 
	 * @param id El identificador del usuario
	 */
	public void deleteAlbum(@Param("id") int id);
}
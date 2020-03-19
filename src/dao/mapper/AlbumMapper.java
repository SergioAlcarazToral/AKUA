package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Album;

public interface AlbumMapper {

	/**
	 * Obtiene un listado de todas las canciones
	 * 
	 * @return las canciones
	 */
	public ArrayList<Album> getAlbum(@Param("nombre") String nombre);
	
	public ArrayList<Album> getAlbumes();

	/**
	 * Este metodo es para poder insertar una cancion en la base de datos
	 * 
	 * @param cancion la cancion que queremos insertar
	 */
	public void insertALbum(Album album);

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
	public void deleteAlbum(Album album);
}
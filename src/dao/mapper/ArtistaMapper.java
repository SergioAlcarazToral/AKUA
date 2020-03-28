package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Artista;

public interface ArtistaMapper {

	/**
	 * Obtiene un listado de todas las canciones
	 * 
	 * @return las canciones
	 */
	public ArrayList<Artista> getArtistas();

	public Artista getArtista(@Param("id") int id);
	
	public ArrayList<Artista> getArtistaBuscado(@Param("nombreArtista") String nombre);
	
	/**
	 * Este metodo es para poder insertar una cancion en la base de datos
	 * 
	 * @param cancion la cancion que queremos insertar
	 */
	public void insertArtista(Artista artista);

	/**
	 * Para poder actualizar los datos de una cancion
	 * 
	 * @param cancion la cancion que vamos a actualizar
	 */
	public void updateArtista(Artista artista);

	/**
	 * Elimina un usuario en base de datos
	 * 
	 * @param id El identificador del usuario
	 */
	public void deleteArtista(@Param("idArtista") int id);
}
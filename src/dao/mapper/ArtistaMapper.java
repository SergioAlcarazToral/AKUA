package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Artista;

public interface ArtistaMapper {

	/**
	 * Para obtener todos los artistas de la base de datos
	 * 
	 * @return todos los artistas
	 */
	public ArrayList<Artista> getArtistas();

	/**
	 * Para obtener un artista
	 * 
	 * @param id el id del artista
	 * @return el artista
	 */
	public Artista getArtista(@Param("id") int id);

	/**
	 * Para obtener los resultados de la busqueda
	 * 
	 * @param nombre lo que se quiere buscar
	 * @return el resultado de la busqueda
	 */
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
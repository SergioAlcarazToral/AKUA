package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Artista;

/**
 * Mapper con todas las operaciones relacionadas con los artistas
 * 
 * @author Sergio
 *
 */
public interface ArtistaMapper {

	/**
	 * Para obtener todos los artistas de la base de datos
	 * 
	 * @return todos los artistas
	 */
	public ArrayList<Artista> getArtistas();

	/**
	 * Obtener artistas aleatorios
	 * 
	 * @return artistas
	 */
	public ArrayList<Artista> getArtistasRandom();

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
	 * Este metodo es para poder insertar un artista en la base de datos
	 * 
	 * @param cancion la cancion que queremos insertar
	 */
	public void insertArtista(Artista artista);

	/**
	 * Para poder actualizar los datos de un artista
	 * 
	 * @param cancion el artista que vamos a actualizar
	 */
	public void updateArtista(Artista artista);

	/**
	 * Elimina un artista en base de datos
	 * 
	 * @param id El identificador del artista
	 */
	public void deleteArtista(@Param("idArtista") int id);
}
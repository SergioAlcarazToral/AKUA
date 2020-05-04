package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Cancion;

public interface CancionMapper {

	/**
	 * Para poder comprobar si una cancion existe
	 * 
	 * @param id el id por el que filtrasemos
	 * @return la cancion
	 */
	public Cancion existeCancion(@Param("id") int id);

	public ArrayList<Cancion> getCancionesLista(@Param("idUsuario") int id);
	
	/**
	 * Para poder obtener una cancion a con un id
	 * 
	 * @param id el id por el que filtramos
	 * @return la cancion
	 */
	public Cancion getCancion(@Param("id") int id);

	/**
	 * Obtiene un listado de todas las canciones
	 * 
	 * @return las canciones
	 */
	public ArrayList<Cancion> getCanciones();

	/**
	 * Obtiene un listado de canciones aleatorias de la base de datos para que
	 * cuando las muestre se le recomienden canciones al usuario
	 * 
	 * @return El listado de las canciones aleatorias
	 */
	public ArrayList<Cancion> getCancionesRecom();

	/**
	 * Para poder obtener todas las canciones de un album
	 * 
	 * @param id el id del album
	 * @return todas las canciones del album
	 */
	public ArrayList<Cancion> getCancionesAlbum(@Param("id") int id);

	/**
	 * Este metodo es para poder insertar una cancion en la base de datos
	 * 
	 * @param cancion la cancion que queremos insertar
	 */
	public void insertCancion(Cancion cancion);

	public ArrayList<Cancion> getCancionesGenero(@Param("nombre") String nombre);
	
	/**
	 * Para poder actualizar los datos de una cancion
	 * 
	 * @param cancion la cancion que vamos a actualizar
	 */
	public void updateCancion(Cancion cancion);

	/**
	 * Elimina un usuario en base de datos
	 * 
	 * @param id El identificador del usuario
	 */
	public void deleteCancion(@Param("id") int id);
}
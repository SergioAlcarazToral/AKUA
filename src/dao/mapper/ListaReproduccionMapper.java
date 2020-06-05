package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.ListaReproduccion;

/**
 * Mapper en el cual estan todas las operaciones relacionadas con las listas
 * 
 * @author Sergio
 *
 */
public interface ListaReproduccionMapper {

	/**
	 * Obtiene un listado de todas las listas
	 * 
	 * @return las canciones
	 */
	public ArrayList<ListaReproduccion> getListasR();

	/**
	 * Para poder obtener todas las listas de un usuario
	 * 
	 * @param id id del usuario
	 * @return las listas
	 */
	public ArrayList<ListaReproduccion> getListasUsuario(@Param("idUsuario") int id);

	/**
	 * Obtener una lista en concreto
	 * 
	 * @param idUsuario Id del usuario
	 * @param nombre    nombre de la lista
	 * @return la lista
	 */
	public ListaReproduccion getLista(@Param("idUsuario") int idUsuario, @Param("nombre") String nombre);

	/**
	 * Para poder insertar una lista en la base de datos
	 * 
	 * @param listaReproduccion la lista que queremos insertar
	 */
	public void insertListaR(ListaReproduccion listaReproduccion);

	/**
	 * Para poder insertar una cancion en una lista
	 * 
	 * @param listaReproduccion la cancion
	 */
	public void insertCancion(ListaReproduccion listaReproduccion);

	/**
	 * Para poder editar una lista en la base de datos
	 * 
	 * @param listaReproduccion la lista que queremos editar
	 */
	public void updateListaR(ListaReproduccion listaReproduccion);

	/**
	 * Para eliminar una lista de la base de datos
	 * 
	 * @param listaReproduccion la lista que queremos eliminar
	 */
	public void deleteListaR(ListaReproduccion listaReproduccion);

	/**
	 * Para poder eliminar todas las listas de un usuario
	 * 
	 * @param idUsuario id del usuario
	 */
	public void deleteListasUsuario(@Param("idUsuario") int idUsuario);

	/**
	 * Borrar una cancion de una lista
	 * 
	 * @param listaReproduccion lista
	 */
	public void deleteCancionLista(ListaReproduccion listaReproduccion);

}

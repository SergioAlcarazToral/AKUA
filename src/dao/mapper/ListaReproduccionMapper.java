package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.ListaReproduccion;

public interface ListaReproduccionMapper {

	/**
	 * Obtiene un listado de todas las canciones
	 * 
	 * @return las canciones
	 */
	public ArrayList<ListaReproduccion> getListasR();

	public ArrayList<ListaReproduccion> getListasUsuario(@Param("idUsuario") int id);

	
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

	public void deleteListasUsuario (@Param("idUsuario") int idUsuario);
	/**
	 * 
	 * @param listaReproduccion
	 */
	public void deleteCancionLista(ListaReproduccion listaReproduccion);
	
}


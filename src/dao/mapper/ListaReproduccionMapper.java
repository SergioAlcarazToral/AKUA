package dao.mapper;

import java.util.ArrayList;

import pojo.ListaReproduccion;

public interface ListaReproduccionMapper {

	/**
	 * Obtiene un listado de todas las canciones
	 * 
	 * @return las canciones
	 */
	public ArrayList<ListaReproduccion> getListasR();

	/**
	 * Este metodo es para poder insertar una cancion en la base de datos
	 * 
	 * @param cancion la cancion que queremos insertar
	 */
	public void insertListaR(ListaReproduccion listaReproduccion);

	/**
	 * Para poder actualizar los datos de una cancion
	 * 
	 * @param cancion la cancion que vamos a actualizar
	 */
	public void updateListaR(ListaReproduccion listaReproduccion);

	/**
	 * Elimina un usuario en base de datos
	 * 
	 * @param id El identificador del usuario
	 */
	public void deleteListaR(ListaReproduccion listaReproduccion);
}
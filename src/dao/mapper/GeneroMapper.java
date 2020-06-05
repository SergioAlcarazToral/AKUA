package dao.mapper;

import java.util.ArrayList;

import pojo.Genero;

/**
 * Todas las operaciones necesarias con generos
 * 
 * @author Sergio
 *
 */
public interface GeneroMapper {

	/**
	 * Obtiene un listado de todos los generos
	 * 
	 * @return generos
	 */
	public ArrayList<Genero> getGeneros();

	/**
	 * Obtener generos aleatorios
	 * 
	 * @return generos
	 */
	public ArrayList<Genero> getGenerosRandom();

	/**
	 * Este metodo es para poder insertar un genero en la base de datos
	 * 
	 * @param genero el genero que queremos insertar
	 */
	public void insertGenero(Genero genero);

}
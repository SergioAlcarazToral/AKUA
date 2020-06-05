package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.GeneroDAO;
import pojo.Genero;

/**
 * EJB relacinados con los generos
 * 
 * @author Sergio
 *
 */
@Stateless
@LocalBean
public class GeneroEJB {

	/**
	 * Obtener todos los generos
	 * 
	 * @return generos
	 */
	public ArrayList<Genero> getGeneros() {
		GeneroDAO generoDAO = new GeneroDAO();
		return generoDAO.getGeneros();
	}

	/**
	 * Obtener generos aleatorios
	 * 
	 * @return generos
	 */
	public ArrayList<Genero> getGenerosRandom() {
		GeneroDAO generoDAO = new GeneroDAO();
		return generoDAO.getGenerosRandom();
	}

	/**
	 * Intergar un genero en la base de datos
	 * 
	 * @param genero el genero que queremos insertar
	 */
	public void insertGenero(Genero genero) {
		GeneroDAO generoDAO = new GeneroDAO();
		generoDAO.insertGenero(genero);
	}

}

package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.ListaReproduccionDAO;
import pojo.ListaReproduccion;

/**
 * EJB con todas la operaciones con las listas
 * 
 * @author Sergio
 *
 */
@Stateless
@LocalBean
public class ListaReproduccionEJB {

	/**
	 * Obtener todas las listas
	 * 
	 * @return listas
	 */
	public ArrayList<ListaReproduccion> getListasR() {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getListasR();
	}

	/**
	 * Obtener todas las listas de un usuario
	 * 
	 * @param id Id del usuario
	 * @return listas
	 */
	public ArrayList<ListaReproduccion> getListasUsuario(int id) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getListasUsuario(id);
	}

	/**
	 * Obtener una lista en concreto
	 * 
	 * @param idUsuario Id del usuario
	 * @param nombre    nombre de la lista
	 * @return lista
	 */
	public ListaReproduccion getLista(int idUsuario, String nombre) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getLista(idUsuario, nombre);
	}

	/**
	 * Crear una lista de reproduccion
	 * 
	 * @param listaR Lista que queremos crear
	 */
	public void insertListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.insertListaR(listaR);
	}

	/**
	 * Insertar una cancion en una lista
	 * 
	 * @param listaR La cancion que queremos insertar con la lista
	 */
	public void insertCancion(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.insertCancion(listaR);
	}

	/**
	 * Borrar una lista de reproduccion
	 * 
	 * @param listaR lista que queremos borrar
	 */
	public void deleteListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.deleteListaR(listaR);
	}

	/**
	 * Borrar todas las listas de un usuario
	 * 
	 * @param idUsuario Id del usuario
	 */
	public void deleteListasUsuario(int idUsuario) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.deleteListasUsuario(idUsuario);
	}

	/**
	 * Borrar una cancion de una lista
	 * 
	 * @param listaR La cancion que queremos borrar de una lista
	 */
	public void deleteCancionLista(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.deleteCancionLista(listaR);
	}
}

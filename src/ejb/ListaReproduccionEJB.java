package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.ListaReproduccionDAO;
import pojo.ListaReproduccion;

@Stateless
@LocalBean
public class ListaReproduccionEJB {

	public ArrayList<ListaReproduccion> getListasR() {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getListasR();
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> master
	public ArrayList<ListaReproduccion> getListasUsuario(int id) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getListasUsuario(id);
	}

<<<<<<< HEAD
	public ListaReproduccion getLista(int idUsuario, String nombre) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getLista(idUsuario,nombre);
	}

=======
	public ListaReproduccion getLista(ListaReproduccion lista) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getLista(lista);
	}

=======
	public ArrayList<ListaReproduccion> getListasUsuario(int id){
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getListasUsuario(id);
	}
	
>>>>>>> master
>>>>>>> master
	public void insertListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.insertListaR(listaR);
	}
	
	public void insertCancion(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.insertCancion(listaR);
	}

	public void insertCancion(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.insertCancion(listaR);
	}

	public void insertCancion(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.insertCancion(listaR);
	}

	public void updateListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.updateListaR(listaR);
	}

	public void deleteListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.deleteListaR(listaR);
	}
<<<<<<< HEAD
	
	public void deleteListasUsuario(int idUsuario) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.deleteListasUsuario(idUsuario);
	}
	
=======
>>>>>>> master
	public void deleteCancionLista(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.deleteCancionLista(listaR);
	}
}

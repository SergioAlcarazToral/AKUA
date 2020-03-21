package ejb;

import java.util.ArrayList;

import dao.ListaReproduccionDAO;
import pojo.ListaReproduccion;

public class ListaReproduccionEJB {

	public ArrayList<ListaReproduccion> getListasR() {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		return listaDAO.getListasR();
	}

	public void insertListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.insertListaR(listaR);
	}

	public void updateListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.updateListaR(listaR);
	}

	public void deleteListaR(ListaReproduccion listaR) {
		ListaReproduccionDAO listaDAO = new ListaReproduccionDAO();
		listaDAO.deleteListaR(listaR);
	}
}

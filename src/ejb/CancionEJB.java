package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CancionDAO;
import pojo.Cancion;
import pojo.CancionCompleta;

@Stateless
@LocalBean
public class CancionEJB {

	public Cancion existeCandion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.existeCancion(id);
	}

	public Cancion getCancion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancion(id);
	}

	public ArrayList<Cancion> getCanciones() {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCanciones();
	}

	public ArrayList<Cancion> getCancionesRecom() {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesRecom();
	}

	public ArrayList<Cancion> getCancionesAlbum(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesAlbum(id);
	}

	public ArrayList<Cancion> getCancionesLista(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesLista(id);
	}

	public ArrayList<CancionCompleta> getCancionesCompletasLista(int id){
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesCompletasLista(id);
	}
	
	public ArrayList<CancionCompleta> getCancionesGenero(String nombre){
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesGenero(nombre);
	}
	
	public ArrayList<CancionCompleta> getCancionesCompletasAlbum(int id){
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesCompletasAlbum(id);
	}
	
	public void insertCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.insertCancion(cancion);
	}

	public void updateCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.updateCancion(cancion);
	}

	public void deleteCancion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.deleteCancion(id);
	}

}

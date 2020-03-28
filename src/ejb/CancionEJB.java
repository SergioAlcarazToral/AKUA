package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.CancionDAO;
import pojo.Cancion;

@Stateless
@LocalBean
public class CancionEJB {

	public Cancion existeCandion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.existeCancion(id);
	}

	public ArrayList<Cancion> getCanciones(){
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCanciones();
	}
	
	public ArrayList<Cancion> getCancionesRecom(){
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesRecom();
	}

	public ArrayList<Cancion> getCancionesAlbum(int id){
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesAlbum(id);
	}
	
	public void insertCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.insertCancion(cancion);
	}
	
	public void updateCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.updateCancion(cancion);
	}
	
	public void deleteCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.deleteCancion(cancion);
	}
	
}

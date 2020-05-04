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

	public Cancion getCancion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancion(id);
	}
<<<<<<< HEAD

	public ArrayList<Cancion> getCanciones() {
=======
<<<<<<< HEAD

	public ArrayList<Cancion> getCanciones() {
=======
<<<<<<< HEAD

	public ArrayList<Cancion> getCanciones() {
=======
	
	public ArrayList<Cancion> getCanciones(){
>>>>>>> master
>>>>>>> master
>>>>>>> master
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

<<<<<<< HEAD
	public ArrayList<Cancion> getCancionesGenero(String nombre){
		CancionDAO cancionDAO = new CancionDAO();
		return cancionDAO.getCancionesGenero(nombre);
	}
	
=======
>>>>>>> master
	public void insertCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.insertCancion(cancion);
	}

	public void updateCancion(Cancion cancion) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.updateCancion(cancion);
	}
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
<<<<<<< HEAD

=======
	
>>>>>>> master
>>>>>>> master
>>>>>>> master
	public void deleteCancion(int id) {
		CancionDAO cancionDAO = new CancionDAO();
		cancionDAO.deleteCancion(id);
	}

}

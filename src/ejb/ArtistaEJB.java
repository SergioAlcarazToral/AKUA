package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.ArtistaDAO;
import pojo.Artista;

@Stateless
@LocalBean
public class ArtistaEJB {

	public ArrayList<Artista> getArtistas(){
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtistas();
	}
	
	public ArrayList<Artista> getArtistasRandom(){
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtistasRandom();
	}
	
	public Artista getArtista(int id) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtista(id);
	}
	
	public ArrayList<Artista> getArtistaBuscado(String nombre){
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtistaBuscado(nombre);
	}
	
	public void insertArtista(Artista artista) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.insertArtista(artista);
	}
	
	public void updateArtista(Artista artista) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.updateArtista(artista);
	}
	
	public void deleteArtista(int id) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.deleteArtista(id);
	}
	
}

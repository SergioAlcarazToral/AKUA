package ejb;

import java.util.ArrayList;

import dao.ArtistaDAO;
import pojo.Artista;

public class ArtistaEJB {

	public ArrayList<Artista> getArtistas(){
		ArtistaDAO artistaDAO = new ArtistaDAO();
		return artistaDAO.getArtistas();
	}
	
	public void insertArtista(Artista artista) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.insertArtista(artista);
	}
	
	public void updateArtista(Artista artista) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.updateArtista(artista);
	}
	
	public void deleteArtista(Artista artista) {
		ArtistaDAO artistaDAO = new ArtistaDAO();
		artistaDAO.deleteArtista(artista);
	}
	
}

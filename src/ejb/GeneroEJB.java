package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.GeneroDAO;
import pojo.Genero;

@Stateless
@LocalBean
public class GeneroEJB {

	public ArrayList<Genero> getGeneros() {
		GeneroDAO generoDAO = new GeneroDAO();
		return generoDAO.getGeneros();
	}

	public void insertGenero(Genero genero) {
		GeneroDAO generoDAO = new GeneroDAO();
		generoDAO.insertGenero(genero);
	}

	public void updateGenero(Genero genero) {
		GeneroDAO generoDAO = new GeneroDAO();
		generoDAO.updateGenero(genero);
	}

	public void deleteGenero(Genero genero) {
		GeneroDAO generoDAO = new GeneroDAO();
		generoDAO.deleteGenero(genero);
	}

}

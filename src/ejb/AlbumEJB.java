package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.AlbumDAO;
import pojo.Album;

@Stateless
@LocalBean
public class AlbumEJB {

	public ArrayList<Album> getAlbumes(){
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbumes();
	}
	
	public ArrayList<Album> getAlbumesBuscados(String nombre){
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbumesBuscados(nombre);
	}
	
	public ArrayList<Album> getAlbumesArtista(int id){
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbumesArtista(id);
	}
	
	public Album getAlbum(int id) {
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbum(id);
	}
	
	public void insertAlbum(Album album) {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.insertAlbum(album);
	}
	
	public void updateAlbum(Album album) {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.updateAlbum(album);
	}
	
	public void deleteAlbum(Album album) {
		AlbumDAO albumDAO = new AlbumDAO();
		albumDAO.deleteAlbum(album);
	}
	
}

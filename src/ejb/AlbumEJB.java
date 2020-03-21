package ejb;

import java.util.ArrayList;

import dao.AlbumDAO;
import pojo.Album;

public class AlbumEJB {

	public ArrayList<Album> getAlbumes(){
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbumes();
	}
	
	public ArrayList<Album> getAlbum(String nombre){
		AlbumDAO albumDAO = new AlbumDAO();
		return albumDAO.getAlbum(nombre);
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

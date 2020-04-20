package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.AlbumMapper;
import pojo.Album;

/**
 * Clase DAO que sirve para realizar todas las acciones relacionadas con los
 * albums para las peticiones de la base de datos
 * 
 * @author Sergio
 *
 */

public class AlbumDAO {

	/**
	 * Para obtener un array de los albumes que quiere buscar el usuario
	 * 
	 * @param nombre el nombre del album
	 * @return los albums buscados
	 */
	public ArrayList<Album> getAlbumesBuscados(String nombre) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbumesBuscados(nombre);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para obtener todos los albumes de la base de datos
	 * 
	 * @return el array de albums
	 */
	public ArrayList<Album> getAlbumes() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbumes();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para obtener un album en concreto
	 * 
	 * @param id el identificador del album
	 * @return el album
	 */
	public Album getAlbum(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbum(id);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para obtener todos los albums de un artista
	 * 
	 * @param id el identificador de un artista
	 * @return los albums del artista
	 */
	public ArrayList<Album> getAlbumesArtista(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbumesArtista(id);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder insertar un album en la base de datos
	 * 
	 * @param album el album que queremos insertar
	 */
	public void insertAlbum(Album album) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			albumMapper.insertAlbum(album);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder editar un album en la base de datos
	 * 
	 * @param album el album que queremos editar con sus datos
	 */
	public void updateAlbum(Album album) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			albumMapper.updateAlbum(album);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder eliminar un album de la base de datos
	 * 
	 * @param id el identificador del album que queremos borrar
	 */
	public void deleteAlbum(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			albumMapper.deleteAlbum(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}

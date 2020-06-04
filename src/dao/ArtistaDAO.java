package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.ArtistaMapper;
import pojo.Artista;

/**
 * Clase DAO para poder realizar todas las acciones necesarias con artistas con
 * sus conexiones a base de datos
 * 
 * @author Sergio
 *
 */
public class ArtistaDAO {

	/**
	 * Para poder obtener todos los artistas de la base de datos
	 * 
	 * @return todos los artistas
	 */
	public ArrayList<Artista> getArtistas() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			return artistaMapper.getArtistas();
		} finally {
			sqlSession.close();
		}
	}

	public ArrayList<Artista> getArtistasRandom() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			return artistaMapper.getArtistasRandom();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * Para poder obtener un artista de la base de datos con un identificador
	 * 
	 * @param id el identificador del artista
	 * @return el artista
	 */
	public Artista getArtista(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			return artistaMapper.getArtista(id);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para pode obtener un array de los posibles resultados de la busqueda
	 * 
	 * @param nombre lo que el usuario busca
	 * @return el resultado
	 */
	public ArrayList<Artista> getArtistaBuscado(String nombre) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			return artistaMapper.getArtistaBuscado(nombre);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder insertar un artista en la base de datos
	 * 
	 * @param artista el artista que queremos insertar
	 */
	public void insertArtista(Artista artista) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			artistaMapper.insertArtista(artista);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder editar un artista de la base de datos
	 * 
	 * @param artista el artista que querems editar
	 */
	public void updateArtista(Artista artista) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			artistaMapper.updateArtista(artista);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder eliminar un artista de la base de datos
	 * 
	 * @param id el identificador del artista que queremos borrar
	 */
	public void deleteArtista(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			artistaMapper.deleteArtista(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}

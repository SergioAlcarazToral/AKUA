package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.CancionMapper;
import pojo.Cancion;
import pojo.CancionCompleta;

/**
 * 
 * @author Sergio
 *
 */
public class CancionDAO {

	/**
	 * Este metodo es para comprobar si una cancion existe
	 * 
	 * @param id El id de la cancion que queremos comprobar
	 * @return la cancion
	 */
	public Cancion existeCancion(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.existeCancion(id);
		} finally {
			sqlSession.close();
		}
	}

	public ArrayList<CancionCompleta> getCancionesCompletasLista(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancionesCompletasLista(id);
		} finally {
			sqlSession.close();
		}
	}
	public ArrayList<Cancion> getCancionesLista(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancionesLista(id);
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<CancionCompleta> getCancionesCompletasAlbum(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancionesCompletasAlbum(id);
		} finally {
			sqlSession.close();
		}
	}
	/**
	 * Este metodo es para poder obtener una cancion en especifico gracias a su id
	 * 
	 * @param id El id de la cancion que queremos
	 * @return la cancion
	 */
	public Cancion getCancion(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancion(id);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para obtener todas las canciones de la base de datos
	 * 
	 * @return todas las canciones
	 */
	public ArrayList<Cancion> getCanciones() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCanciones();
		} finally {
			sqlSession.close();
		}
	}

	public ArrayList<CancionCompleta> getCancionesGenero(String nombre){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancionesGenero(nombre);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * Para obtener canciones recomendadas
	 * 
	 * @return las canciones recomendadas
	 */
	public ArrayList<Cancion> getCancionesRecom() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancionesRecom();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para obtener todas las canciones de un album
	 * 
	 * @param id el id del album
	 * @return las canciones
	 */
	public ArrayList<Cancion> getCancionesAlbum(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancionesAlbum(id);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder insertar una cancion en la base de datos
	 * 
	 * @param cancion la cancion que queremos insertar
	 */
	public void insertCancion(Cancion cancion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			cancionMapper.insertCancion(cancion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder editar una cancion en la base de datos
	 * 
	 * @param cancion la cancion que editaremos con los datos nuevos
	 */
	public void updateCancion(Cancion cancion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			cancionMapper.updateCancion(cancion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder borrar una cancion de la base de datos
	 * 
	 * @param id el id de la cancion que queremos borrar
	 */
	public void deleteCancion(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			cancionMapper.deleteCancion(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}

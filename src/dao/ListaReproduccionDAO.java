package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.ListaReproduccionMapper;
import pojo.ListaReproduccion;

/**
 * Clase para poder realizar todas las acciones sobre las listas de reproduccion
 * 
 * @author Sergio
 *
 */
public class ListaReproduccionDAO {

	/**
	 * Para poder obtener todas las listas de reproduccion de la base de datos
	 * 
	 * @return las listas de reproduccion
	 */
	public ArrayList<ListaReproduccion> getListasR() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			return listaReproduccionM.getListasR();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Obtiene todas las listas de un usuario
	 * 
	 * @param id Id del usuario
	 * @return
	 */
	public ArrayList<ListaReproduccion> getListasUsuario(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			return listaReproduccionM.getListasUsuario(id);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Obtiene una lista en particular
	 * 
	 * @param idUsuario El id del usuario
	 * @param nombre    nombre de la lista
	 * @return
	 */
	public ListaReproduccion getLista(int idUsuario, String nombre) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			return listaReproduccionM.getLista(idUsuario, nombre);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder crear una lista de reproduccion
	 * 
	 * @param listaReproduccion la lista que queremos crear
	 */
	public void insertListaR(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.insertListaR(listaReproduccion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder insertar una cancione en la lista de reproduccion
	 * 
	 * @param listaReproduccion la cancion que inserta
	 */
	public void insertCancion(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.insertCancion(listaReproduccion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder editar una lista de reproduccion
	 * 
	 * @param listaReproduccion la lista que queremos editar
	 */
	public void updateListaR(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.updateListaR(listaReproduccion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder borrar una lista de reproduccion de la base de datos
	 * 
	 * @param listaReproduccion la lista que queremos borrar
	 */
	public void deleteListaR(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.deleteListaR(listaReproduccion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Elimina todas las listas de un usuario
	 * 
	 * @param idUsuario Id del usuario
	 */
	public void deleteListasUsuario(int idUsuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.deleteListasUsuario(idUsuario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Elimina una cancion de una lista de reproduccion
	 * 
	 * @param listaReproduccion todos los datos para eliminar una cancion
	 */
	public void deleteCancionLista(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.deleteCancionLista(listaReproduccion);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}

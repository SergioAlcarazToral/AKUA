package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.GeneroMapper;
import pojo.Genero;

/**
 * Para realizar todas la acciones relacionadas con los generos
 * 
 * @author Sergio
 *
 */
public class GeneroDAO {

	/**
	 * Para poder obtener todos los generos de la base de datos
	 * 
	 * @return todos los generos de la base de datos
	 */
	public ArrayList<Genero> getGeneros() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			return generoMapper.getGeneros();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder insertar un genero en la base de datos
	 * 
	 * @param genero el genero que queremos insertar
	 */
	public void insertGenero(Genero genero) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			generoMapper.insertGenero(genero);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder editar un genero en la base de datos
	 * 
	 * @param genero el genero que queremos editar
	 */
	public void updateGenero(Genero genero) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			generoMapper.updateGenero(genero);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder eliminar un genero de la base de datos
	 * 
	 * @param genero el generoq que queremos borrar
	 */
	public void deleteGenero(Genero genero) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			generoMapper.deleteGenero(genero);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}

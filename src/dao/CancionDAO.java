package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.CancionMapper;
import pojo.Cancion;

public class CancionDAO {

	public Cancion existeCancion(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.existeCancion(id);
		} finally{
			sqlSession.close();
		}
	}
	public ArrayList<Cancion> getCanciones(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCanciones();
		} finally{
			sqlSession.close();
		}
	}

	public ArrayList<Cancion> getCancionesRecom(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			return cancionMapper.getCancionesRecom();
		} finally{
			sqlSession.close();
		}
	}
	public void insertCancion(Cancion cancion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			cancionMapper.insertCancion(cancion);
		} finally{
			sqlSession.close();
		}
	}
	public void updateCancion(Cancion cancion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			cancionMapper.updateCancion(cancion);
		} finally{
			sqlSession.close();
		}
	}
	public void deleteCancion(Cancion cancion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CancionMapper cancionMapper = sqlSession.getMapper(CancionMapper.class);
			cancionMapper.deleteCancion(cancion);
		} finally{
			sqlSession.close();
		}
	}
}
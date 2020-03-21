package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.GeneroMapper;
import pojo.Genero;

public class GeneroDAO {

	public ArrayList<Genero> getGeneros() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			return generoMapper.getGeneros();
		} finally {
			sqlSession.close();
		}
	}

	public void insertGenero(Genero genero) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			generoMapper.insertGenero(genero);
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateGenero(Genero genero) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			generoMapper.updateGenero(genero);
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteGenero(Genero genero) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			GeneroMapper generoMapper = sqlSession.getMapper(GeneroMapper.class);
			generoMapper.deleteGenero(genero);
		} finally {
			sqlSession.close();
		}
	}
	
}

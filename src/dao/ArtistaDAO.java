package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.ArtistaMapper;
import pojo.Artista;

public class ArtistaDAO {

	public ArrayList<Artista> getArtistas() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			return artistaMapper.getArtista();
		} finally {
			sqlSession.close();
		}
	}

	public void insertArtista(Artista artista) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			artistaMapper.insertArtista(artista);
		} finally {
			sqlSession.close();
		}
	}

	public void updateArtista(Artista artista) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			artistaMapper.updateArtista(artista);
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteArtista(Artista artista) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ArtistaMapper artistaMapper = sqlSession.getMapper(ArtistaMapper.class);
			artistaMapper.deleteArtista(artista);
		} finally {
			sqlSession.close();
		}
	}
	
}


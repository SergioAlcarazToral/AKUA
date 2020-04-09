package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.AlbumMapper;
import pojo.Album;

public class AlbumDAO {

	public ArrayList<Album> getAlbumesBuscados(String nombre) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbumesBuscados(nombre);
		} finally {
			sqlSession.close();
		}
	}

	public ArrayList<Album> getAlbumes(){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbumes();
		} finally {
			sqlSession.close();
		}
	}
	
	public Album getAlbum(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbum(id);
		} finally {
			sqlSession.close();
		}
	}
	
	public ArrayList<Album> getAlbumesArtista(int id){
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbumesArtista(id);
		} finally {
			sqlSession.close();
		}
	}
	
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

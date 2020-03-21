package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.AlbumMapper;
import pojo.Album;

public class AlbumDAO {

	public ArrayList<Album> getAlbum(String nombre) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			return albumMapper.getAlbum(nombre);
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
	
	public void insertAlbum(Album album) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			albumMapper.insertALbum(album);
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateAlbum(Album album) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			albumMapper.updateAlbum(album);
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteAlbum(Album album) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			AlbumMapper albumMapper = sqlSession.getMapper(AlbumMapper.class);
			albumMapper.deleteAlbum(album);
		} finally {
			sqlSession.close();
		}
	}
}

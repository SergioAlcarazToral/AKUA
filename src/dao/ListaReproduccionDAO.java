package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.ListaReproduccionMapper;
import pojo.ListaReproduccion;

public class ListaReproduccionDAO {

	public ArrayList<ListaReproduccion> getListasR() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			return listaReproduccionM.getListasR();
		} finally {
			sqlSession.close();
		}
	}

	public void insertListaR(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.insertListaR(listaReproduccion);
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateListaR(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.updateListaR(listaReproduccion);
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteListaR(ListaReproduccion listaReproduccion) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ListaReproduccionMapper listaReproduccionM = sqlSession.getMapper(ListaReproduccionMapper.class);
			listaReproduccionM.deleteListaR(listaReproduccion);
		} finally {
			sqlSession.close();
		}
	}

}

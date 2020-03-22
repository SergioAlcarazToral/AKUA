package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.UsuarioMapper;
import pojo.Usuario;

public class UsuarioDAO {

	public Usuario existeUsuario(Usuario usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.existeUsuario(usuario);
		} finally {
			sqlSession.close();
		}
	}

	public ArrayList<Usuario> getUsuarios() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.getUsuarios();
		} finally {
			sqlSession.close();
		}
	}

	public void insertUsuario(Usuario usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.insertUsuario(usuario);
		} finally {
			sqlSession.close();
		}
	}

	public void updateUsuario(Usuario usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.updateUsuario(usuario);
		} finally {
			sqlSession.close();
		}
	}

	public void deleteUsuario(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.deleteUsuario(id);
		} finally {
			sqlSession.close();
		}
	}

}

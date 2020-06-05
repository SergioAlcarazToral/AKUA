package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import dao.mapper.UsuarioMapper;
import pojo.Usuario;

/**
 * Clase para poder realizar todas las acciones relacionadas con los usuarios
 * 
 * @author Sergio
 *
 */
public class UsuarioDAO {

	/**
	 * Para poder comprobar si existe un usuario
	 * 
	 * @param correo el correo del usuario
	 * @param pass   la contraseña del usuario
	 * @return el usuario
	 */
	public Usuario existeUsuario(String correo, String pass) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.existeUsuario(correo, pass);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para obtener todos los usuarios de la base de datos
	 * 
	 * @return todos los usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.getUsuarios();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder insertar un usuario en la base de datos
	 * 
	 * @param usuario el usuario que queremos insertar
	 */
	public void insertUsuario(Usuario usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.insertUsuario(usuario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Para poder borrar un usuario de la base de datos
	 * 
	 * @param id el id del usuario
	 */
	public void deleteUsuario(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.deleteUsuario(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

}

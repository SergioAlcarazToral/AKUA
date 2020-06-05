package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Usuario;

/**
 * Todas las operaciones relacionadas con los usuarios
 * 
 * @author Sergio
 *
 */
public interface UsuarioMapper {

	/**
	 * Para saber si existe un usuario
	 * 
	 * @param correo correo
	 * @param pass   contraseña
	 * @return usuario
	 */
	public Usuario existeUsuario(@Param("correo") String correo, @Param("pass") String pass);

	/**
	 * Obtener todos los usuarios
	 * @return usuarios
	 */
	public ArrayList<Usuario> getUsuarios();

	/**
	 * Insertar un usuaio en la base de datos
	 * @param usuario el usuario que se va a insertar
	 */
	public void insertUsuario(Usuario usuario);

	/**
	 */
	public void deleteUsuario(@Param("id") Integer id);
}
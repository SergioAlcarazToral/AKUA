package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.UsuarioDAO;
import pojo.Usuario;

/**
 * EJB con todas las operaciones de los usuarios
 * 
 * @author Sergio
 *
 */
@Stateless
@LocalBean
public class UsuarioEJB {

	/**
	 * Para comprobar en la base de datos que el usuario existe
	 * 
	 * @param usuario el usuarios que queremos comprobar
	 * @return el usuario
	 */
	public Usuario existeUsuario(String correo, String pass) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.existeUsuario(correo, pass);
	}

	/**
	 * Obtenemos todos los usuarios
	 * 
	 * @return usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.getUsuarios();
	}

	/**
	 * Creamos un usuario
	 * 
	 * @param usuario El usuario que queremos crear
	 */
	public void insertUsuario(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.insertUsuario(usuario);
	}

	/**
	 * Borrar un usuario
	 * 
	 * @param id El id del usuario que queremos borrar
	 */
	public void deleteUsuario(int id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.deleteUsuario(id);
	}
}

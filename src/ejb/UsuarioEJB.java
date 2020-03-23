package ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import dao.UsuarioDAO;
import pojo.Usuario;

@Stateless
@LocalBean
public class UsuarioEJB {

	/**
	 * Para comprobar en la base de datos que el usuario existe
	 * 
	 * @param usuario el usuarios que queremos comprobar
	 * @return el usuario
	 */
	public Usuario existeUsuario(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.existeUsuario(usuario);
	}

	public ArrayList<Usuario> getUsuarios() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.getUsuarios();
	}

	public void insertUsuario(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.insertUsuario(usuario);
	}

	public void updateUsuario(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.updateUsuario(usuario);
	}

	public void deleteUsuario(int id) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.deleteUsuario(id);
	}
}

package dao.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import pojo.Usuario;

public interface UsuarioMapper {

	public Usuario existeUsuario(@Param("correo") String correo, @Param("pass") String pass);

	public ArrayList<Usuario> getUsuarios();

	public void insertUsuario(Usuario usuario);

	public void updateUsuario(Usuario usuario);

	public void deleteUsuario(@Param("id") Integer id);
}
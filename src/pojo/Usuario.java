package pojo;

public class Usuario {

	Integer id;
	String nombre;
	String correo;
	String pass;
	Integer administrador;
	String foto;
	
	public Usuario() {
		
	}
	
	public Usuario(Integer id, String nombre, String correo, String pass, Integer administrador, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.pass = pass;
		this.administrador = administrador;
		this.foto = foto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Integer administrador) {
		this.administrador = administrador;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}

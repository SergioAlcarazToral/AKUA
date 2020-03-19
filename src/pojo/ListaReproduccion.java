package pojo;

public class ListaReproduccion {

	String nombre;
	Integer idUsuario;
	Integer idCancion;

	public ListaReproduccion() {

	}

	public ListaReproduccion(String nombre, Integer idUsuario, Integer idCancion) {
		super();
		this.nombre = nombre;
		this.idUsuario = idUsuario;
		this.idCancion = idCancion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(Integer idCancion) {
		this.idCancion = idCancion;
	}

}

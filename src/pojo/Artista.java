package pojo;

public class Artista {

	Integer id;
	String nombre;
	String foto;
	
	public Artista() {
		
	}
	
	public Artista(Integer id, String nombre, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}

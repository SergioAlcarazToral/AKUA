package pojo;

public class Album {

	Integer id;
	String nombre;
	Integer anyo;
	String artista;
	String foto;

	public Album() {

	}

	public Album(Integer id, String nombre, Integer anyo, String artista, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anyo = anyo;
		this.artista = artista;
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

	public Integer getAnyo() {
		return anyo;
	}

	public void setAnyo(Integer anyo) {
		this.anyo = anyo;
	}

	public String getIdArtista() {
		return artista;
	}

	public void setIdArtista(String artista) {
		this.artista = artista;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}

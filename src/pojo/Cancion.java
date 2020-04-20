package pojo;

public class Cancion {

	Integer id;
	String titulo;
	String genero;
	String album;
	String archivo;

	public Cancion() {

	}

	public Cancion(Integer id, String titulo, String genero, String album, String archivo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.album = album;
		this.archivo = archivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

}

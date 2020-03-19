package pojo;

public class Cancion {

	Integer id;
	String titulo;
	String genero;
	String album;
	String artista;

	public Cancion() {

	}

	public Cancion(Integer id, String titulo, String genero, String album, String artista) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.album = album;
		this.artista = artista;
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

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

}

package pojo;

public class CancionCompleta {

	Integer id;
	String titulo;
	String genero;
	String album;
	int idAlbum;
	String artista;
	int idArtista;
	String archivo;

	public CancionCompleta() {

	};

	public CancionCompleta(Integer id, String titulo, String genero, String album, int idAlbum, String artista,
			int idArtista, String archivo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.album = album;
		this.idAlbum = idAlbum;
		this.artista = artista;
		this.idArtista = idArtista;
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

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

}

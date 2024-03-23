package one.digital.arqhexagonal.domain.music;

public class Music {
    private Long id;
    private String titulo;
    private String autor;
    private String album = "";
    private String genero = "";

    public Music(String titulo, String autor, String album, String genero){
        this.titulo = titulo;
        this.autor = autor;
        this.album = album;
        this.genero = genero;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

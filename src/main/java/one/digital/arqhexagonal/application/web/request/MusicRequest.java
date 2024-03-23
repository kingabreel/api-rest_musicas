package one.digital.arqhexagonal.application.web.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import one.digital.arqhexagonal.domain.music.Music;

public class MusicRequest {
    @NotNull
    @NotBlank
    @NotEmpty
    private String titulo;
    @NotNull
    @NotBlank
    @NotEmpty
    private String autor;
    private String album = "";
    private String genero = "";

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

    public MusicRequest(String titulo, String autor, String album, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.album = album;
        this.genero = genero;
    }

}

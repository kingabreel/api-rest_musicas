package one.digital.arqhexagonal.application.web.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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

    public String getAutor() {
        return autor;
    }

    public String getAlbum() {
        return album;
    }

    public String getGenero() {
        return genero;
    }

    public MusicRequest(String titulo, String autor, String album, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.album = album;
        this.genero = genero;
    }

}

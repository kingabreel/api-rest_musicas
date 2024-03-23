package one.digital.arqhexagonal.application.web.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import one.digital.arqhexagonal.application.web.response.MusicResponse;
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
    public static MusicRequest from(Long id, Music music) {
        music.setId(id);
        return new MusicRequest(
                music.getTitulo(),
                music.getAutor(),
                music.getAlbum(),
                music.getGenero()
        );
    }
}

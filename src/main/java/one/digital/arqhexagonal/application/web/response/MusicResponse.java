package one.digital.arqhexagonal.application.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import one.digital.arqhexagonal.domain.music.Music;

public class MusicResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("titulo")
    private String titulo;
    @JsonProperty("autor")
    private String autor;
    @JsonProperty("album")
    private String album = "";
    @JsonProperty("genero")
    private String genero = "";

    public MusicResponse(Long id, String titulo, String autor, String album, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.album = album;
        this.genero = genero;
    }

    public static MusicResponse from(Music music) {
        return new MusicResponse(
                music.getId(),
                music.getTitulo(),
                music.getAutor(),
                music.getAlbum(),
                music.getGenero()
        );
    }
}

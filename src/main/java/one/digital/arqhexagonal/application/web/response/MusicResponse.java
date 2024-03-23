package one.digital.arqhexagonal.application.web.response;

import one.digital.arqhexagonal.domain.music.Music;

public class MusicResponse {
    private Long id;
    private String titulo;
    private String autor;
    private String album = "";
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

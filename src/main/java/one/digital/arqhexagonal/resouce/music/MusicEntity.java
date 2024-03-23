package one.digital.arqhexagonal.resouce.music;

import jakarta.persistence.*;
import one.digital.arqhexagonal.application.web.request.MusicRequest;
import one.digital.arqhexagonal.domain.music.Music;

@Entity
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "autor", nullable = false)
    private String autor;
    @Column(name = "album")
    private String album = "";
    @Column(name = "genero", nullable = false)
    private String genero = "";

    public MusicEntity(Long id, String titulo, String autor, String album, String genero){
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

    public static MusicEntity from(Music music) {
        return new MusicEntity(
                music.getId(),
                music.getTitulo(),
                music.getAutor(),
                music.getAlbum(),
                music.getGenero()
        );
    }
}

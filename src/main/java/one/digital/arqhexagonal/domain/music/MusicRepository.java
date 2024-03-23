package one.digital.arqhexagonal.domain.music;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository {
    Music getDetail(Long id);
    List<Music> getMusics();
    Music create(Music music);
    void delete(Long id);
    Music update(Music music);
}

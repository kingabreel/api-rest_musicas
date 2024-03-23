package one.digital.arqhexagonal.domain.music;

import one.digital.arqhexagonal.application.config.MusicNotFoundException;
import one.digital.arqhexagonal.resouce.music.MusicEntity;
import one.digital.arqhexagonal.resouce.music.MusicEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MusicRepositoryImpl implements MusicRepository {
    @Autowired
    private MusicEntityRepository musicEntityRepository;

    @Override
    public Music getDetail(Long id) {
        Optional<MusicEntity> optionalMusic = musicEntityRepository.findById(id);
        MusicEntity musicEntity = optionalMusic.get();

        return (optionalMusic == null) ? null : Music.toMusic(musicEntity);
    }

    @Override
    public List<Music> getMusics() {
        return musicEntityRepository.findAll()
                .stream()
                .map(musicEntity -> {
                    Music music = Music.toMusic(musicEntity);
                    music.setId(musicEntity.getId());
                    return music;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Music create(Music music) {
        musicEntityRepository.save(MusicEntity.from(music));
        return music;
    }

    @Override
    public void delete(Long id) {
        musicEntityRepository.deleteById(id);
    }

    @Override
    public Music update(Music music) {
        Optional<MusicEntity> optionalMusicEntity = musicEntityRepository.findById(music.getId());

        return optionalMusicEntity.map(existingEntity -> {
            existingEntity.setTitulo(music.getTitulo());
            existingEntity.setAutor(music.getAutor());
            existingEntity.setAlbum(music.getAlbum());
            existingEntity.setGenero(music.getGenero());
            MusicEntity updatedEntity = musicEntityRepository.save(existingEntity);
            return Music.toMusic(updatedEntity);
        }).orElseThrow(() -> new MusicNotFoundException("Música não encontrada com ID: " + music.getId()));
    }
}

package one.digital.arqhexagonal.domain.music;

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
                .map(musicEntity -> Music.toMusic(musicEntity))
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
        musicEntityRepository.save(MusicEntity.from(music));
        return music;
    }
}

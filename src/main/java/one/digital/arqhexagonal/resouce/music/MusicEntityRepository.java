package one.digital.arqhexagonal.resouce.music;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicEntityRepository extends JpaRepository<MusicEntity, Long> {
}

package one.digital.arqhexagonal.application.web.resourse;

import one.digital.arqhexagonal.application.web.response.MusicResponse;
import one.digital.arqhexagonal.application.web.request.MusicRequest;
import one.digital.arqhexagonal.domain.music.Music;
import one.digital.arqhexagonal.domain.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/api/music")
public class MusicResourse {

    @Autowired
    private MusicRepository musicRepository;

    @GetMapping
    public ResponseEntity<List<MusicResponse>> getMusics() {
        List<MusicResponse> musicResponses = musicRepository.getMusics().stream()
                .map(MusicResponse::from)
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(musicResponses);
    }

    @GetMapping("/{id}")
    public MusicResponse getMusic(@PathVariable("id") Long id){
        Music music = musicRepository.getDetail(id);
        return MusicResponse.from(music);
    }

    @PostMapping
    public ResponseEntity<MusicResponse> createMusic(@RequestBody MusicRequest musicRequest) throws URISyntaxException {
        Music music = new Music(
                musicRequest.getTitulo(),
                musicRequest.getAutor(),
                musicRequest.getAlbum(),
                musicRequest.getGenero()
        );
        musicRepository.create(music);
        return ResponseEntity.created(new URI("/v1/api/music/" + music.getId())).body(MusicResponse.from(music));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicResponse> updateMusic(@RequestBody MusicRequest musicRequest, @PathVariable("id") Long id){
        Music music = musicRepository.getDetail(id);
        music.setTitulo(musicRequest.getTitulo());
        music.setAlbum(musicRequest.getAlbum());
        music.setAutor(musicRequest.getAutor());
        music.setGenero(musicRequest.getGenero());

        musicRepository.update(music);

        return ResponseEntity.ok().body(MusicResponse.from(music));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMusic(@PathVariable("id") Long id){
        musicRepository.delete(id);
        return ResponseEntity.accepted().build();
    }
}

package one.digital.arqhexagonal.application.config;

public class MusicNotFoundException extends RuntimeException {

    public MusicNotFoundException(String message) {
        super(message);
    }

    public MusicNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

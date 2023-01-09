package schwarz.it.lws.java._002_001_oop.tasks.article_manager.exceptions;

public class EANAlreadyExistsException extends RuntimeException {
    public EANAlreadyExistsException(String message) {
        super(message);
    }
}
package schwarz.it.lws.java._002_001_oop.tasks.article_manager.exceptions;

public class EANNotExistsException extends RuntimeException {
    public EANNotExistsException(String message) {
        super(message);
    }
}
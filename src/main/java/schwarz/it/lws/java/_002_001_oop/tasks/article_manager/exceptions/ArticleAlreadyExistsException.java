package schwarz.it.lws.java._002_001_oop.tasks.article_manager.exceptions;

public class ArticleAlreadyExistsException extends RuntimeException {
    public ArticleAlreadyExistsException(String message) {
        super(message);
    }
}

package schwarz.it.lws.java._002_001_oop.tasks.article_manager.exceptions;

public class ArticleNotExistsException extends RuntimeException {
    public ArticleNotExistsException(String message) {
        super(message);
    }
}

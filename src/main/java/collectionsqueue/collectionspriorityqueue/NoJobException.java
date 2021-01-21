package collectionsqueue.collectionspriorityqueue;

public class NoJobException extends RuntimeException {

    public NoJobException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoJobException(String message) {
        super(message);
    }
}

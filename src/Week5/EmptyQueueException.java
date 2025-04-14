package Week5;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
      super("There is nothing in the queue!");
    }
}

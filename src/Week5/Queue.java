package Week5;

public interface Queue <T>{
    public void enqueue(T element);
    public T dequeue();
    public boolean isEmpty();
    public int size();
    T Peek();
}

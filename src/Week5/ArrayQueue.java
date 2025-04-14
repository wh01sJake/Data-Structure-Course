package Week5;

public class ArrayQueue<T> implements Queue<T> {
    private T[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue() {
        array = (T[]) new Object[10];
    }

    public ArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size == array.length) {
            throw new RuntimeException("Queue is full");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
        size++;

    }

    @Override
    public T dequeue() { // update size
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        else {
            T element = array[front];
            front = (front + 1) % array.length;
            size--;
            return element;
        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T Peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front];
    }

    @Override
    public String toString() {
        String output = "";
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        else {
            int current = front;
            for (int i = 0; i < size; i++) {
                output += array[current] + " ";
                current = (current + 1) % array.length;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayQueue<String> queue = new ArrayQueue<String>(5);
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");

        System.out.println(queue + " " + queue.size);
        queue.dequeue();
        System.out.println(queue);
    }


}

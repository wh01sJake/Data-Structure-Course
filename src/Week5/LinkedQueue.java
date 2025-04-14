package Week5;

public class LinkedQueue<T> implements Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedQueue() {
        head = null;
        tail = null;
    }



    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element,null);
        if (isEmpty()) {
            head = newNode;
            tail = head;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            Node<T> temp = head;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        else {
            int size = 0;
            Node<T> temp = head;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
            return size;
        }
    }

    @Override
    public T Peek() {
        if (isEmpty()) {throw new EmptyQueueException();}
        else {
            return head.element;
        }
    }

    @Override
    public String toString() {
        String output = "";
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else {
            Node<T> temp = head;
            while (temp != null) {
                output += temp.element + "\n";
                temp = temp.next;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> nums = new LinkedQueue<>();
        nums.enqueue(1);
        nums.enqueue(2);
        nums.enqueue(3);
        System.out.println("Queue size: " + nums.size());
        nums.dequeue();
        nums.dequeue();
        System.out.println("Queue size: " + nums.size());
    }
}

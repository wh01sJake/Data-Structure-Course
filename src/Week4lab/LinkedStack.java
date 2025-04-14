package Week4lab;

import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> head;
    private int size;

    public LinkedStack() {
        this.head = null;
        size = 0;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    @Override
    public T pop() {
    if (head == null) {throw new NoSuchElementException();}
    T element = head.element;
    head = head.next;
    size--;
    return element;
    }

    @Override
    public T peek() {
        if (head == null) {throw new NoSuchElementException();}
        return head.element;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        String tags ="\n";
        while (current != null) {
            tags += current + "\n";
            current = current.next;
        }
        return tags;
    }

    public static void main(String[] args) {

    }

}

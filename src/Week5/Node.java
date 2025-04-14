package Week5;

public class Node <T>{
    T element;
    Node<T> next;

    public Node(T element , Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public Node(T element) {
        this.element = element;
        this.next = null;
    }

    @Override
    public String toString() {
        return
                "element= " + element
                ;
    }

    public static void main(String[] args) {
        Node<String> a = new Node<String>("a");
        Node<String> b = new Node<String>("b");
        Node<String> c = new Node<String>("c");
        Node<String> d = new Node<String>("d");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        System.out.println(a);
    }
}

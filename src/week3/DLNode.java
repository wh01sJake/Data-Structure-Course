package week3;

public class DLNode<T> {
    T element;
    DLNode<T> previous;
    DLNode<T> next;


    public DLNode(T element, DLNode<T> previous, DLNode<T> next) {
        this.element = element;
        this.previous = previous;
        this.next = next;
    }

    public DLNode(T element) {
        this.element = element;
        this.previous = null;
        this.next = null;
    }

    public boolean isEmpty() {
        return element == null;
    }



    //Methods
    @Override
    public String toString(){
        return "<Element : "+element+" >";
    }


    public static void main(String[] args) {
        DLNode<Integer> node = new DLNode<>(100);
        node.next = new DLNode<Integer>(1001,node,null);
        System.out.println(node.next);
        System.out.println(node.next.next);

    }


}

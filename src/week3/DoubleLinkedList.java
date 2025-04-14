package week3;

import Week4lab.Node;

public class DoubleLinkedList<T>{
    private DLNode<T> head;
    private DLNode<T> tail;

    public DoubleLinkedList(){
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        int count=0;
        DLNode<T> current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void prepend(T element){
        if(isEmpty()){
            add(element);
        }
        else{
            head = new DLNode<>(element,null,head);
            head.next.previous = head;
        }
    }

    @Override
    public String toString() {
        String output ="";
        DLNode<T> current = head;
        while(current != null){
            output+=current;
            current = current.next;
        }

        return output;

    }

    public void add(T element){
        if(isEmpty()){
            head =  new DLNode<>(element,null,null);
            tail = head;

        }
        else{
            tail.next = new DLNode<>(element,tail,null);
            tail = tail.next;

        }
    }

    public void add(int index, T element) throws IndexOutOfBoundsException {

        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if (index == 0) {
            DLNode<T> newNode = new DLNode<>(element, null, head);
            if (head != null) {
                head.previous = newNode;
            } else {
                tail = newNode;
            }
            head = newNode;
        } else if (index == size()) {
            // Append to the end by calling add(element)
            add(element);

        } else {
            // general case
            DLNode<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            DLNode<T> prevNode = current.previous;
            DLNode<T> newNode = new DLNode<>(element, prevNode, current);
            prevNode.next = newNode;
            current.previous = newNode;
        }
    }

}

package Week4lab;

public class Node<T>{
    //instance variables
    T element;
    Node<T> next;

    //Constructor

    //We need two constructors
    public Node(T element, Node<T> next){
        this.element = element;
        this.next = next;
    }

    // The second constructor is needed when we don't have a Node to point to
    public Node(T el){
        this.element = el;
        this.next = null;
    }

    //Methods
    @Override
    public String toString(){
        return "Tag: < "+element+" >";
    }

}

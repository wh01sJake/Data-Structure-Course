package week2lab;

public class LinkedList<T> implements List<T> {
  private Node<T> first;
  private Node<T> last;



  public LinkedList(){
    first = null;
    last = null;
  }

  // Check to see if the linkedlist is empty.
  //The linkedlist must be empty  if first is null!

  @Override
  public boolean isEmpty(){
    return first ==null;
  }
  // we need to iterate through the LinkedList and on each
  //movement we add 1 to the counter.
  // We should stop when we reach the end, i.e. when the current is null
  public int size(){
    int count=0;
    Node<T> current = first;
    while(current != null){
      count++;
      current = current.next;
    }
    return count;
  }
  public String toString(){
    String out = "";
    Node<T> p = first;
    while(p != null){
      out += p.element+", ";
      p = p.next;
    }
    return out;
  }
  public T remove(T el) {
    // What I did is a loop to traverse the list until find the same element. Then we "skip" the node by changing the pointer before it to point to the next node.
    Node<T> n = first;
    Node<T> previous = null;
    T found = el;
      while(n != null){
        if(n.element.equals(el)){
          if(previous == null){
            first = first.next;
            /*n = n.next;*/
            if(first == null){// if the head is empty after removing a node, the list is empty
              last = null;
            }
          }
          //now let's go back to the normal situation
        else {
          previous.next = n.next;
          }
        return found;
        }
        previous = n;
        n = n.next; // update the node to next one
      }
      return null; // If nothing found to remove return null
  }

  /*
      Review the code below to checkout how to add an element at an index
  */
  public void add(int index, T el){
    if(index < 0 || index > size())throw new IndexOutOfBoundsException();

    if(index ==0 ){
      first = new Node<T>(el, first);
      if(last == null){
        last = first;
      }
    }else{
      Node<T> pred = first;
      for(int i=1;i <=index - 1;i++){
        pred = pred.next;
      }
      pred.next = new Node<T>(el, pred.next);
      if(pred.next.next == null){
        last = pred.next;
      }
    }
    return;
  }




  //We have two cases when adding in an element...
  public void add(T el){
    if(isEmpty()){
      first = new Node<T>(el);
      last = first;
    }else{
      last.next = new Node<T>(el);
      last = last.next;
    }
  }
  //Method to check if a n element exists within the linkedlist
  public boolean contains(T target){
    boolean found = false;
    Node<T> current = first;
    while(current != null){
      if(current.element == target){
        found = true;
      }
      current = current.next;
    }
    return found;
  }
/*
  This method adds an element before a target element
  We need to find the element...
*/
  public void addBefore(T target, T elem) {


  // to be completed...

    //There should be more consideration:
    // if we are adding before the head
    if(first.element.equals(target)){
      first = new Node<>(elem, first);
    }

    Node<T> current = first;
    Node<T> previous = null;
    while(current != null){
      if(current.element.equals(target)){
        previous.next = new Node<>(elem, current); // This is the key function of the method. To insert the element between the previous node and current node
      }
      previous = current;
      current = current.next;
    }

}
  public void addAfter(T target, T elem) {

  // to be completed...
    // Seems easier than addBefore
    Node<T> current = first;
    while(current != null){
      if(current.element.equals(target)){
        current.next = new Node<>(elem, current.next);
      }
      current = current.next;
    }

}
  public static void main(String [] args){

    /* Test result
    * ---------------------------
The sie of the linked list is :: 5
apple, Orange, Banana, Pear, Kiwi,
---------------------------
apple, Grape, Banana, Pear, Kiwi,
The sie of the linked list is :: 5
---------------------------*/
    LinkedList<String> linked = new LinkedList<>();
    linked.add("apple");
    linked.add("Orange");
    linked.add("Banana");
    linked.add("Pear");
    linked.add("Kiwi");
    System.out.println("---------------------------");
    System.out.println("The sie of the linked list is :: "+linked.size());
    System.out.println(linked);
    System.out.println("---------------------------");
    linked.remove("Orange");
    linked.addAfter("apple", "Grape");
    System.out.println(linked);
    System.out.println("The sie of the linked list is :: "+linked.size());
    System.out.println("---------------------------");
  }






}

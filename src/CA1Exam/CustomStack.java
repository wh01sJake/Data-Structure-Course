package CA1Exam;

import java.util.EmptyStackException;

public class CustomStack<T> {
     Node<T> top;

     public CustomStack() {
         top = null;
     }



    public boolean isEmpty() {
         return top == null;
     }

     public void push(T value) {
         if (isEmpty()) {
             top = new Node<T>(value);
         }
         else {
             Node<T> newNode = new Node<T>(value);
             newNode.next = top;
             top = newNode;
         }
     }

     public T pop() {
         if (isEmpty()) {
             throw new EmptyStackException();
         }
         else {
             T value = top.data;
             top = top.next;
             return value;
         }
     }

     public T peek() {
         if (isEmpty()) {
             throw new EmptyStackException();
         }
         else {
             return top.data;
         }
     }
}

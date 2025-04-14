package Week4lab;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int top;
    private int size;

    public ArrayStack() {
        array = (T[]) new Object[10];
    }
    public ArrayStack(int size) {
        this.size = size;
        this.top = -1;
        this.array = (T[]) new Object[size];
    }

    public void push(T element) {
        if ( top == size ) {throw new IndexOutOfBoundsException("Stack overflow");}
        array[top] = element;
        top++;
    }

    public T pop() {
        if ( top == -1 ) {throw new IndexOutOfBoundsException("Stack underflow");}
        else {
            T element = array[top];
            top --;
            return element;
        }
    }

    public T peek() {
        return array[top];
    }

    @Override
    public String toString() {
        String str = "TOP";
        int counter = top;
        while(counter > 0){
            counter++;
            str += "\n" + array[counter];

        }
        return str + "\nBOTTOM";
    }

}

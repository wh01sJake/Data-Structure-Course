package LabTest;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;


    public LinkList(){
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        size = 0;
    }


    @Override
    public Iterator<T> iterator(){
        return new Literator();
    }

    private class Literator implements Iterator<T> {

        @Override
        public boolean hasNext(){
            return false;
        }

        @Override
        public T next(){
            return null;
        }


    }

    // clear the list
    public void clear(){
        head.next = null;
        size = 0;

    }

    // check if the list is empty
    public boolean isEmpty(){
        return size == 0;
    }



    // get the length of the list
    public int length(){
        return size;

    }

    // get the element at the specified index
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> current = head.next;
        for (int i = 0; i < index; i++){
            current = current.next;
        }
        return current.element;
    }


    // insert an element
    public void insert(T el){
        //Try to find the last element
        Node<T> n = head;
        while (n.next != null){
            n = n.next;
        }
        Node<T> newNode = new Node<>(el, null);
        n.next = newNode;

        size++;
    }

    // insert an element at the specified index
    public void insert(int index, T el){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> n = head;
        for (int i = 0; i < index; i++){
            n = n.next;
        }
        Node<T> newNode = new Node<>(el, n.next);
        n.next = newNode;

        size++;

    }

    // remove an element at specific index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<T> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
      T element = n.next.element;
        n.next = n.next.next;
        size--;
        return element;
    }
    // check the index of the first occurrence of an element, return -1 if not found
    public int indexOf(T el){
        Node <T> n = head;
        for (int i = 0; i < size; i++) {
            if(n.element.equals(el)){
                return i;
            }
            n = n.next;
            
        }
        return -1;
    }







}

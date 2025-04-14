package week2lab;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Node<Integer> n1 = new Node<>(1, null);
        Node<Integer> n2 = new Node<>(2, null);
        Node<Integer> n3 = new Node<>(3, null);
        Node<Integer> n4 = new Node<>(4, null);
        Node<Integer> n5 = new Node<>(5, null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(n1);
    }
}

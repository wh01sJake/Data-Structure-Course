package week3lab;

public class Node {
    Car car;
    Node next;

    public Node(Car car, Node next) {
        this.car = car;
        this.next = next;
    }

    public Node(Car car) {
        this.car = car;
        this.next = null;
    }


    @Override
    public String toString() {
        return car.toString();
    }
}

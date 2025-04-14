package week3lab;

import week3.DLNode;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        Node current = head;
       while (current != null ) {
           size++;
           current = current.next;
       }
        return size;
    }

    @Override
    public String toString() {
        String output = "Current cars: " +"\n";
        Node current = head;
        while (current != null) {
            output += current.toString()+ "\n";
            output += "*************" + "\n";
            current = current.next;
        }
        return output;
    }

    public int readySize(){
        int size = 0;
        Node current = head;
        while(current != null){
            if(current.car.isReady()){
                size++;

            }
            current = current.next;
        }
        return size;
    }

    public String currentProblems(){
        Node current = head;
        StringBuilder problems = new StringBuilder("\n");
        while(current != null){
            if(!(current.car.isReady())){

                problems.append(current.car.registration).append("\n");

            }
            current = current.next;
        }
        return problems.toString();
    }

    public double get_average(){
        double average;
        int totalCost = 0;
        int counter = 0;
        Node current = head;
        while(current != null) {
            if (!(current.car.isReady())) {
                totalCost += current.car.problemCost;
                counter++;
            }
            current = current.next;
        }
        average = (double)  totalCost /(size()-readySize()); // this should get the number of "fixing" cars. I did this to avoid creating another counter.*/
        return average;
    }

    public void add(Car element) {
        if (isEmpty()) {
            head = new Node(element);
            tail = head;
        }else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        System.out.println(element.registration + " added to the list");
    }

    public void remove(int index) {
        if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();

        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        }
        else {
            Node previous = head;
            for (int i = 0; i < index; i++) {
                previous = previous.next;
            }
            previous.next = previous.next.next;
            if (previous.next == null) {
                head = previous;
            }

        }

    }

    public void remove(String target){
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.car.registration.equals(target)) {
               remove(index);
                System.out.println(target + " removed");
            }
            current = current.next;
            index++;
        }
    }

}

package CA1Sample;

import java.util.NoSuchElementException;

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
        if (isEmpty()) {
            return 0;
        }
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public double get_average() {
        double average;
        double totalGrades = 0;
        int counter = 0;
        if (isEmpty()) {
            return 0;
        }
        Node current = head;
        while (current != null) {
                totalGrades += current.record.getGrade();
                counter++;

            current = current.next;
        }
        average = totalGrades / counter;
        return average;
    }

    public void add(Record record) {
        if (isEmpty()) {
            head = new Node(record);
            tail = head;
        }
        else{
            Node current = head;
            while (current != null) {
                if (current.record.getSubject().equals(record.getSubject())) {
                    current.record.setGrade(record.getGrade());
                    return;
                }
                current = current.next;
            }

            Node newNode = new Node(record);
            tail.next = newNode;
            tail = newNode;

        }
    }


    public void remove (String subject) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (head.record.getSubject().equals(subject)) {
            head = head.next;
            return;
        }

        Node previous = head;
        Node current = head.next;
        while (current != null) {
            if (current.record.getSubject().equals(subject)) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }

        throw new NoSuchElementException();
    }


    public int getCompensationCredits() {
        int compensation = 0;
        Node current = head;
        while (current != null) {
            Record record = current.record;
            if (record.getGrade() >= 35 && record.getGrade() < 40) {
                compensation += record.getCredits();
            }
            current = current.next;
        }
        return compensation;
    }

    public int getTotalCredit(){
        int totalCredits = 0;
        Node current = head;
        while (current != null) {
            totalCredits += current.record.getCredits();
            current = current.next;
        }
        return totalCredits;
    }

    public boolean isPassByCompensation(){

        if (getTotalCredit() != 60) {
            return false;
        }

        int compensation = getCompensationCredits();
        if (compensation != 10) {
            return false;
        }

        double remainingTotal = 0;
        int remainingCredits = 0;
        Node current = head;
        while (current != null) {
            Record record = current.record;
            if (record.getGrade() >= 40) {
                remainingTotal += record.getGrade() * record.getCredits();
                remainingCredits += record.getCredits();
            }
            current = current.next;
        }

        if (remainingCredits != 50) {
            return false;
        }

        return (remainingTotal / remainingCredits) >= 50;

    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(new Record(1,"Data Structure",35.0,10));
        list.add(new Record(1,"Biology",50.0,10));
        list.add(new Record(1,"Physics",50.0,10));
        list.add(new Record(1,"Math",50.0,10));
        list.add(new Record(1,"Cyber Security",50.0,10));
        list.add(new Record(1,"Web Design",50.0,10));

        System.out.println(list.getTotalCredit());

        System.out.println(list.isPassByCompensation()); //true

    }


























}

package CA1Sample2;

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
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    public void add(Movie movie) {
        if (head == null) {
            head = new Node(movie);
            tail = head;

        } else {
            Node newNode = new Node(movie);
            tail.next = newNode;
            tail = newNode;
        }


    }


    public void remove(String title) {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from an empty list.");
        }

        if (head.movie.getTitle().equals(title)) {
            head = head.next;

            //if head is the only node in the list, update tail to null after remove
            if (head == null) {
                tail = null;
            }
            return;
        }

        Node previous = head;
        Node current = head.next;
        while (current != null) {
            if (current.movie.getTitle().equals(title)) {
                previous.next = current.next;

                // if current == tail, update tail to previous node
                if (current == tail) {
                    tail = previous;
                }

                return;
            }
            previous = current;
            current = current.next;
        }

        throw new NoSuchElementException("Element with title '" + title + "' not found.");

    }

    public double get_average() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot get the average of an empty list.");
        }

        double total = 0;
        Node current = head;
        while (current != null) {
            total += current.movie.getRating();
            current = current.next;
        }
        return total / size();
    }


    @Override
    public String toString() {
        String output = "";
        Node temp = head;
        while (temp != null) {
            output += temp.movie.toString() + "\n";
            temp = temp.next;
        }
        return output;
    }


    public String genreSearch(String genre) {
        Node current = head;
        String search = "";
        while (current != null) {
            if (genre.equals(current.movie.getGenre())) {
                search += current.movie.getTitle() + "\n";
            }
            current = current.next;


        }
        return search;

    }

    public static void main(String[] args) {
        LinkedList movies = new LinkedList();
        Movie m1 = new Movie("Movie1", "First Movie", "Action", 120, 5);
        Movie m2 = new Movie("Movie2", "Second Movie", "Horror", 120, 5);
        Movie m3 = new Movie("Movie3", "Third Movie", "Drama", 120, 4);
        Movie m4 = new Movie("Movie4", "Fourth Movie", "Action", 120, 3);
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
        System.out.println(movies.isEmpty() ? "true" : "false");
        System.out.println(movies.get_average());
        System.out.println(movies);




    }

}

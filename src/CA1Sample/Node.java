package CA1Sample;

public class Node {
    Record record;
    Node next;

    public Node(Record record, Node next) {
        this.record = record;
        this.next = next;
    }

    public Node(Record record) {
        this.record = record;
        this.next = null;
    }

    @Override
    public String toString() {
        return record.toString();
    }
}

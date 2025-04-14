package CA1Sample.KiethSolution;

public class Node{
    //Each Node will contain a Subject Object and a Node Object...
    // Remember that we have defined the Subject Object with the characteristics
    // to answer the question.
    Subject s;
    Node next;

    // This constructor will be called when we have the subject object and a reference to the next
    // Node in the Data Structure.
    public Node(Subject s, Node n){
        this.s = s;
        this.next = n;
    }

    // This node will be instantiated when we only have the subject object
    public Node(Subject s){
        this.s = s;
        next = null;
    }


    public String toString(){
        return "Subject: "+s.getModule()+" - Grade: "+s.getGrade()+"%";
    }

    public static void main(String [] args){
        System.out.println("Started Executing");
        //Creating an instance of the a Node passing in a Subject Object
        Node node = new Node(new Subject("Data Structures", 70));
        //printing out the result of a call to the getModule() method for the subject
        System.out.println(node.s.getModule());
    }
}
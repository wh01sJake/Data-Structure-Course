package week2lab;

/*
	This is going to be our Node class. We would like our Node class for our
	Single Linkedlist to have a data piece and a pointer (refrence to the next Node in the list)

	The Node allows us to create an object for our data structure... we would like our object to hold a piece
	of data and point or have a reference to the next object in the linkedList...
	
*/
public class Node<T>{
	//instance variables
	T element;
	Node<T> next;

	//Constructor
	//We need two constructors
	public Node(T element, Node<T> next){
		this.element = element;
		this.next = next;
	}

	// The second constructor is needed when we don't have a Node to point to
	public Node(T el){
		this.element = el;
		this.next = null;
	}

	//Methods
	@Override
	public String toString(){
		return "<Element : "+element+" >";
	}

}

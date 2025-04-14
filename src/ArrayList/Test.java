package ArrayList;

import org.w3c.dom.Node;

import java.util.*;


public class Test {
    public static void print (List<String> arr ) {
        for ( String current : arr ) {
            System.out.println(current );
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList <> ();
        list.add("Hello");
        list.add("World");
        Test.print(list);
        System.out.println("***********************");

        //add a String to the list
        list.add("Hello again");
        Test.print(list);
        System.out.println("***********************");

        // add an Integer
//        list.add(5 );  int can not converted to a string

        // remove the index 0
        list.remove(0);
        Test.print(list);
        System.out.println("***********************");

        // add an item at index 1
        list.add(1,"Goodbye");
        Test.print(list);
        System.out.println("***********************");

        //Remove the first occurrence of a String
        list.remove("Hello");
        Test.print(list);
        System.out.println("***********************");

        // use set to se an item at index 1
        list.set(1,"Goodbye again");
        Test.print(list);
        System.out.println("***********************");

        //test if an object is to be found in the list
        System.out.println(list.contains("Goodbye"));
        System.out.println("***********************");

        // Create a new ArrayList, add 4 Strings then addAll to the previous one
        List <String> newList = new ArrayList <> ();
        newList.add("One");
        newList.add("Two");
        newList.add("Three");
        newList.add("Four");
        list.addAll(newList);
        Test.print(newList);
        System.out.println("***********************");
        Test.print(list);
        System.out.println("***********************");

        //Clear one List and print
        list.clear();
        Test.print(list);
        System.out.println("***********************");

        // Add a Person object to the ArrayList
        List <Person> people = new ArrayList <> ();
        people.add(new Person("John", 20));
        people.add(new Person("Jane", 22));

        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge());
        }

    }
}

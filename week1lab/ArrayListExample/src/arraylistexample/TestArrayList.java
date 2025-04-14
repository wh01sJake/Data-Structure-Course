/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistexample;

import java.util.*;

/**
 *
 * @author Hamilton1
 */
public class TestArrayList {
    public static void main(String[] args) {
        // declare an ArrayList object
        ArrayList<Person> list = new ArrayList<>();

        //Task 1: Create and add three Person type objects to the ArrayList object. 
        //Each element will be added at the end of the list
        //add your code below
        list.add(new Person("Jane",25));
        list.add(new Person("Bob",26));
        list.add(new Person("John",27));

        //Task 2: Print the elements of the ArrayList using a For loop combined with printPerson() method part of the Person class
        //add your code below
        for (Person person : list) {
            System.out.println(person.printPerson());
        }
        System.out.println("****************************");
        //Task 3: Add a Person object (a new person) on the second position of the ArrayList object
        //add your code below
        list.add(1,new Person("Jake",27));
      /*  for (Person person : list) {
            System.out.println(person.printPerson());
        }*/

        //Task 4: Print the elements of the ArrayList using an ITERATOR object to check if the new person was added
        //add your code below
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person.printPerson());
        }

        System.out.println("****************************");
        //Task 5: Remove the element (person) found on first position
        //add your code below
//        list.remove(0);
        Iterator<Person> iterator2 = list.iterator();

        if (iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
        for (Person person : list) {
            System.out.println(person.printPerson());
        }

        //Task7: Check if a person with a given name exists in the ArrayList. If so, print person’s position in the list
        //add your code below
        String nameCheck = "Jake";
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            if (nameCheck.equals(person.getsName())) {
                System.out.println(nameCheck + " is at the position " + i);
                break;
            }
            else {
                System.out.println(nameCheck + " is not in the list");
            }

        }
    }
}

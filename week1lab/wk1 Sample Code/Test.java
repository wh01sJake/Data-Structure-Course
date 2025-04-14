import java.util.*;
public class Test{

  public static void main(String[] args){
    List<Person> people = new ArrayList<>();
    people.add(new Person(21, "Keith"));
    Test.print(people);
  }

  public static void print(List<Person> arr){
    System.out.println("-------------------------");
    for(Person current : arr){
      System.out.println(current);
    }
    System.out.println("-------------------------");
  }
}

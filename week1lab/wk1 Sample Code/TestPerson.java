public class TestPerson{
  public static void main(String []args){
    System.out.println("We are going to test the person class");
    Person p1 = new Person(21, "Keith");
    System.out.println("My person is :: "+p1.getAge());
    System.out.println(p1);
  }
}

public class TestInterface implements HelloInterface{
  public String sayHello(){
    return "Hello World";
  }

  public static void main(String [] args){
    TestInterface my = new TestInterface();
    System.out.println("Just inside the main method");
    System.out.println(my.sayHello());

  }
}

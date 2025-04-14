package week3lab;

public class CarTest {
    public static void main(String[] args) {
        Car c1 = new Car("19-D-21","Kith Maycock","08X 8736271","The car only had 3 wheels",100);
        Car c2 = new Car("12-D-21","Jake","082 8236271","Engine issue",1000);
        Car c3 = new Car("15-D-22","AnotherJake","083 8896271","Missing components",300);
        Car c4 = new Car("12-C-26","BnotherJake","089 8896121","Clean",50);
        Car c5 = new Car("15-D-29","CnotherJake","089 8896535","Engine issue",600);


        c1.setReady(true);
        c2.setReady(true);

        LinkedList myList = new LinkedList();
        myList.add(c1);
        myList.add(c2);
        myList.add(c3);
        myList.add(c4);
        myList.add(c5);
//        System.out.println(myList);
       System.out.println("Is garage empty now? " + myList.isEmpty());
        System.out.println("Total cars at the moment: " + myList.size());
        System.out.println("How many cars are ready to go? " + myList.readySize());
        System.out.println("What are the problems car? " + myList.currentProblems());
       System.out.println("Average cost of fixing car: " + myList.get_average());
        myList.add(new Car("16-D-30","DnotherJake","089 7796535","Engine issue",599));
        myList.remove("15-D-29");


    }
}

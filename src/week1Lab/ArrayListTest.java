package week1Lab;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> myInts = new ArrayList<>(25);
                for (int i = 0; i < 500; i++) {
                    if (myInts.size() == 10) {
                        break;
                    }
                    if (i % 3 == 0){
                        myInts.add(i);
                    }
                }

        System.out.println(myInts);
                myInts.set(5,44);
                System.out.println(myInts);
        System.out.println(myInts.size());
        for (Integer myInt : myInts) {
            System.out.println(myInt);
        }

        for (int i = 0; i < myInts.size(); i++) {
            System.out.print(myInts.get(i) + ",");
        }


    }
}

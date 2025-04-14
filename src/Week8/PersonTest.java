package Week8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ClassName: PersonTest
 * Description:
 * <p>
 * Datetime: 2025/4/8 9:27
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("Alice Doe", 30);
        Person p2 = new Person("Jake Fang", 28);
        Person p3 = new Person("John Wick", 29);


        List<Person> list = Stream.of(p1, p2, p3).collect(Collectors.toCollection(ArrayList::new));

        List<Person> list1 = Arrays.asList(p1, p2, p3);


        list.forEach(System.out::println);

        System.out.println("==================================");
        Collections.sort(list,(o1, o2) -> o1.getAge() - o2.getAge());

        list.forEach(System.out::println);


    }
}

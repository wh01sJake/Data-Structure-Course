package Week8;

/**
 * ClassName: Person
 * Description:
 * <p>
 * Datetime: 2025/4/8 9:27
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Person implements Comparable<Person>{
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

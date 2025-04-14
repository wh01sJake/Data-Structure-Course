package CA1Sample.KiethSolution;

public class Subject{

    // these are the instance variables...every subject has a module (name) and an associated grade
    private String module;
    private int grade;

    public Subject(String module, int grade){
        this.module = module;
        this.grade = grade;
    }

    public Subject(String module){
        this.module = module;
        this.grade = 0;
    }

    // this is a getter method that simply returns the value of the instance variable
    public int getGrade(){
        return grade;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }

    public String getModule(){
        return module;
    }

    public static void main(String [] args){
        System.out.println("Started Executing");
        Subject data = new Subject("Data Structures and Algorithms", 70);
        System.out.println(data.module);
        System.out.println(data.grade);

    }
}
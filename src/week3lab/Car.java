package week3lab;

public class Car {
    String registration;
    String ownerName;
    String contactNumber;
    String problem;
    int problemCost;
    boolean ready;

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public int getProblemCost() {
        return problemCost;
    }

    public void setProblemCost(int problemCost) {
        this.problemCost = problemCost;
    }



    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public Car(String registration, String ownerName, String contactNumber, String problem, int problemCost) {
        this.registration = registration;
        this.ownerName = ownerName;
        this.contactNumber = contactNumber;
        this.problem = problem;
        this.problemCost = problemCost;
        this.ready = false;
    }

    @Override
    public String toString() {

        return "Registration= " + registration + "\n" +
                "Owners Name= " + ownerName + "\n" +
                "Contact Number= " + contactNumber + "\n" +
                "Problem Description= " + problem + "\n" +
                "Cost of Fixing the Problem= €" + problemCost + "\n" +
                "Car Status= " + (ready ? "Ready" : "Not Ready");
    }
}

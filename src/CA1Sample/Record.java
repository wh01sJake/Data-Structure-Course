package CA1Sample;

public class Record {
    private int studentID;
    private String subject;
    private double grade;
    private int credits;


    public Record(int studentID, String subject, double grade, int credits) {
        this.studentID = studentID;
        this.subject = subject;
        this.grade = grade;
        this.setCredits(credits);
    }


    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if (credits != 5 && credits != 10) {
            throw new IllegalArgumentException("Invalid credits");
        }
        this.credits = credits;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return
                "studentID=" + studentID +
                ", subject='" + subject + '\'' +
                ", grade="
                ;
    }
}

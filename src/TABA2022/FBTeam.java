package TABA2022;

public class FBTeam implements Comparable<FBTeam> {
    private String teamName;
    private double budget;
    private int position;


    public FBTeam(String teamName, double budget, int position) {
        this.teamName = teamName;
        this.budget = budget;
        this.position = position;
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "FBTeam{" +
                "teamName='" + teamName + '\'' +
                ", budget=" + budget +
                ", position=" + position +
                '}';
    }

    @Override
    public int compareTo(FBTeam o) {
        return  this.position - o.position;
    }
}

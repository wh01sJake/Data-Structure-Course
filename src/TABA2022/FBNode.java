package TABA2022;

public class FBNode<T> implements Comparable<FBNode<T>> {
    FBTeam team;
    FBNode<T> left;
    FBNode<T> right;

    @Override
    public int compareTo(FBNode<T> o) {
        return this.team.compareTo(o.team);
    }

    public FBNode(FBTeam team) {
        this.team = team;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return team.toString();
    }
}

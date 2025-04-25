package TABA2022;

public class FBNode<T>  {
    protected T team;
    protected FBNode<T> left;
    protected FBNode<T> right;



    public FBNode(T team) {
        this.team = team;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        String leftVal = (left == null ? "NULL" : left.team.toString());
        String rightVal = (right == null ? "NULL" : right.team.toString());

        return  "[Current Team] " + team + "\n[left]" + leftVal + "\n[right]" + rightVal +"\n";
    }
}

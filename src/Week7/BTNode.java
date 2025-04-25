package Week7;

/**
 * Node class for the binary tree.
 *
 * */
public class BTNode<T> {
    protected T data;
    protected BTNode<T> left;
    protected BTNode<T> right;

    public BTNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }


    @Override
    public String toString() {
        String leftVal = left == null ? "null" : left.data.toString();

        String rightVal = right == null ? "null" : right.data.toString();


        return data.toString() + " ";
    }
}

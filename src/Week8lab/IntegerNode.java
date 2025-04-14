package Week8lab;

/**
 * ClassName: IntegerNode
 * Description:
 * <p>
 * Datetime: 2025/4/14 12:33
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class IntegerNode<T> implements Comparable<IntegerNode<T>> {
    T data;
    IntegerNode<T> left;
    IntegerNode<T> right;

    public IntegerNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    @Override
    public int compareTo(IntegerNode<T> o) {
        return this.data.toString().compareTo(o.data.toString());
    }

}

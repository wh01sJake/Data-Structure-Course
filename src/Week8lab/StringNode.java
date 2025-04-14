package Week8lab;

/**
 * ClassName: StringNode
 * Description:
 * <p>
 * Datetime: 2025/4/14 11:28
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class StringNode<T> implements Comparable<StringNode<T>>{
    T data;
    StringNode<T> left;
    StringNode<T> right;


    public StringNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }


    @Override
    public java.lang.String toString() {
        return "StringNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


    @Override
    public int compareTo(StringNode<T> o) {
        return this.data.toString().compareTo(o.data.toString());
    }
}

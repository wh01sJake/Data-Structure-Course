package Week8lab;

/**
 * ClassName: StringTree
 * Description:
 * <p>
 * Datetime: 2025/4/14 11:18
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class StringTree {

    private StringNode<String> root;


    public StringTree() {
        this.root = null;
    }

    public int getStringLength(StringNode<String> node) {
        if (node == null) {
            return 0;
        }
        return node.data.length() + getStringLength(node.left) + getStringLength(node.right);
    }

    public void insert(String data) {
             root = insertNode(data, root);
    }

    private StringNode<String> insertNode(String data, StringNode<String> current) {
        if (current == null) {
            return new StringNode<>(data);
        }

        if (data.compareTo(current.data) < 0) {
            current.left = insertNode(data, current.left);
        } else {
            current.right = insertNode(data, current.right);
        }
        return current;
    }

    public void printString(StringNode<String> node){
        if (node == null) {
            return;
        }

        if (node.data.length() > 5){
            System.out.println(node.data);
        }
        else {
            printString(node.left);
            printString(node.right);
        }
    }

    public static void main(String[] args) {
        StringTree tree = new StringTree();
        tree.insert("Hellooo");
        tree.insert("World");
        tree.insert("This");
        tree.insert("is");
        tree.insert("a");
        tree.insert("test");

        System.out.println(tree.getStringLength(tree.root));

        tree.printString(tree.root);
    }
}

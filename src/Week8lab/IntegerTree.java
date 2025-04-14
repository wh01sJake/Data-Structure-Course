package Week8lab;

/**
 * ClassName: IntegerTree
 * Description: A Binary Search Tree for Integer values with additional operations
 *
 * Datetime: 2023/4/14
 * Version: 1.0
 */
public class IntegerTree {

    private IntegerNode<Integer> root;

    /**
     * Default constructor
     */
    public IntegerTree() {
        root = null;
    }

    /**
     * Insert a new integer into the tree
     * @param element The integer to insert
     */
    public void insert(Integer element) {
        root = insertNode(element, root);
    }

    /**
     * Helper method to recursively insert a node
     * @param element The element to insert
     * @param current The current node being processed
     * @return The updated node
     */
    private IntegerNode<Integer> insertNode(Integer element, IntegerNode<Integer> current) {
        if (current == null) {
            return new IntegerNode<>(element);
        }

        int result = element.compareTo(current.data);

        if (result < 0) {
            current.left = insertNode(element, current.left);
        } else if (result > 0) {
            current.right = insertNode(element, current.right);
        }

        return current;
    }

    /**
     * Check if the tree is empty
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Print the tree in-order
     */
    public void inorder() {
        inorderTraversal(root);
        System.out.println();
    }

    /**
     * Helper method for in-order traversal
     * @param node The current node
     */
    private void inorderTraversal(IntegerNode<Integer> node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    /**
     * Prints all even numbers in the tree
     */
    public void printEvenNumbers() {
        System.out.println("Even numbers in the tree:");
        printEvenNumbers(root);
        System.out.println();
    }

    /**
     * Helper method to recursively print even numbers
     * @param node The current node being processed
     */
    private void printEvenNumbers(IntegerNode<Integer> node) {
        if (node == null) {
            return;
        }

        // Process left subtree
        printEvenNumbers(node.left);

        // Process current node if it's even
        if (node.data % 2 == 0) {
            System.out.print(node.data + " ");
        }

        // Process right subtree
        printEvenNumbers(node.right);
    }

    /**
     * Calculates the sum of all node values in the tree
     * @return The sum of all values
     */
    public int sum() {
        return sum(root);
    }

    /**
     * Helper method to recursively calculate the sum
     * @param node The current node being processed
     * @return The sum of the subtree rooted at node
     */
    private int sum(IntegerNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        // Sum = current node value + sum of left subtree + sum of right subtree
        return node.data + sum(node.left) + sum(node.right);
    }

    /**
     * Calculates the product of all node values in the tree
     * @return The product of all values
     */
    public long product() {
        if (isEmpty()) {
            return 0; // Return 0 for empty tree
        }
        return product(root);
    }

    /**
     * Helper method to recursively calculate the product
     * @param node The current node being processed
     * @return The product of the subtree rooted at node
     */
    private long product(IntegerNode<Integer> node) {
        if (node == null) {
            return 1; // Multiplicative identity
        }

        // Product = current node value * product of left subtree * product of right subtree
        return (long) node.data * product(node.left) * product(node.right);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty Tree";
        }
        StringBuilder sb = new StringBuilder();
        printTree(root, "", true, sb);
        return sb.toString();
    }

    private void printTree(IntegerNode<Integer> node, String prefix, boolean isTail, StringBuilder sb) {
        if (node == null) {
            return;
        }

        // Print right subtree
        if (node.right != null) {
            printTree(node.right, prefix + (isTail ? "    " : "│   "), false, sb);
        }

        // Print current node
        sb.append(prefix).append(isTail ? "└── " : "├── ").append(node.data).append("\n");

        // Print left subtree
        if (node.left != null) {
            printTree(node.left, prefix + (isTail ? "    " : "│   "), true, sb);
        }
    }

    /**
     * Main method to demonstrate the IntegerTree functionality
     */
    public static void main(String[] args) {
        IntegerTree tree = new IntegerTree();

        // Insert some values
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);

        // Print the tree
        System.out.println("Integer Tree:");
        System.out.println(tree);

        // Print in-order traversal
        System.out.println("In-order traversal:");
        tree.inorder();

        // Test the methods
        tree.printEvenNumbers();
        System.out.println("Sum of all values: " + tree.sum());
        System.out.println("Product of all values: " + tree.product());
    }
}

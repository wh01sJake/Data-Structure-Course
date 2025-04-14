package Week7;
/**
 * List of methods when creating a Binary search Tree.
 *
 * */

//
public interface BinaryTree<T extends Comparable<T>> {

    void insert(T element);

    boolean isEmpty();

    int size();

    void inorder();

    T findMax();

    T findMin();

    boolean contains(T element);

    boolean remove(T element);
}

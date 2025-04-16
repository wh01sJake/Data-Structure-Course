package TABA2022;

public interface TeamTree<T extends Comparable<T>> {


    boolean isEmpty();

    void insert(T element);

    int size();

    FBNode<FBTeam> findMin();

    FBNode<FBTeam> findMax();
}

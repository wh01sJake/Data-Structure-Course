package TABA2022;

import Week7.EmptyTreeException;

public class FBTeamTree <T extends Comparable<T>> implements TeamTree<T> {

    protected FBNode<T> root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(T team) {

        root = insert(root, team);

    }

    public FBNode<T> insert(FBNode<T> current, T team){
        if (current == null){
            return  new FBNode<T>(team);
        }

        int result = (team.compareTo(current.team));

        if (result < 0){
            current.left = insert(current.left,team);
        }
        else if (result > 0){
            current.right = insert(current.right, team);
        }

        return current;

    }



    @Override
    public int size() {
        return size(root);
    }

    public int size(FBNode<T> current){
        if (current == null){
            return 0;
        }

        return  1 + size(current.left) + size(current.right);

    }

    @Override
    public FBNode<T> findMin() {
        if (isEmpty()){
            throw  new EmptyTreeException();
        }

        return findMin(root);

    }

    public FBNode<T> findMin(FBNode<T> current){
        while (current.left!= null){
            current= current.left;
        }
        return current;
    }

    @Override
    public FBNode<T> findMax() {
        if (isEmpty()){
            throw new EmptyTreeException();
        }

        return findMax(root);
    }

    public FBNode<T> findMax(FBNode<T> current){
        while (current.right!= null){
            current= current.right;
        }
        return current;
    }

    public void inOrder(){

        inOrder(root);
    }

    public void inOrder(FBNode<T> current){
        if (current == null){
            return;
        }

        inOrder(current.left);
        System.out.println(current);
        inOrder(current.right);

    }


    public static void main(String[] args) {
        FBTeamTree<FBTeam> tree = new FBTeamTree<>();
        tree.insert(new FBTeam("Team A", 1000000, 1));
        tree.insert(new FBTeam("Team B", 2000000, 2));
        tree.insert(new FBTeam("Team C", 3000000, 3));
        tree.insert(new FBTeam("Team D", 4000000, 4));
        tree.insert(new FBTeam("Team E", 5000000, 5));
        System.out.println("min position: " +tree.findMin());
        System.out.println("max position: " +tree.findMax());

        tree.inOrder();

    }


}

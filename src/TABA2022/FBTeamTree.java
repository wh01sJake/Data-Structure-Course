package TABA2022;

import Week7.EmptyTreeException;

public class FBTeamTree implements TeamTree<FBTeam> {
    protected FBNode<FBTeam> root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void insert(FBTeam team) {

        root = insert(root, team);

    }

    public FBNode<FBTeam> insert(FBNode<FBTeam> current, FBTeam team){
        if (current == null){
            return  new FBNode<>(team);
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

    public int size(FBNode<FBTeam> current){
        if (current == null){
            return 0;
        }

        return  1 + size(current.left) + size(current.right);

    }

    @Override
    public FBNode<FBTeam> findMin() {
        if (isEmpty()){
            throw  new EmptyTreeException();
        }

        return findMin(root);

    }

    public FBNode<FBTeam> findMin(FBNode<FBTeam> current){
        while (current.left!= null){
            current= current.left;
        }
        return current;
    }

    @Override
    public FBNode<FBTeam> findMax() {
        if (isEmpty()){
            throw new EmptyTreeException();
        }

        return findMax(root);
    }

    public FBNode<FBTeam> findMax(FBNode<FBTeam> current){
        while (current.right!= null){
            current= current.right;
        }
        return current;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty Tree";
        }
        StringBuilder sb = new StringBuilder();
        inorderToString(root, sb);
        return sb.toString().trim();

    }

    private void inorderToString(FBNode<FBTeam> node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inorderToString(node.left, sb);
        sb.append(node.team.toString()).append("\n");
        inorderToString(node.right, sb);

    }


    public static void main(String[] args) {
        FBTeamTree tree = new FBTeamTree();
        tree.insert(new FBTeam("Team A", 1000000, 1));
        tree.insert(new FBTeam("Team B", 2000000, 2));
        tree.insert(new FBTeam("Team C", 3000000, 3));
        tree.insert(new FBTeam("Team D", 4000000, 4));
        tree.insert(new FBTeam("Team E", 5000000, 5));
        System.out.println("min position: " +tree.findMin());
        System.out.println("max position: " +tree.findMax());

        System.out.println(tree);

    }


}

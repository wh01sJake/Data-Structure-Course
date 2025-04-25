package Week7;


public class KiethBinaryTree<T extends Comparable<T>> implements BinaryTree<T> {

    protected BTNode<T> root;

    //LST < RST at all the stages

    public void insert(T elem) {
        if(isEmpty()){
            root = new BTNode<>(elem);
        }else {
            insertNode(elem,root);
        }
    }

    private void insertNode(T elem, BTNode<T> current){
        //find a place to insert the data
        //compare the data with the root
        if(elem.compareTo(current.data)==-1){
            //add to the left
            if(current.left == null){
                current.left = new BTNode<>(elem);
            } else {
                //recurse down the sub-tree rooted at current.left
                insertNode(elem,current.left);
            }
            // similarly for the right
        }else {
            if(current.right == null){
                current.right = new BTNode<>(elem);
            } else {
                //recurse down the sub-tree rooted at current.left
                insertNode(elem,current.right);
            }
        }
    }

    public boolean isEmpty() {
        //empty tree
        return root == null;
    }

    //lowest values first
    public void inorder() {
        inorder(root);
    }

    
    private void inorder(BTNode<T> current){
        //base case
        if(current == null){
            return;
        }
        inorder(current.left);
        System.out.println(current);
        inorder(current.right);
    }

    public int size() {
        return size(root);
    }

 

    private int size(BTNode<T> current){
        if(current == null){
            return 0;
        } else {
            return 1+size(current.left) + size(current.right);
        }
    }

    public T findMax() {
        if(isEmpty()){
            throw new EmptyTreeException();
        } else{
            return findMax(root);
        }
    }

    //bigger datas are in right subtree
    private T findMax(BTNode<T> current){
        //base case
        if(current.right ==null){
            return current.data;
        }else{
            return findMax(current.right);
        }
    }

    public T findMin() {
        if(isEmpty()){
            throw new EmptyTreeException();
        }else{
            return findMin(root);
        }
    }
    private T findMin(BTNode<T> current){
        //base case
        if(current.left == null){
            return current.data;
        } else {
            return findMin(current.left);
        }
    }

    public boolean contains(T data) {
        return contains(data, root);
    }

    private boolean contains(T data, BTNode<T> current){
        String currentPos = (current == null ? "NULL" : current.data.toString());
        System.out.println("Searching for " + data + " currently at " + currentPos);
        if (current == null){
            return false;
        }

        if (data.compareTo(current.data) == 0){
            System.out.println("We found equality");
            return true;
        } else if (data.compareTo(current.data) <= -1){
            System.out.println("We are going to the left");
            return contains(data, current.left);
        } else {
            System.out.println("Going to the right");
            return contains(data, current.right);
        }
    }

    private BTNode<T> findNode(T elem){
        return findNode(elem, root);
    }

    private BTNode<T> findNode(T elem, BTNode<T> current){
        if (current == null){
            return null;
        }
        if (current.data.equals(elem)){
            return current;
        } else if (current.data.compareTo(elem) == -1){//new is bigger
            return findNode(elem, current.right);
        } else {
            return findNode(elem, current.left);
        }
    }


    public boolean remove(T data) {
        // we need to locate the node which we must remove
        BTNode<T> toRemove = findNode(data);
        if (toRemove == null){
            System.out.println("not found");
            return false;
        }
        System.out.println("toRemove = " + toRemove);
        // we need to find its parent as well
        BTNode<T> parent = findParent(data);
        System.out.println("parent = " + parent);

        // to do the simplest case which is the removal of a leaf node
        if (toRemove.left == null && toRemove.right == null){
            // determine which child it is
            if (toRemove.data.compareTo(parent.data) == -1){
                parent.left = null;
            } else {
                parent.right = null;
            }
            return true;
        } else if (toRemove.left != null && toRemove.right == null){
            // in this case the node has a left child but no right child.
            //its important that we are not getting rid of the Nodes just changing the
            //data piece of the object...
            if (toRemove.data.compareTo(parent.data) == -1){
                // the removed node is the left child
                parent.left = toRemove.left;
            } else {
                // it's the right child
                parent.right = toRemove.left;
            }
            return true;
        } else if (toRemove.left == null && toRemove.right != null){
            if (toRemove.data.compareTo(parent.data) == -1){
                parent.left = toRemove.right;
            } else {
                parent.right = toRemove.right;
            }
            return true;
        } else if (toRemove.left != null && toRemove.right != null){
            // it has both a left and right child
            // find the max value in the left subtree rooted at the current node
            // or the minimum value of the right subTree...
            T minValue = findMin(toRemove.right);
            BTNode<T> replacement = findNode(minValue);
            BTNode<T> replacementParent = findParent(minValue);
            System.out.println("replacementParent = " + replacementParent);

            /*
                T maxValue = findMax(toRemove.right);
                System.out.println("maxValue = " + maxValue);
                TABA2022.solution.BTNode<T> replacement = findNode(maxValue);
                TABA2022.solution.BTNode<T> replacementParent = findParent(maxValue);
          */

            // we dont actually change the value of the Node we simply
            // change the value of the contents...
            replacementParent.left = null;
            toRemove.data = replacement.data;
            return true;
        }
        System.out.println("parent = " + parent);
        return false;
    }
    private BTNode<T> findParent(T data) {
        return findParent(data, root);
    }

    private BTNode<T> findParent(T data, BTNode<T> current) {
        // special case
        if (data.equals(root.data)){
            return null;
        }
        if (data.compareTo(current.data) == -1){
            if (current.left == null){
                // not in the tree
                return null;
            } else if (data.compareTo(current.left.data) == 0){
                return current;
            } else {
                return findParent(data, current.left);
            }
        } else {
            if (current.right == null){
                return null;
            } else if (data.compareTo(current.right.data) == 0) {
                return current;
            } else {
                return findParent(data, current.right);
            }
        }
    }

    public static void main(String[] args){
        KiethBinaryTree<Integer> numbers = new KiethBinaryTree<>();
        numbers.insert(12);
        numbers.insert(4);
        numbers.insert(6);
        numbers.insert(5);
        numbers.insert(8);
        numbers.insert(34);
        numbers.insert(100);
        numbers.insert(2);


        System.out.println("------------------");
        numbers.inorder();

        System.out.println("------------------");
        System.out.println("Size of BST: "+ numbers.size());

        System.out.println("------------------");
        System.out.println("Max elem of BST: "+ numbers.findMax());


        System.out.println("------------------");
        System.out.println("Min elem of BST: "+ numbers.findMin());

        System.out.println("______________________");
        numbers.remove(4);

        System.out.println("______________________");
        numbers.inorder();

        System.out.println("______________________");
    }

}
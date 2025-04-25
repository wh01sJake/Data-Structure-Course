package Week7;

public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
    protected BTNode<T> root;

    public BinarySearchTree() {
        root = null;
    }


    @Override
    public void insert(T element) {
        root = insertNode(element, root);
    }

    private BTNode<T> insertNode(T element, BTNode<T> current) {
        if(current == null) {
            return new BTNode<T>(element);
        }

        int result = element.compareTo(current.data);

        if (result < 0) {
            current.left = insertNode(element, current.left);
        }
        else if (result > 0) {
            current.right = insertNode(element, current.right);
        }

        return current;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BTNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    @Override
    public void inorder() {
        printInOrder(root);
    }

    private void printInOrder(BTNode<T> node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }


    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return findMaxValue(root);
    }

    private T findMaxValue(BTNode<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }




    @Override
    public T findMin() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return findMinValue(root).data;
    }

    private BTNode<T> findMinValue(BTNode<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean contains(T element) {

        return contains(element,root);
    }

    private boolean contains(T element, BTNode<T> current) {
        if (current == null) {
            return false;
        }
        int result = element.compareTo(current.data);

        if (result == 0) {
            return true;
        }

        else if (result < 0) {
            return contains(element, current.left);
        }

        else {
            return contains(element, current.right);
        }
    }

/*    @Override
    public boolean remove(T element) {
        boolean[] isRemoved = new boolean[1];
        root =  removeHelper(element,root,isRemoved);
        return isRemoved[0];
    }

    private TABA2022.solution.BTNode<T> removeHelper(T element, TABA2022.solution.BTNode<T> current, boolean[] isRemoved) {
        // different cases when remove
        // case 1: removing node has no child
        // case 2 : removing node has one child
        // case 3: removing node has two children
        if (current == null) {
            return null;
        }
        int result = element.compareTo(current.data);
        if (result < 0) {
            current.left = removeHelper(element,current.left,isRemoved);
        }
        else if (result > 0) {
            current.right = removeHelper(element,current.right,isRemoved);
        }
        // now we find the target node
        else {
            isRemoved[0] = true;
            if (current.left == null && current.right == null) {
                return null;
            }
            else if (current.left == null ) {
                return current.right;
            }
            else if (current.right == null) {
                return current.left;
            }
            // processing with two children case
            else {
                // find the min node in the right tree
                TABA2022.solution.BTNode<T> mindNode = findMinValue(current.right);
                current.data = mindNode.data;
                current.right = removeHelper(mindNode.data,current.right,isRemoved);
            }
        }
        return current;

    }*/

    @Override
    public boolean remove(T element) {
        BTNode<T> target = findByElement(element,root);
        if (target == null) {
            return false;
        }
        BTNode<T> parent = findParent(element,root);

        // case1: no child
        if(target.left == null && target.right == null) {
            // possible that target is root without child
            if (parent == null) {
                root = null;
            }
            // either right or left is target
            else if (parent.left == target) {
                parent.left = null;
            }
            else  {
                parent.right = null;
            }
        }

        //case2: target has one child
        else if (target.left == null || target.right == null) {
            // either left child or right child
            BTNode<T> child = target.left != null ? target.left : target.right;

            //possible that target is root with one child
            if (parent == null) {
                root = child;
            }
            else if (parent.left == target) {
                // update parent.left to the target child to "remove" the target
                parent.left = child;
            }
            else {
                parent.right = child;
            }
        }

        // case3: target has two child, find the min node in right subtree and replace it.
        else {
            BTNode<T> replace = findMinValue(target.right);

            T replaceData = replace.data;

            BTNode<T> replacedParent = findParent(replaceData,root);

//            //simplify the case to 1 or 2.
//            remove(replaceData);


            if (replacedParent.left == replace){
                replacedParent.left = replace.right;
            }
            else {
                replacedParent.right = replace.right;

            }

            //replace the data of target
            target.data = replaceData;


        }

        return true;
    }

    public BTNode<T> findByElement(T element, BTNode<T> current) {
        while (current != null) {
            int result = element.compareTo(current.data);
            if (result == 0) {
                return current;
            }
            else if (result < 0) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        // return null when no match
        return null;
    }

    public BTNode<T> findParent(T element, BTNode<T> root){
        BTNode<T> parent = null;
        BTNode<T> current = root;
        while (current != null) {
            int result = element.compareTo(current.data);
            if (result == 0) {
                return parent;
            }
            else if (result < 0) {
                parent = current;
                current = current.left;
            }
            else {
                parent = current;
                current = current.right;
            }
        }
        // not match or root
        return null;


    }

    public void inOrder(){

        inOrder(root);
    }

    private void inOrder(BTNode<T> current){
        if (current== null){
            return;
        }

        inOrder(current.left);
        System.out.print(current);
        inOrder(current.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> numbers = new BinarySearchTree<>();
        numbers.insert(12);
        numbers.insert(4);
        numbers.insert(6);
        numbers.insert(5);
        numbers.insert(8);
        numbers.insert(7);  // Add 7 as the right child of 5
        numbers.insert(34);
        numbers.insert(100);
        numbers.insert(2);

        numbers.inOrder();

        numbers.remove(4);
        System.out.println("--------------------------");
        numbers.inorder();


    }
}

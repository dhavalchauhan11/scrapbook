import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchTree {

    /**
     * 1. if newNode < currentNode ==> Traverse LEFT subtree till the end and insert
     * 2. if newNode > currentNode ==> Traverse RIGHT subtree and insert
     * @param currentNode
     * @param newNode
     */
    public void insertRecord(Node currentNode, Node newNode) {

        // new node value less then the current node value
        if(newNode.value < currentNode.value){
            // exit criteria - if reached end on the left side
            if(currentNode.left == null) {
                // Make new node your new left most node
                currentNode.left = newNode;
                System.out.println("Inserting value " + newNode.value+ " to the LEFT of current node " +currentNode.value);
                return;
            } else {
                // keep traversing left where first make left your current and perform next iteration
                insertRecord(currentNode.left,newNode);
            }
        } else {
            // new node value greater than current node value

            // reached right most
            if(currentNode.right == null) {
                currentNode.right = newNode;
                System.out.println("Inserting value " +newNode.value+ " to the RIGHT of the current node " +currentNode.value);
                return;
            }
            // keep traversing right - passing the right subtree
            insertRecord(currentNode.right,newNode);
        }

    }

    public class Node {
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }

    public Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if(root == null) {
            root = node;
            return;
        }

        insertRecord(root,node);
    }

    public ArrayList<Integer> printInOrder(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        printInOrderRec(root,list);
        return list;
    }

    /**
     *
     * @param currentRoot
     * @param list
     */
    private void printInOrderRec(Node currentRoot,ArrayList<Integer> list) {
        if(currentRoot == null)
            return;

        printInOrderRec(currentRoot.left,list);
        list.add(currentRoot.value);
        printInOrderRec(currentRoot.right,list);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(40);
        bst.insert(25);
        bst.insert(10);
        bst.insert(32);
        bst.insert(78);

        System.out.println();

        ArrayList<Integer> list;

        System.out.println("InOrder using Recursion...");
        list = bst.printInOrder();
        System.out.println(Arrays.toString(list.toArray()));


    }

}



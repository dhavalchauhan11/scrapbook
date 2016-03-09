package ch4;

import java.util.*;

/**
 * Created by dhavalchauhan on 2/24/16.
 * http://www.javabeat.net/binary-search-tree-traversal-java/
 * http://www.java2s.com/Code/Java/Collections-Data-Structure/BinaryTree.htm
 * http://www.programcreek.com/2012/12/leetcode-solution-of-binary-tree-inorder-traversal-in-java/
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

//        bst.insert(40);
//        bst.insert(25);
//        bst.insert(10);
//        bst.insert(3);
//        bst.insert(17);
//        bst.insert(30);
//        bst.insert(32);
//        bst.insert(50);
//        bst.insert(93);
//        bst.insert(78);

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
        System.out.println();
        System.out.println("InOrder using Stack...");
        list = bst.printInOrderUsingStack();
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println();

        System.out.println("PostOrder using Recursion...");
        list = bst.printPostOrder();
        System.out.println(Arrays.toString(list.toArray()));


    }

    public Node root;

    public void insert(int value){
        Node node = new Node(value);

        if(root == null){
            root = node;
            return;
        }

        insertRec(root,node);
    }

    /**
     * 1. If currentNode > newNode ==> Traverse left ==> reached end then insert at left
     * 2. If currentNode < newNode ==> Traverse right ==> reached end then insert at right
     * Repeat these two steps...
     *
     * @param currentRoot
     * @param node
     */
    public void insertRec(Node currentRoot, Node node) {

        // current value greater then new node
        if(currentRoot.value > node.value){
            // reached end - no more left nodes
            if(currentRoot.left == null){
                // Make new node the left node
                currentRoot.left = node;
                System.out.println("Inserting value " +node.value+ " to the LEFT of " +currentRoot.value);
                return;
            } else {
                // more nodes to go.. make left current and move on
                insertRec(currentRoot.left,node);
            }
        } else{
            // current less then new - checking right node
            if(currentRoot.right == null){
                currentRoot.right = node;
                System.out.println("Inserting value " +node.value+ " to the RIGHT of " +currentRoot.value);
                return;
            } else {
                // more nodes to go.. make right current and move on
                insertRec(currentRoot.right,node);
            }
        }
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

    public ArrayList<Integer> printInOrderUsingStack(){

        ArrayList<Integer> list = new ArrayList<Integer>();

        if(root == null){
            return list;
        }

        Stack<Node> stack = new Stack<Node>();
        Node current = root;

        while(!stack.isEmpty() || current != null){

            // if current not null , push to the stack and go down the tree to left
            if(current != null){
                stack.push(current);
                current = current.left;
            }

            // if no left child
            // pop stack, process and change current to right
            else{
                Node temp = stack.pop();
                list.add(temp.value);
                current = temp.right;
            }
        }

        return list;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> printPostOrder(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        printPostOrder(root,list);
        return list;
    }

    private void printPostOrder(Node currentRoot, ArrayList<Integer> list) {
        if(currentRoot == null){
            return;
        }

        printPostOrder(currentRoot.left,list);
        printPostOrder(currentRoot.right,list);
        list.add(currentRoot.value);
    }

    public class Node{
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }
}

package ch4;

/**
 * Created by dhavalchauhan on 2/24/16.
 * http://www.javabeat.net/binary-search-tree-traversal-java/
 * http://www.java2s.com/Code/Java/Collections-Data-Structure/BinaryTree.htm
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        Node root = new Node(5);
        System.out.println("Building binary tree with root " +root.value);

        insertRec(root,new Node(1));
        insertRec(root,new Node(8));
        insertRec(root,new Node(6));
        insertRec(root,new Node(3));
        insertRec(root,new Node(9));

    }

    public Node root;

//    public void insert(int value){
//        Node node = new Node(value);
//
//        if(root == null){
//            root = node;
//            return;
//        }
//
//        insertRec(root,node);
//    }

    /**
     * 1. If currentNode > newNode ==> Traverse left ==> reached end then insert at left
     * 2. If currentNode < newNode ==> Traverse right ==> reached end then insert at right
     * Repeat these two steps...
     *
     * @param currentRoot
     * @param node
     */
    public static void insertRec(Node currentRoot, Node node) {

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

    static class Node{
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }
}

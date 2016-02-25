package ch4;

/**
 * Created by dhavalchauhan on 2/24/16.
 */
public class BinarySearchTree {

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
    private void insertRec(Node currentRoot, Node node) {

        // current value greater then new node
        if(currentRoot.value > node.value){
            // reached end - no more left nodes
            if(currentRoot.left == null){
                // Make new node the left node
                currentRoot.left = node;
                return;
            } else {
                // more nodes to go.. make left current and move on
                insertRec(currentRoot.left,node);
            }
        } else{
            // current less then new - checking right node
            if(currentRoot.right == null){
                currentRoot.right = node;
                return;
            } else {
                // more nodes to go.. make right current and move on
                insertRec(currentRoot.right,node);
            }
        }
    }

    private class Node{
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }
}
